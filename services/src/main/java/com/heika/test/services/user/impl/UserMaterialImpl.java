package com.heika.test.services.user.impl;

import com.heika.test.common.MaterialType;
import com.heika.test.dao.user.UserMaterialDao;
import com.heika.test.entities.user.UserMaterialEntity;
import com.heika.test.services.user.UserMaterialService;

import java.sql.Timestamp;

import com.heika.test.utils.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserMaterialImpl implements UserMaterialService
{
    @Autowired
    UserMaterialDao userMaterialDao;

    @Autowired
    LogHelper logHelper;

    @Override
    public Integer addUserMaterial(Integer userId, MaterialType type, String path)
    {
        logHelper.log(
                String.format("Creating UserMaterial entry: userId=%d, materialType=%s, path=%s",
                        userId,
                        type,
                        path));
        UserMaterialEntity userMaterialEntity = new UserMaterialEntity();
        userMaterialEntity.setPath(path);
        userMaterialEntity.setType(type.toString());
        userMaterialEntity.setUploadTime(new Timestamp(System.currentTimeMillis()));
        userMaterialEntity.setUserId(userId);
        userMaterialEntity.setVersion(0);

        return (Integer)userMaterialDao.save(userMaterialEntity);
    }

    @Override
    public void deleteUserMaterial(Integer id)
    {
        logHelper.log("Deleting UserMaterial entry: id=" + id);
        userMaterialDao.delete(UserMaterialEntity.class, id);
    }
}
