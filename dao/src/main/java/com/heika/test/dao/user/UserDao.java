package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDaoHibernate4<UserEntity>
{
    public List<UserEntity> getCommonUsers()
    {
        return this.getList(UserEntity.class, "userType", "COMMON");
    }

    public List<UserEntity> getByUserIds(List<Integer> userIds)
    {
        return this.getList(UserEntity.class, "userId", userIds);
    }

    public List<UserEntity> getByUserIdsAndMobilePreSearch(List<Integer> userIds, String mobile)
    {
        List<UserEntity> searchByMobile= new ArrayList<>();
        this.getByUserIds(userIds).forEach(i->
                {
                    if(i.getMobile().startsWith(mobile) && i.getUserType().equals("COMMON"))
                    {
                        searchByMobile.add(i);
                    }
                });
        return searchByMobile;
    }

    public List<UserEntity> getByUserIdsAndNickNamePreSearch(List<Integer> userIds, String nickName)
    {
        List<UserEntity> searchByNickName = new ArrayList<>();
        this.getByUserIds(userIds).forEach(i->
        {
            if(i.getNickName().startsWith(nickName) && i.getUserType().equals("COMMON"))
            {
                searchByNickName.add(i);
            }
        });
        return searchByNickName;
    }
}
