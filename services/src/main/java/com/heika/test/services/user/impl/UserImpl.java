package com.heika.test.services.user.impl;

import com.heika.test.common.Channel;
import com.heika.test.common.SearchUserType;
import com.heika.test.common.UserType;
import com.heika.test.common.VerifyUserStatus;
import com.heika.test.dao.user.UserDao;
import com.heika.test.dao.user.UserInfoDao;
import com.heika.test.dao.verify.VerifyUserStatusDao;
import com.heika.test.entities.user.UserEntity;
import com.heika.test.entities.user.UserMaterialEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import com.heika.test.models.user.User;
import com.heika.test.services.user.UserService;
import com.heika.test.services.user.WorkPositionInfoService;
import com.heika.test.utils.JsonParser;
import com.heika.test.utils.LogHelper;
import com.heika.test.utils.MappingWordUtil;
import com.heika.test.utils.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Transactional
public class UserImpl implements UserService
{
    @Autowired
    UserDao userDao;

    @Autowired
    VerifyUserStatusDao verifyUserStatusDao;

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    LogHelper logHelper;

    @Autowired
    RandomData randomData;

    @Override
    public Integer addUser(boolean isBan, Channel channel, Integer channelId, boolean isFrozen, Integer inviteUserId,
                           String mobile, String nickName, Timestamp registerTime, UserType usertype, Integer version, Timestamp updateTime)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setIsBan(isBan);
        userEntity.setChannel(channel.name());
        userEntity.setChannelId(channelId);
        userEntity.setIsFrozen(isFrozen);
        userEntity.setInviteUserId(inviteUserId);
        userEntity.setMobile(mobile);
        userEntity.setNickName(nickName);
        userEntity.setRegisterTime(registerTime);
        userEntity.setUserType(usertype.name());
        userEntity.setVersion(version);
        userEntity.setUpdateTime(updateTime);

        return addUser(userEntity);
    }

    @Override
    public Integer addUser(UserEntity userEntity)
    {
        logHelper.log("创建UserEntry: " + userEntity.toString());
        return (Integer)userDao.save(userEntity);
    }

    @Override
    public void deleteUser(Integer id)
    {
        logHelper.log("删除UseEntry: userId=" + id);
        userDao.delete(UserEntity.class, id);
    }

    @Override
    public UserEntity getUser(Integer id)
    {
        logHelper.log("获取UserEntry: userId=" + id);
        return userDao.get(UserEntity.class, id);
    }

    @Override
    public UserEntity nextUser()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setIsBan(false);
        userEntity.setChannel(randomData.nextChoice(Channel.BD_IMPORT.name(), Channel.PERSONAL_REGISTER.name()));
        userEntity.setIsBan(false);
        userEntity.setChannelId(randomData.nextChoice(1, 2));
        userEntity.setIsFrozen(false);
        userEntity.setMobile(randomData.nextMobilePhoneNumber());
        userEntity.setNickName(randomData.nextChineseString(2, 3));
        userEntity.setRegisterTime(randomData.nextTimeStamp(5));
        userEntity.setUserType(UserType.COMMON.name());
        userEntity.setVersion(0);
        userEntity.setUpdateTime(randomData.nextTimeStamp(2));

        return userEntity;
    }

    @Override
    public List<User> getUsersFromDB(SearchUserType type, String searchContent, VerifyUserStatus status)
    {
        //从VerifyUserStatus表根据传入的status获取user_id与verify_user_status
        Map<Integer, VerifyUserStatus> userIdsInVerifyUserStatusTable;
        if (status == null)
        {
            userIdsInVerifyUserStatusTable = verifyUserStatusDao.getAllUserIdsAndStatusMap();
        }
        else
        {
            userIdsInVerifyUserStatusTable = verifyUserStatusDao.getAllUserIdsAndStatusMapByStatus(status);
        }

        if(userIdsInVerifyUserStatusTable == null || userIdsInVerifyUserStatusTable.size() == 0)  return null;

        //根据VerifyUserStatus的user_id,与传入的type为手机号与昵称时,查询user表
        List<UserEntity> userEntities = new ArrayList<>();
        switch (type)
        {
            case MOBILE:
                userEntities = userDao.getByUserIdsAndMobilePreSearch(
                        new ArrayList(userIdsInVerifyUserStatusTable.keySet()),
                        searchContent);
                break;
            case NICKNAME:
                userEntities = userDao.getByUserIdsAndNickNamePreSearch(
                        new ArrayList(userIdsInVerifyUserStatusTable.keySet()),
                        searchContent);
                break;
        }

        List<User> ret = new ArrayList<>();
        for(int i=0; i<userEntities.size(); i++)
        {
            User user = new User();
            user.setChannel(userEntities.get(i).getChannel());
            user.setMobile(userEntities.get(i).getMobile());
            user.setUser_id(userEntities.get(i).getUserId().toString());
            user.setVerify_user_status(userIdsInVerifyUserStatusTable.get(userEntities.get(i).getUserId()).toString());

            ret.add(user);
        }
        return null;
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
    public List<User> getUsersFromResponse(String responseBody)
    {
        List<LinkedHashMap<String, String>> data = new JsonParser().jsonGetHashMapList(responseBody, "$.data.rows");
        List<User> users = new ArrayList<>();
        if (data == null)
        {
            return null;
        }
        for (LinkedHashMap<String, String> map : data)
        {
            User user = new User();
            if(map.get("userType") != null) user.setUser_type(map.get("userType"));
            if(map.get("nickName") != null) user.setNick_name(map.get("nickName"));
            if(map.get("mobile") != null) user.setMobile(map.get("mobile"));
            if(map.get("userId") != null)
            {
                Object userId = map.get("userId");
                user.setUser_id(userId.toString());
            }
            if(map.get("realName") != null) user.setReal_name(map.get("realName"));
            if(map.get("idNo") != null) user.setId_no(map.get("idNo"));
            if(map.get("verifyUserStatus") != null) user.setVerify_user_status(map.get("verifyUserStatus"));
            users.add(user);
        }
        return users;
    }
}
