package com.heika.test.services.user.impl;

import com.heika.test.common.RealNameVerifyStatusEnum;
import com.heika.test.dao.user.UniversityInfoDao;
import com.heika.test.dao.user.UserInfoDao;
import com.heika.test.dao.user.WorkPositionInfoDao;
import com.heika.test.dao.verify.VerifyUserInfoResultDao;
import com.heika.test.dao.verify.VerifyUserStatusDao;
import com.heika.test.entities.user.UniversityInfoEntity;
import com.heika.test.entities.user.UserInfoEntity;
import com.heika.test.entities.user.WorkPositionInfoEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import com.heika.test.models.user.UserInfoResult;
import com.heika.test.models.user.UserInvestigateDetailResult;
import com.heika.test.services.user.UserInvestigateDetailResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class UserInvestigateDetailResultImpl implements UserInvestigateDetailResultService
{
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    VerifyUserInfoResultDao verifyUserInfoResultDao;

    @Autowired
    VerifyUserStatusDao verifyUserStatusDao;

    @Autowired
    UniversityInfoDao universityInfoDao;

    @Autowired
    WorkPositionInfoDao workPositionInfoDao;

    @Override
    public UserInvestigateDetailResult getInvestigateDetailResultFromDB(Integer userId, RealNameVerifyStatusEnum realNameVerifyStatusEnum)
    {
        UserInvestigateDetailResult result = new UserInvestigateDetailResult();
        VerifyUserStatusEntity vus = verifyUserStatusDao.getByUserId(userId);
        if(vus == null)
        {
            return null;
        }
        result.setOnlineTime(vus.getOnlineTime());

        UserInfoEntity userInfo = userInfoDao.getByUserId(userId);
        UserInfoResult userInfoResult = new UserInfoResult();
        userInfoResult.setAddress(userInfo.getAddress());
        userInfoResult.setChildStatus(userInfo.getChildStatus());
        userInfoResult.setCompany(userInfo.getCompanyName());
        userInfoResult.setCreditCardNumber(userInfo.getCreditCardNumber());
        userInfoResult.setGraduateYear(userInfo.getGraduatedYear().toString());
        userInfoResult.setGraduation(userInfo.getGraduation());
        userInfoResult.setHasCar(userInfo.getHasCar().toString());
        userInfoResult.setHasHouse(userInfo.getHasHouse().toString());
        userInfoResult.setIdCardNo(userInfo.getIdNo());
        userInfoResult.setMarriageStatus(userInfo.getMarriageStatus());
        userInfoResult.setMonthlySalary(userInfo.getMonthlySalary().toString());
        userInfoResult.setPhone(userInfo.getPhone());
        userInfoResult.setRealName(userInfo.getRealName());
        userInfoResult.setRealNameVerifyStatus(realNameVerifyStatusEnum.name());

        UniversityInfoEntity universityInfo = universityInfoDao.getById(userInfo.getUniversityInfoId());
        if(universityInfo != null)
        {
            userInfoResult.setUniversity(universityInfo.getName());
        }

        userInfoResult.setUrgentMobile(userInfo.getUrgentMobile());
        userInfoResult.setUrgentName(userInfo.getUrgentName());
        userInfoResult.setUrgentRelation(userInfo.getUrgentRelation());
        userInfoResult.setWorkPhone(userInfo.getWorkPhone());

        WorkPositionInfoEntity workPositionInfo = workPositionInfoDao.getById(userInfo.getWorkPositionInfoId());
        if(workPositionInfo != null)
        {
            userInfoResult.setWorkPositionInvResult(workPositionInfo.getName());
        }
        setInvResult(userInfoResult, userId);
        result.setUserInfo(userInfoResult);
        return result;
    }

    private void setInvResult(UserInfoResult result, Integer userId)
    {
        Map<String, String> resultInDB = this.verifyUserInfoResultDao.getResults(userId);
        result.setAddressInvResult(resultInDB.get("ADDRESS"));
        result.setChildStatusInvResult(resultInDB.get("CHILD_STATUS"));
        result.setCompanyInvResult(resultInDB.get("COMPANY"));
        result.setCreditCardNumberInvResult(resultInDB.get("CREDIT_CARD_NUMBER"));
        result.setGraduateYearInvResult(resultInDB.get("GRADUATE_YEAR"));
        result.setGraduationInvResult(resultInDB.get("GRADUATION"));
        result.setHasCarInvResult(resultInDB.get("HASCAR"));
        result.setHasHouseInvResult(resultInDB.get("HASHOUSE"));
        result.setMarriageStatusInvResult(resultInDB.get("MARRIAGE_STATUS"));
        result.setMonthlySalaryInvResult(resultInDB.get("MONTHLY_SALARY"));
        result.setPhoneInvResult(resultInDB.get("PHONE"));
        result.setRealNameInvResult(resultInDB.get("REAL_NAME"));
        result.setUniversityInvResult(resultInDB.get("UNIVERSITY"));
        result.setUrgentMobileInvResult(resultInDB.get("URGENT_MOBILE"));
        result.setUrgentNameInvResult(resultInDB.get("URGENT_NAME"));
        result.setUrgentRelationInvResult(resultInDB.get("URGENT_RELATION"));
        result.setWorkPhoneInvResult(resultInDB.get("WORK_PHONE"));
        result.setWorkPositionInvResult(resultInDB.get("WORK_POSITION"));
    }

    @Override
    public UserInvestigateDetailResult getInvestigateDetailResultFromResponse(String response)
    {
        return null;
    }
}
