package com.heika.test.services.user.impl;

import com.heika.test.dao.verify.*;
import com.heika.test.entities.verify.VerifyStrategyOutputEntity;
import com.heika.test.services.user.PrepareTestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PrepareTestDataImpl implements PrepareTestDataService
{
    @Autowired
    VerifyUserStatusDao verifyUserStatusDao;

    @Autowired
    VerifyUserInfoResultDao verifyUserInfoResultDao;

    @Autowired
    VerifyUserInfoRefineDao verifyUserInfoRefineDao;

    @Autowired
    VerifyUserStatusLogDao verifyUserStatusLogDao;

    @Autowired
    VerifyStrategyOutputDao verifyStrategyOutputDao;

    @Override
    public void updateUserStatusToINQUIREING(Integer userId)
    {
        verifyUserStatusDao.updateStatusToINQUIREING(userId);
    }

    @Override
    public void updateUserStatusResultToPending(Integer userId)
    {
        this.verifyUserInfoResultDao.updateToPending(userId);
    }

    @Override
    public void cleanupUserInfoRefine(Integer userId)
    {
        this.verifyUserInfoRefineDao.deleteByUserId(userId);
    }

    @Override
    public void cleanupUserStatusLog(Integer userId)
    {
        this.verifyUserStatusLogDao.deleteLogByUserId(userId);
    }

    @Override
    public void cleanupStrategyOutput(Integer userId)
    {
        this.verifyStrategyOutputDao.deleteByUserId(userId);
    }
}
