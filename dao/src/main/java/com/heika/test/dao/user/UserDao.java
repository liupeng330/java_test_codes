package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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

    public List<UserEntity> getCommonUsersByUserIds(List<Integer> userIds)
    {
        return getSessionFactory().getCurrentSession()
                .createQuery("from " + UserEntity.class.getSimpleName() + " en where en.userId in (:lst) and en.userType = :type")
                .setParameterList("lst", userIds)
                .setParameter("type", "COMMON")
                .list();
    }
}
