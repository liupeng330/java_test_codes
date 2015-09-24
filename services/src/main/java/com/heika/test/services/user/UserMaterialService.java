package com.heika.test.services.user;

import com.heika.test.common.MaterialType;

public interface UserMaterialService
{
    Integer addUserMaterial(Integer userId, MaterialType type, String path);
    void deleteUserMaterial(Integer id);
}
