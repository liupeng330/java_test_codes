package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserInfoResultEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, String> getResults(Integer userId)
    {
        Map<String, String> results = new HashMap<>();
        List<VerifyUserInfoResultEntity> entities = getByUserId(userId);
        for(VerifyUserInfoResultEntity ret: entities)
        {
            results.put(ret.getKey(), ret.getValue());
        }
        return results;
    }
}
