package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VerifyUserDao extends BaseDaoHibernate4<VerifyUserEntity>
{
    public VerifyUserEntity getByVerifyUserId(Integer verifyUserId)
    {
        return this.get(VerifyUserEntity.class, "id", verifyUserId);
    }

    public String getUserNameByVerifyUserId(Integer verifyUserId)
    {
        VerifyUserEntity ret = getByVerifyUserId(verifyUserId);
        if(ret != null)
        {
            return ret.getRealName();
        }
        return null;
    }
}
