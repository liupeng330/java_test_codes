package com.heika.test.services.user.impl;

import com.heika.test.dao.verify.VerifyRejectReasonDao;
import com.heika.test.services.user.VerifyRejectReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class VerifyRejectReasonImpl implements VerifyRejectReasonService
{
    @Autowired
    VerifyRejectReasonDao verifyRejectReasonDao;

    @Override
    public List<String> getAllRejectCodes()
    {
        return verifyRejectReasonDao.getAllRejectCodes();
    }
}
