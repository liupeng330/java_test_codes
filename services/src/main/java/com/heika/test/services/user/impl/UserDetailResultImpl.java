package com.heika.test.services.user.impl;

import com.alibaba.fastjson.JSON;
import com.heika.test.common.StrategyResultEnum;
import com.heika.test.dao.card.CardProductDao;
import com.heika.test.dao.verify.VerifyStrategyOutputDao;
import com.heika.test.dao.verify.VerifyUserDao;
import com.heika.test.dao.verify.VerifyUserStatusDao;
import com.heika.test.entities.verify.VerifyStrategyOutputEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import com.heika.test.models.user.UserDetailResult;
import com.heika.test.models.verify.FirstVerifyNote;
import com.heika.test.models.verify.InvestigateNoteInfo;
import com.heika.test.models.verify.SecondVerifyNote;
import com.heika.test.models.verify.Strategy;
import com.heika.test.services.user.UserDetailResultService;
import com.heika.test.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailResultImpl implements UserDetailResultService
{
    @Autowired
    VerifyUserStatusDao verifyUserStatusDao;

    @Autowired
    VerifyUserDao verifyUserDao;

    @Autowired
    CardProductDao cardProductDao;

    @Autowired
    VerifyStrategyOutputDao verifyStrategyOutputDao;

    @Override
    public UserDetailResult getUserDetailResultFromDB(Integer userId)
    {
        UserDetailResult userDetailResult = new UserDetailResult();
        VerifyUserStatusEntity verifyUserStatusEntity = verifyUserStatusDao.getByUserId(userId);

        //从verifyUserStatus表中获取调查信息
        InvestigateNoteInfo investigateNoteInfo = new InvestigateNoteInfo();
        investigateNoteInfo.setInvestigateNote(verifyUserStatusEntity.getInvestigateNote());
        investigateNoteInfo.setInvestigateTime(String.valueOf(verifyUserStatusEntity.getInvestigateTime().getTime()));
        Integer verifyUserId = null;
        if((verifyUserId = verifyUserStatusEntity.getInvestigateUserId()) != null)
        {
            investigateNoteInfo.setInvestigateUserName(verifyUserDao.getUserNameByVerifyUserId(verifyUserId));
        }
        userDetailResult.setInvestigateNoteInfo(investigateNoteInfo);

        //从verifyUserStatus表中获取一审信息
        FirstVerifyNote firstVerifyNote = new FirstVerifyNote();
        firstVerifyNote.setFirstVerifyAmount(verifyUserStatusEntity.getFirstVerifyAmount().toString());
        firstVerifyNote.setFirstVerifyNote(verifyUserStatusEntity.getFirstVerifyNote());
        firstVerifyNote.setFirstVerifyTime(String.valueOf(verifyUserStatusEntity.getFirstVerifyTime().getTime()));

        Integer cardProductId = null;
        if((cardProductId = verifyUserStatusEntity.getFirstVerifyCardProductId()) != null)
        {
            firstVerifyNote.setFirstVerifyCardProductName(cardProductDao.getCardNameById(cardProductId));
        }

        if((verifyUserId = verifyUserStatusEntity.getFirstVerifyUserId()) != null)
        {
            firstVerifyNote.setFirstVerifyUserName(verifyUserDao.getUserNameByVerifyUserId(verifyUserId));
        }
        userDetailResult.setFirstVerifyNote(firstVerifyNote);

        //从verifyUserStatus表中获取二审信息
        SecondVerifyNote secondVerifyNote = new SecondVerifyNote();
        secondVerifyNote.setSecondVerifyAmount(verifyUserStatusEntity.getSecondVerifyAmount().toString());
        secondVerifyNote.setSecondVerifyNote(verifyUserStatusEntity.getSecondVerifyNote());
        secondVerifyNote.setSecondVerifyTime(String.valueOf(verifyUserStatusEntity.getSecondVerifyTime().getTime()));
        if((cardProductId = verifyUserStatusEntity.getSecondVerifyCardProductId()) != null)
        {
            secondVerifyNote.setSecondVerifyCardProductName(cardProductDao.getCardNameById(cardProductId));
        }
        if((verifyUserId = verifyUserStatusEntity.getSecondVerifyUserId()) != null)
        {
            secondVerifyNote.setSecondVerifyUserName(verifyUserDao.getUserNameByVerifyUserId(verifyUserId));
        }
        userDetailResult.setSecondVerify(secondVerifyNote);

        //从verifyUserStatus表中获取策略引擎结果
        Strategy strategyResult = new Strategy();
        VerifyStrategyOutputEntity verifyStrategyOutputEntity = verifyStrategyOutputDao.getByUserId(userId);
        if(verifyStrategyOutputEntity != null)
        {
            strategyResult.setAmount(verifyStrategyOutputEntity.getAmount().toString());
            strategyResult.setIsOld(verifyStrategyOutputEntity.getIsRrdUser() ? "1" : "0;");
            if((cardProductId = verifyStrategyOutputEntity.getCardProductId()) != null)
            {
                strategyResult.setCardProductId(cardProductDao.getCardNameById(cardProductId));
            }
            String result = null;
            if((result = verifyStrategyOutputEntity.getResult()) != null)
            {
                StrategyResultEnum ret = Enum.valueOf(StrategyResultEnum.class, result);
                if(ret != null)
                {
                    strategyResult.setResult(ret.toString());
                }
            }
        }
        userDetailResult.setStrategy(strategyResult);
        userDetailResult.setYouxinBlackListEnum(verifyUserStatusEntity.getInYouxinBackList());

        return userDetailResult;
    }

    @Override
    public UserDetailResult getUserDetailResultFromResponse(String response)
    {
        String parsedJson = JsonUtil.parseDataFromResponse(response);
        if(StringUtils.isNoneEmpty(parsedJson))
        {
            return JSON.parseObject(parsedJson, UserDetailResult.class);
        }
        return null;
    }
}
