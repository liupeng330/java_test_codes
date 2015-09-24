package com.heika.test.services.user;

import com.heika.test.entities.user.WorkPositionInfoEntity;

import java.util.List;

public interface WorkPositionInfoService
{
    List<WorkPositionInfoEntity> getAllWorkPositionInfos();
    List<Integer> getAllIds();
}
