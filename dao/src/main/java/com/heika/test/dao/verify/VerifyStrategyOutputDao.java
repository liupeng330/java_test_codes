package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyStrategyOutputEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VerifyStrategyOutputDao extends BaseDaoHibernate4<VerifyStrategyOutputEntity>
{
    public VerifyStrategyOutputEntity getByUserId(Integer userId)
    {
        return this.get(VerifyStrategyOutputEntity.class, "userId", userId);
    }
}
