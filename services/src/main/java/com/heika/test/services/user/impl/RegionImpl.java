package com.heika.test.services.user.impl;

import com.heika.test.dao.user.RegionDao;
import com.heika.test.entities.user.RegionEntity;
import com.heika.test.services.user.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class RegionImpl implements RegionService
{
    @Autowired
    RegionDao regionDao;

    @Override
    public List<Integer> getAllIds()
    {
        List<RegionEntity> regions = this.regionDao.findAll(RegionEntity.class);
        List<Integer> ids = new ArrayList<>();

        for(RegionEntity regionEntity: regions)
        {
            ids.add(regionEntity.getId());
        }

        return ids;
    }
}
