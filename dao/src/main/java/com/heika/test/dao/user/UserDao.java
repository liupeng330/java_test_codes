package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UserEntity;

import java.util.List;

public class UserDao extends BaseDaoHibernate4<UserEntity>
{
    public List<UserEntity> getCommonUsers()
    {
        return this.getList(UserEntity.class, "userType", "COMMON");
    }
}
