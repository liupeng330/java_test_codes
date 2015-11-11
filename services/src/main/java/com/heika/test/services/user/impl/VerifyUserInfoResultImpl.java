package com.heika.test.services.user.impl;

import com.heika.test.common.VerifyUserInvestigateResultEnum;
import com.heika.test.dao.verify.VerifyUserInfoResultDao;
import com.heika.test.services.user.VerifyUserInfoResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class VerifyUserInfoResultImpl implements VerifyUserInfoResultService
{
    private final static List<String> resultKeys = new ArrayList<>();

    static
    {
        resultKeys.add("ADDRESS");
        resultKeys.add("CHILD_STATUS");
        resultKeys.add("COMPANY");
        resultKeys.add("CREDIT_CARD_NUMBER");
        resultKeys.add("CREDIT_REPORT");
        resultKeys.add("GRADUATE_YEAR");
        resultKeys.add("GRADUATION");
        resultKeys.add("HASCAR");
        resultKeys.add("HASHOUSE");
        resultKeys.add("MARRIAGE_STATUS");
        resultKeys.add("MONTHLY_SALARY");
        resultKeys.add("PHONE");
        resultKeys.add("REAL_NAME");
        resultKeys.add("UNIVERSITY");
        resultKeys.add("URGENT_MOBILE");
        resultKeys.add("URGENT_NAME");
        resultKeys.add("URGENT_RELATION");
        resultKeys.add("WORK_PHONE");
        resultKeys.add("WORK_POSITION");
    }

    @Autowired
    VerifyUserInfoResultDao verifyUserInfoResultDao;

    @Override
    public Map<String, String> getResultsByUserId(Integer userId)
    {
        return this.verifyUserInfoResultDao.getResults(userId);
    }

    @Override
    public Map<String, String> getAllValidResult()
    {
        Map<String, String> result = new HashMap<>();
        for(String key: this.resultKeys)
        {
            result.put(key, VerifyUserInvestigateResultEnum.VALID.name());
        }
        return result;
    }
}
