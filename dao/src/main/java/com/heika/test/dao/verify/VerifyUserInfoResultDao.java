package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserInfoResultEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VerifyUserInfoResultDao extends BaseDaoHibernate4<VerifyUserInfoResultEntity>
{
    public List<VerifyUserInfoResultEntity> getByUserId(Integer userId)
    {
        return this.getList(VerifyUserInfoResultEntity.class, "userId", userId);
    }

    public void updateToPending(Integer userId)
    {
        List<VerifyUserInfoResultEntity> vuirList = getByUserId(userId);
        if(vuirList == null || vuirList.size() == 0 )
        {
            return;
        }

        for(VerifyUserInfoResultEntity vuir: vuirList)
        {
            vuir.setValue("PENDING");
        }
    }
}
