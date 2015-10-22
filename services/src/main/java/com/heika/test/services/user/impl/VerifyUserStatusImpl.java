package com.heika.test.services.user.impl;

import com.heika.test.common.VerifyUserStatus;
import com.heika.test.dao.verify.VerifyUserStatusDao;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import com.heika.test.services.user.CardProductService;
import com.heika.test.services.user.VerifyRejectReasonService;
import com.heika.test.services.user.VerifyUserStatusService;
import com.heika.test.utils.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class VerifyUserStatusImpl implements VerifyUserStatusService
{
    @Autowired
    VerifyUserStatusDao verifyUserStatusDao;

    @Autowired
    CardProductService cardProductService;

    @Autowired
    VerifyRejectReasonService verifyRejectReasonService;

    @Autowired
    RandomData randomData;

    @Override
    public Integer addVerifyUserStatus(VerifyUserStatusEntity verifyUserStatusEntity)
    {
        return (Integer) verifyUserStatusDao.save(verifyUserStatusEntity);
    }

    @Override
    public VerifyUserStatusEntity nextUncommitVerifyUserStatus(Integer userId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.UNCOMMIT, null, null, null);
    }

    @Override
    public VerifyUserStatusEntity nextInquireingVerifyUserStatus(Integer userId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.INQUIREING, null, null, null);
    }

    @Override
    public VerifyUserStatusEntity nextInquireSuccessVerifyUserStatus(Integer userId, Integer investigateUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.INQUIRE_SUCCESS, investigateUserId, null, null);
    }

    @Override
    public VerifyUserStatusEntity nextVerifyFailVerifyUserStatus(Integer userId, Integer investigateUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.VERIFY_FAIL, investigateUserId, null, null);
    }

    @Override
    public VerifyUserStatusEntity nextFirstVerifySuccessVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.FIRST_VERIFY_SUCCESS, investigateUserId, firstVerifyUserId, null);
    }

    @Override
    public VerifyUserStatusEntity nextFirstSendBackVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.FIRST_SEND_BACK, investigateUserId, firstVerifyUserId, null);
    }

    @Override
    public VerifyUserStatusEntity nextFirstVerifyRejectVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.FIRST_VERIFY_REJECT, investigateUserId, firstVerifyUserId, null);
    }

    @Override
    public VerifyUserStatusEntity nextSecondVerifySuccessVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.VERIFY_SUCCESS, investigateUserId, firstVerifyUserId, secondVerifyUserId);
    }

    @Override
    public VerifyUserStatusEntity nextSecondSendBackVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.SECOND_SEND_BACK, investigateUserId, firstVerifyUserId, secondVerifyUserId);
    }

    @Override
    public VerifyUserStatusEntity nextSecondVerifyRejectUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId)
    {
        return nextVerifyUserStatusByStatus(userId, VerifyUserStatus.SECOND_VERIFY_REJECT, investigateUserId, firstVerifyUserId, secondVerifyUserId);
    }

    @Override
    public VerifyUserStatusEntity nextVerifyUserStatusByStatus(Integer userId, VerifyUserStatus status, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId)
    {
        VerifyUserStatusEntity entity = new VerifyUserStatusEntity();
        entity.setUserId(userId);
        entity.setCreateTime(randomData.nextTimeStamp(5));
        entity.setUpdateTime(randomData.nextTimeStamp(
                entity.getCreateTime()));
        entity.setVerifyUserStatus(status.name());
        entity.setInYouxinBackList("NOT_IN_BLACK_LIST");
        entity.setVersion(0);

        //未提交状态
        if(status == VerifyUserStatus.UNCOMMIT)
        {
            return entity;
        }
        //提交后，进入待调查状态
        if(status == VerifyUserStatus.INQUIREING)
        {
            setRandomEntityForInquireing(entity);
        }
        //待调查成功，进入一审状态
        //提交后，补件操作
        if(status == VerifyUserStatus.INQUIRE_SUCCESS || status == VerifyUserStatus.VERIFY_FAIL)
        {
            setRandomEntityForInquireSuccess(entity, investigateUserId);
        }
        //一审通过，进入二审状态
        if(status == VerifyUserStatus.FIRST_VERIFY_SUCCESS)
        {
            setRandomEntityForFirstVerifySuccess(entity, investigateUserId, firstVerifyUserId);
        }
        //一审退回
        if(status == VerifyUserStatus.FIRST_SEND_BACK)
        {
            //先设置调查成功的字段
            setRandomEntityForInquireSuccess(entity, investigateUserId);

            //再设置一审退回的字段
            entity.setFirstVerifyTime(randomData.nextTimeStamp(entity.getInvestigateTime()));
            entity.setFirstVerifyUserId(firstVerifyUserId);
            entity.setFirstVerifyNote(randomData.nextChineseString(10));
            entity.setRejectOperation("FIRST_VERIFY");
        }
        //一审退件
        if(status == VerifyUserStatus.FIRST_VERIFY_REJECT)
        {
            //先设置调查成功的字段
            setRandomEntityForInquireSuccess(entity, investigateUserId);

            //设置状态为VERIFY_REJECT
            entity.setVerifyUserStatus(VerifyUserStatus.VERIFY_REJECT.name());

            //再设置退件的字段
            entity.setFirstVerifyTime(randomData.nextTimeStamp(entity.getInvestigateTime()));
            entity.setFirstVerifyUserId(firstVerifyUserId);
            entity.setRejectReasonList(randomData.nextChoice(verifyRejectReasonService.getAllRejectCodes()));
        }
        //二审通过
        if(status == VerifyUserStatus.VERIFY_SUCCESS)
        {
            setRandomEntityForSecondVerifySuccess(entity, investigateUserId, firstVerifyUserId, secondVerifyUserId);
        }
        //二审退回
        if(status == VerifyUserStatus.SECOND_SEND_BACK)
        {
            //先设置一审通过的字段
            setRandomEntityForFirstVerifySuccess(entity, investigateUserId, firstVerifyUserId);

            //再设置二审退回的字段
            entity.setSecondVerifyTime(randomData.nextTimeStamp(entity.getFirstVerifyTime()));
            entity.setSecondVerifyUserId(secondVerifyUserId);
            entity.setSecondVerifyNote(randomData.nextChineseString(10));
            entity.setRejectOperation("SECOND_VERIFY");
        }
        //二审退件
        if(status == VerifyUserStatus.SECOND_VERIFY_REJECT)
        {
            //先设置一审通过的字段
            setRandomEntityForFirstVerifySuccess(entity, investigateUserId, firstVerifyUserId);

            //设置状态为VERIFY_REJECT
            entity.setVerifyUserStatus(VerifyUserStatus.VERIFY_REJECT.name());

            //再设置退件的字段
            entity.setSecondVerifyTime(randomData.nextTimeStamp(entity.getFirstVerifyTime()));
            entity.setSecondVerifyUserId(secondVerifyUserId);
            entity.setRejectReasonList(randomData.nextChoice(verifyRejectReasonService.getAllRejectCodes()));
        }

        return entity;
    }

    @Override
    public void deleteVerifyUserStatusByUserId(Integer userId)
    {
        verifyUserStatusDao.deleteByUserId(userId);
    }

    private void setRandomEntityForInquireing(VerifyUserStatusEntity entity)
    {
        entity.setCommitTime(randomData.nextTimeStamp(entity.getCreateTime()));
    }

    private void setRandomEntityForInquireSuccess(VerifyUserStatusEntity entity, Integer investigateUserId)
    {
        setRandomEntityForInquireing(entity);

        entity.setInvestigateTime(randomData.nextTimeStamp(entity.getCommitTime()));
        entity.setInvestigateNote(randomData.nextChineseString(10));
        entity.setInvestigateUserId(investigateUserId);
        entity.setInvestigateNote(randomData.nextChineseString(3, 10));
    }

    private void setRandomEntityForFirstVerifySuccess(VerifyUserStatusEntity entity, Integer investigatedUserId, Integer firstVerifyUserId)
    {
        setRandomEntityForInquireSuccess(entity, investigatedUserId);

        entity.setFirstVerifyTime(randomData.nextTimeStamp(entity.getInvestigateTime()));
        entity.setFirstVerifyUserId(firstVerifyUserId);
        entity.setFirstVerifyNote(randomData.nextChineseString(3, 10));
        entity.setFirstVerifyAmount(randomData.nextBigDecimal(50000.0));
        entity.setFirstVerifyCardProductId(randomData.nextChoice(cardProductService.getAllIds()));
    }

    private void setRandomEntityForSecondVerifySuccess(VerifyUserStatusEntity entity, Integer investigatedUserId, Integer firstVerifyUserId, Integer secondVerifyUserId)
    {
        setRandomEntityForFirstVerifySuccess(entity, investigatedUserId, firstVerifyUserId);

        entity.setSecondVerifyTime(randomData.nextTimeStamp(entity.getFirstVerifyTime()));
        entity.setSecondVerifyUserId(secondVerifyUserId);
        entity.setSecondVerifyNote(randomData.nextChineseString(3, 10));
        entity.setSecondVerifyAmount(randomData.nextBigDecimal(50000.0));
        entity.setSecondVerifyCardProductId(randomData.nextChoice(cardProductService.getAllIds()));
    }
}
