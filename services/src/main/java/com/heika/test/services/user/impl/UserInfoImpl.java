package com.heika.test.services.user.impl;

import com.heika.test.common.*;
import com.heika.test.dao.user.UserInfoDao;
import com.heika.test.entities.user.UserInfoEntity;
import com.heika.test.services.user.RegionService;
import com.heika.test.services.user.UniversityInfoService;
import com.heika.test.services.user.UserInfoService;
import com.heika.test.services.user.WorkPositionInfoService;
import com.heika.test.utils.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Transactional
@Service
public class UserInfoImpl implements UserInfoService
{
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    RandomData randomData;

    @Autowired
    RegionService regionService;

    @Autowired
    WorkPositionInfoService workPositionInfoService;

    @Autowired
    UniversityInfoService universityInfoService;

    @Override
    public Integer addUserInfo(Integer userId, String realName, String avatarPath, String birth, Gender gender, String idNO,
                               String homeTownProvince, String homeTownCity, String accountLocationProvince, String accountLocationCity,
                               MarriageStatus marriageStatus, ChildStatus childStatus, Graduation graduation, Integer graduated_year,
                               String address, String phone, boolean hasHouse, Integer houseLoan, boolean hasCar, Integer carLoan,
                               String companyName, String companyProvince, String companyCity, String companyAddress,
                               CompanyType companyType, CompanyIndustry companyIndustry, CompanyScale companyScale, String workPhone,
                               String workEmail, String workYears, Integer monthlySalary, String urgentName, String urgentRelation,
                               String urgentMobile, Integer workPositionInfoId, Integer universityInfoId, Integer regionId,
                               Timestamp createTime, Timestamp updateTime, Integer version)
    {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(userId);
        userInfoEntity.setRealName(realName);
        userInfoEntity.setAvatarPath(avatarPath);
        userInfoEntity.setBirth(birth);
        userInfoEntity.setGender(gender.name());
        userInfoEntity.setIdNo(idNO);
        userInfoEntity.setHomeTownProvince(homeTownProvince);
        userInfoEntity.setHomeTownCity(homeTownCity);
        userInfoEntity.setAccountLocationProvince(accountLocationProvince);
        userInfoEntity.setAccountLocationCity(accountLocationCity);
        userInfoEntity.setMarriageStatus(marriageStatus.name());
        userInfoEntity.setChildStatus(childStatus.name());
        userInfoEntity.setGraduation(graduation.name());
        userInfoEntity.setGraduatedYear(graduated_year);
        userInfoEntity.setAddress(address);
        userInfoEntity.setPhone(phone);
        userInfoEntity.setHasHouse(hasHouse ? 1 : 0);
        userInfoEntity.setHouseLoan(houseLoan);
        userInfoEntity.setHasCar(hasCar ? 1 : 0);
        userInfoEntity.setCarLoan(carLoan);
        userInfoEntity.setCompanyName(companyName);
        userInfoEntity.setCompanyProvince(companyProvince);
        userInfoEntity.setCompanyCity(companyCity);
        userInfoEntity.setCompanyAddress(companyAddress);
        userInfoEntity.setCompanyType(companyType.name());
        userInfoEntity.setCompanyIndustry(companyIndustry.name());
        userInfoEntity.setCompanyScale(companyScale.name());
        userInfoEntity.setWorkPhone(workPhone);
        userInfoEntity.setWorkEmail(workEmail);
        userInfoEntity.setWorkYears(workYears);
        userInfoEntity.setMonthlySalary(monthlySalary);
        userInfoEntity.setUrgentName(urgentName);
        userInfoEntity.setUrgentRelation(urgentRelation);
        userInfoEntity.setUrgentMobile(urgentMobile);
        userInfoEntity.setWorkPositionInfoId(workPositionInfoId);
        userInfoEntity.setUniversityInfoId(universityInfoId);
        userInfoEntity.setRegionId(regionId);
        userInfoEntity.setCreateTime(createTime);
        userInfoEntity.setUpdateTime(updateTime);
        userInfoEntity.setVersion(version);

        return (Integer)userInfoDao.save(userInfoEntity);
    }

