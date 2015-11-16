package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UniversityInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityInfoDao extends BaseDaoHibernate4<UniversityInfoEntity>
{
    public UniversityInfoEntity getById(Integer id)
    {
        return this.get(UniversityInfoEntity.class, "id", id);
    }
}
