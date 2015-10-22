package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserStatusLogEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class VerifyUserStatusLogDao extends BaseDaoHibernate4<VerifyUserStatusLogEntity>
{
    public VerifyUserStatusLogEntity getLatestEntityByUserId(Integer userId)
    {
        Query query = this.getSessionFactory()
                .getCurrentSession()
                .createQuery("from " + VerifyUserStatusLogEntity.class.getSimpleName() + " v where v.userId = :userId order by v.createTime desc")
                .setParameter("userId", userId);
        if(query.list().size() > 0)
        {
            return (VerifyUserStatusLogEntity)query.list().get(0);
        }
        return null;
    }
}