    @Override
    public Integer addUserInfo(UserInfoEntity userInfoEntity)
    {
        return (Integer)userInfoDao.save(userInfoEntity);
    }

    @Override
    public void deleteUserInfo(Integer userId)
    {
        userInfoDao.deleteByUserId(userId);
    }

    @Override
    public UserInfoEntity getUserInfo(Integer userId)
    {
        return userInfoDao.getByUserId(userId);
    }

    @Override
    public UserInfoEntity nextUserInfo(Integer userId, String avaterPath)
    {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(userId);
        userInfoEntity.setRealName(randomData.nextChineseName());
        userInfoEntity.setAvatarPath(avaterPath);
        userInfoEntity.setBirth(randomData.nextDate("1960-01-01", "1985-12-31"));
        userInfoEntity.setGender(randomData.nextEnumName(Gender.class));
        userInfoEntity.setIdNo(randomData.nextInt(1, 9) + randomData.nextDigits(14));
        userInfoEntity.setHomeTownProvince(randomData.nextChineseString(5, 10));
        userInfoEntity.setHomeTownCity(randomData.nextChineseString(2, 3));
        userInfoEntity.setAccountLocationProvince(randomData.nextChineseString(5, 10));
        userInfoEntity.setAccountLocationCity(randomData.nextChineseString(2, 3));
        userInfoEntity.setMarriageStatus(randomData.nextEnumName(Gender.class));
        userInfoEntity.setChildStatus(randomData.nextEnumName(ChildStatus.class));
        userInfoEntity.setGraduation(randomData.nextEnumName(Graduation.class));
        userInfoEntity.setGraduatedYear(randomData.nextInt(1950, 2010));
        userInfoEntity.setAddress(randomData.nextChineseString(5, 10));
        userInfoEntity.setPhone(randomData.nextDigits(8));
        userInfoEntity.setHasHouse(randomData.nextBit());
        userInfoEntity.setHouseLoan(randomData.nextInt(1000, 100000));
        userInfoEntity.setHasCar(randomData.nextBit());
        userInfoEntity.setCarLoan(randomData.nextInt(1000, 100000));
        userInfoEntity.setCompanyName(randomData.nextChineseString(5, 10));
        userInfoEntity.setCompanyProvince(randomData.nextChineseString(5, 10));
        userInfoEntity.setCompanyCity(randomData.nextChineseString(5, 10));
        userInfoEntity.setCompanyAddress(randomData.nextChineseString(5, 10));
        userInfoEntity.setCompanyType(randomData.nextEnumName(CompanyType.class));
        userInfoEntity.setCompanyIndustry(randomData.nextEnumName(CompanyIndustry.class));
        userInfoEntity.setCompanyScale(randomData.nextEnumName(CompanyScale.class));
        userInfoEntity.setWorkPhone(randomData.nextDigits(8));
        userInfoEntity.setWorkEmail(randomData.nextEmail());
        userInfoEntity.setWorkYears(randomData.nextDate("1990-01-01", "2013-01-01"));
        userInfoEntity.setMonthlySalary(randomData.nextInt(10000, 1000000));
        userInfoEntity.setUrgentName(randomData.nextChineseName());
        userInfoEntity.setUrgentRelation(randomData.nextChineseString(2));
        userInfoEntity.setUrgentMobile(randomData.nextMobilePhoneNumber());
        userInfoEntity.setWorkPositionInfoId(randomData.nextChoice(workPositionInfoService.getAllIds()));
        userInfoEntity.setUniversityInfoId(randomData.nextChoice(universityInfoService.getAllIds()));
        userInfoEntity.setRegionId(randomData.nextChoice(regionService.getAllIds()));
        userInfoEntity.setCreateTime(randomData.nextTimeStamp(2));
        userInfoEntity.setUpdateTime(randomData.nextTimeStamp(3));
        userInfoEntity.setVersion(0);

        return userInfoEntity;
    }
}
