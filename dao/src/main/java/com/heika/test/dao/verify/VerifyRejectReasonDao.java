package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyRejectReasonEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VerifyRejectReasonDao extends BaseDaoHibernate4<VerifyRejectReasonEntity>
{
    public List<String> getAllRejectCodes()
    {
        List<String> rejectCodes = new ArrayList<>();
        List<VerifyRejectReasonEntity> entities = findAll(VerifyRejectReasonEntity.class);
        for(VerifyRejectReasonEntity entity: entities)
        {
            rejectCodes.add(entity.getReason());
        }
        return rejectCodes;
    }
}
