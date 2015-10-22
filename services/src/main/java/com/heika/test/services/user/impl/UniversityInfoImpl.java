package com.heika.test.services.user.impl;

import com.heika.test.dao.user.UniversityInfoDao;
import com.heika.test.entities.user.UniversityInfoEntity;
import com.heika.test.services.user.UniversityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UniversityInfoImpl implements UniversityInfoService
{
    @Autowired
    UniversityInfoDao universityInfoDao;

    @Override
    public List<Integer> getAllIds()
    {
        List<Integer> ids = new ArrayList<>();
        for(UniversityInfoEntity universityInfoEntity: universityInfoDao.findAll(UniversityInfoEntity.class))
        {
            ids.add(universityInfoEntity.getId());
        }

        return ids;
    }
}
