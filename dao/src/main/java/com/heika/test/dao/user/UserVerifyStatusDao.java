package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UserVerifyStatusEntity;

public class UserVerifyStatusDao extends BaseDaoHibernate4<UserVerifyStatusEntity>
{
    public UserVerifyStatusEntity getByUserId(Integer userId)
    {
        return this.get(UserVerifyStatusEntity.class, "userId", userId);
    }

    public Integer getIdCardFrontIdByUserId(Integer userId)
    {
        UserVerifyStatusEntity uvs = getByUserId(userId);
        if(uvs == null)
        {
            return null;
        }
        return uvs.getIdcardFrontId();
    }

    public Integer getIdCardBackIdByUserId(Integer userId)
    {
        UserVerifyStatusEntity uvs = getByUserId(userId);
        if(uvs == null)
        {
            return null;
        }
        return uvs.getIdcardBackId();
    }
}
