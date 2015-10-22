package com.heika.test.services.user.impl;

import com.heika.test.common.SearchUserType;
import com.heika.test.common.UserTypeForSearch;
import com.heika.test.common.VerifyUserStatus;
import com.heika.test.dao.user.UserDao;
import com.heika.test.dao.user.UserInfoDao;
import com.heika.test.dao.verify.VerifyUserDao;
import com.heika.test.dao.verify.VerifyUserStatusDao;
import com.heika.test.dao.verify.VerifyUserStatusLogDao;
import com.heika.test.entities.user.UserEntity;
import com.heika.test.entities.user.UserInfoEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import com.heika.test.entities.verify.VerifyUserStatusLogEntity;
import com.heika.test.models.user.UserSearchResult;
import com.heika.test.services.user.UserSearchService;
import com.heika.test.utils.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Transactional
@Service
public class UserSearchImpl implements UserSearchService
{
    @Autowired
    UserDao userDao;

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    VerifyUserDao verifyUserDao;

    @Autowired
    VerifyUserStatusDao verifyUserStatusDao;

    @Autowired
    VerifyUserStatusLogDao verifyUserStatusLogDao;

    private List<UserSearchResult> getAllUsersFromDB(VerifyUserStatus status)
    {
        //从VerifyUserStatus表根据传入的status获取user_id与verify_user_status
        List<VerifyUserStatusEntity> verifyUserStatusEntities = status==null ? verifyUserStatusDao.getAll():verifyUserStatusDao.getByStatus(status);
        if(verifyUserStatusEntities == null || verifyUserStatusEntities.size() == 0)
        {
            return new ArrayList<>();
        }

        List<Integer> userIds = new ArrayList<>();
        verifyUserStatusEntities.forEach(i->userIds.add(i.getUserId()));

        //根据VerifyUserStatus表的userId找到所有对应的user表中的信息
        List<UserEntity> userEntities = userDao.getCommonUsersByUserIds(userIds);

        List<UserSearchResult> ret = new ArrayList<>();
        for(int i=0; i < userEntities.size(); i++)
        {
            UserSearchResult user = new UserSearchResult();
            UserEntity userEntity = userEntities.get(i);
            Integer userId = userEntity.getUserId();

            user.setUser_id(userId.toString());
            user.setMobile(userEntity.getMobile());
            user.setNick_name(userEntity.getNickName());
            user.setUser_type(Enum.valueOf(UserTypeForSearch.class,
                    userEntity.getChannel()).toString());

            VerifyUserStatusEntity verifyUserStatusEntity = verifyUserStatusDao.getByUserId(userId);
            user.setVerify_user_status(Enum.valueOf(VerifyUserStatus.class,
                    verifyUserStatusEntity.getVerifyUserStatus()).toString());

            UserInfoEntity userInfoEntity = userInfoDao.getByUserId(userId);
            if(userInfoEntity != null)
            {
                user.setId_no(userInfoEntity.getIdNo());
                user.setReal_name(userInfoEntity.getRealName());
            }

            VerifyUserStatusLogEntity latestLog = verifyUserStatusLogDao.getLatestEntityByUserId(userId);
            if(!user.getVerify_user_status().equals(VerifyUserStatus.UNCOMMIT.toString()) && latestLog != null)
            {
                if(latestLog.getVerifyUserId() != null) user.setOperater(verifyUserDao.getByVerifyUserId(latestLog.getVerifyUserId()).getRealName());
                if(latestLog.getCreateTime() != null) user.setOperateTime(latestLog.getCreateTime().getTime() + "");
            }

            ret.add(user);
        }

        return ret;
    }

    @Override
    public List<UserSearchResult> getUsersFromDB(SearchUserType type, String searchContent, VerifyUserStatus status)
    {
        List<UserSearchResult> allUsers = getAllUsersFromDB(status);

        if(type == null)
        {
            return allUsers;
        }

        //开始按输入参数过滤
        switch (type)
        {
            case MOBILE:
                return UserSearchResult.filteredByMobile(allUsers, searchContent);
            case NICKNAME:
                return UserSearchResult.filteredByNickName(allUsers, searchContent);
            case IDCARD:
                return UserSearchResult.filteredByIDCard(allUsers, searchContent);
            case USERNAME:
                return UserSearchResult.filteredByUserName(allUsers, searchContent);
            default:
                throw new RuntimeException("Fail to search by type " + type.name());
        }
    }

    @Override
    public Integer getTotalCountForSearchUser()
    {
        //Get all user from `user` table
        List<UserEntity> allUsers = userDao.getCommonUsers();
        List<Integer> userIds = new ArrayList<>();
        allUsers.forEach(i->userIds.add(i.getUserId()));

        //Using uesr_id from `user` table to search in `verify_user_status` table
        return verifyUserStatusDao.getByUserIds(userIds).size();
    }

    @Override
    public List<UserSearchResult> getUsersFromResponse(String responseBody)
    {
        List<LinkedHashMap<String, String>> data = new JsonParser().jsonGetHashMapList(responseBody, "$.data.rows");
        List<UserSearchResult> users = new ArrayList<>();
        if (data == null)
        {
            return null;
        }
        for (LinkedHashMap<String, String> map : data)
        {
            UserSearchResult user = new UserSearchResult();
            if(map.get("userType") != null) user.setUser_type(map.get("userType"));
            if(map.get("nickName") != null) user.setNick_name(map.get("nickName"));
            if(map.get("mobile") != null) user.setMobile(map.get("mobile"));
            if(map.get("userId") != null)
            {
                Object tmp = map.get("userId");
                user.setUser_id(tmp.toString());

            }
            if(map.get("realName") != null) user.setReal_name(map.get("realName"));
            if(map.get("idNo") != null) user.setId_no(map.get("idNo"));
            if(map.get("verifyUserStatus") != null) user.setVerify_user_status(map.get("verifyUserStatus"));
            if(map.get("operater") != null) user.setOperater(map.get("operater"));
            if(map.get("operateTime") != null)
            {
                Object tmp = map.get("operateTime");
                user.setOperateTime(tmp.toString());
            }

            users.add(user);
        }
        return users;
    }
}
