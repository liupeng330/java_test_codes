package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.WorkPositionInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WorkPositionInfoDao extends BaseDaoHibernate4<WorkPositionInfoEntity>
{
    public WorkPositionInfoEntity getById(Integer id)
    {
        return this.get(WorkPositionInfoEntity.class, "id", id);
    }

}
