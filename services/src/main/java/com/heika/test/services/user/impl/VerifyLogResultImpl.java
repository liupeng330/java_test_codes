package com.heika.test.services.user.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.heika.test.common.VerifyUserStatus;
import com.heika.test.common.VerifyUserStatusOperateEnum;
import com.heika.test.dao.card.CardProductDao;
import com.heika.test.dao.verify.VerifyUserDao;
import com.heika.test.dao.verify.VerifyUserStatusLogDao;
import com.heika.test.entities.verify.VerifyUserStatusLogEntity;
import com.heika.test.models.verify.VerifyLogResult;
import com.heika.test.services.user.VerifyLogResultService;
import com.heika.test.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VerifyLogResultImpl implements VerifyLogResultService
{
    @Autowired
    VerifyUserStatusLogDao verifyUserStatusLogDao;

    @Autowired
    VerifyUserDao verifyUserDao;

    @Autowired
    CardProductDao cardProductDao;

    @Override
    public List<VerifyLogResult> getVerifyLogResultFromDB(Integer userId)
    {
        List<VerifyUserStatusLogEntity> logs = this.verifyUserStatusLogDao.getLogByUserId(userId);
        List<VerifyLogResult> ret = new ArrayList<>();
        if(logs != null)
        {
            for(VerifyUserStatusLogEntity log: logs)
            {
                VerifyLogResult logResult = new VerifyLogResult();
                if(log.getAmount() != null) logResult.setAmount(log.getAmount());
                if(log.getCreateTime() != null) logResult.setCreateTime(String.valueOf(log.getCreateTime().getTime()));
                if(log.getNote() != null) logResult.setNote(log.getNote());
                if(log.getOperation() != null) logResult.setOperation(Enum.valueOf(VerifyUserStatusOperateEnum.class, log.getOperation()).toString());
                if(log.getOperationResult() != null) logResult.setOperationResult(Enum.valueOf(VerifyUserStatus.class, log.getOperationResult()).toString());

                String verifyUser = null;
                if(log.getVerifyUserId() != null)
                {
                    if ((verifyUser = verifyUserDao.getUserNameByVerifyUserId(log.getVerifyUserId())) != null)
                    {
                        logResult.setVerifyUser(verifyUser);
                    }
                }

                String level = null;
                if(log.getCardProductId() != null)
                {
                    if ((level = cardProductDao.getCardNameById(log.getCardProductId())) != null)
                    {
                        logResult.setLevel(level);
                    }
                }
                ret.add(logResult);
            }
        }
        return ret;
    }

    @Override
    public List<VerifyLogResult> getVerifyLogResultFromResponse(String response)
    {
        String parsedJson = JsonUtil.parseDataFromResponse(response);
        JSONObject obj = new JSONObject(parsedJson);
        if(obj != null)
        {
            parsedJson = obj.get("userVerifyLog").toString();
        }
        List<VerifyLogResult> ret = null;
        if(StringUtils.isNoneEmpty(parsedJson))
        {
            ret = JSON.parseObject(parsedJson, new TypeReference<List<VerifyLogResult>>(){});
        }
        return ret;
    }
}
