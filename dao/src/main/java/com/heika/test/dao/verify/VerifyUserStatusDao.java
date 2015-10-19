package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserStatusEntity;

import java.util.List;

public class VerifyUserStatusDao extends BaseDaoHibernate4<VerifyUserStatusEntity>
{
    public void deleteByUserId(Integer userId)
    {
        this.delete(VerifyUserStatusEntity.class, "userId", userId);
    }

    public VerifyUserStatusEntity getByUserId(Integer userId)
    {
        return this.get(VerifyUserStatusEntity.class, "userId", userId);
    }

    public List<VerifyUserStatusEntity> getByUserIds(List<Integer> userIds)
    {
        return this.get(VerifyUserStatusEntity.class, "userId", userIds);
    }
}
