package com.heika.test.services.user.impl;

import com.heika.test.dao.user.WorkPositionInfoDao;
import com.heika.test.entities.user.WorkPositionInfoEntity;
import com.heika.test.services.user.WorkPositionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class WorkPositionInfoImpl implements WorkPositionInfoService
{
    @Autowired
    WorkPositionInfoDao workPositionInfoDao;

    @Override
    public List<WorkPositionInfoEntity> getAllWorkPositionInfos()
    {
        return workPositionInfoDao.findAll(WorkPositionInfoEntity.class);
    }

    @Override
    public List<Integer> getAllIds()
    {
        List<Integer> ids = new ArrayList<>();
        for(WorkPositionInfoEntity workPositionInfoEntity: getAllWorkPositionInfos())
        {
            ids.add(workPositionInfoEntity.getId());
        }
        return ids;
    }
}
