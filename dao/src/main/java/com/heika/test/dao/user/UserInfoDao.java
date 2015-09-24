package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UserInfoEntity;

public class UserInfoDao extends BaseDaoHibernate4<UserInfoEntity>
{
    public void deleteByUserId(Integer userId)
    {
        this.delete(UserInfoEntity.class, "userId", userId);
    }

    public UserInfoEntity getByUserId(Integer userId)
    {
        return this.get(UserInfoEntity.class, "userId", userId);
    }
}
