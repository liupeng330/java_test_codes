package com.heika.test.dao.verify;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.verify.VerifyUserStatusLogEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VerifyUserStatusLogDao extends BaseDaoHibernate4<VerifyUserStatusLogEntity>
{
    public VerifyUserStatusLogEntity getLatestEntityByUserId(Integer userId)
    {
        Query query = this.getSessionFactory()
                .getCurrentSession()
                .createQuery("from " + VerifyUserStatusLogEntity.class.getSimpleName() + " v where v.userId = :userId order by v.createTime desc")
                .setParameter("userId", userId);
        query.setFirstResult(0);
        query.setMaxResults(1);

        List<VerifyUserStatusLogEntity> result = query.list();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<VerifyUserStatusLogEntity> getLogByUserId(Integer userId)
    {
        Query query = this.getSessionFactory()
                .getCurrentSession()
                .createQuery("from " + VerifyUserStatusLogEntity.class.getSimpleName() + " v where v.userId = :userId order by v.createTime")
                .setParameter("userId", userId);
        return query.list();
    }
}
