package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserInfoRefineEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VerifyUserInfoRefineDao extends BaseDaoHibernate4<VerifyUserInfoRefineEntity>
{
    public void deleteByUserId(Integer userId)
    {
        this.delete(VerifyUserInfoRefineEntity.class, "userId", userId);
    }
}
