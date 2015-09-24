package com.heika.test.services.user;

import com.heika.test.common.*;
import com.heika.test.entities.user.UserInfoEntity;

import java.sql.Timestamp;

public interface UserInfoService
{
    Integer addUserInfo(Integer userId, String realName, String avatarPath, String birth, Gender gender, String idNO,
                        String homeTownProvince, String homeTownCity, String accountLocationProvince, String accountLocationCity,
                        MarriageStatus marriageStatus, ChildStatus childStatus, Graduation graduation, Integer graduated_year,
                        String address, String phone, boolean hasHouse, Integer houseLoan, boolean hasCar, Integer carLoan,
                        String companyName, String companyProvince, String companyCity, String companyAddress, CompanyType companyType,
                        CompanyIndustry companyIndustry, CompanyScale companyScale, String workPhone, String workEmail, String workYears,
                        Integer monthlySalary, String urgentName, String urgentRelation, String urgentMobile, Integer workPositionInfoId,
                        Integer universityInfoId, Integer regionId, Timestamp createTime, Timestamp updateTime, Integer version);

    Integer addUserInfo(UserInfoEntity userInfoEntity);
    void deleteUserInfo(Integer userId);
    UserInfoEntity getUserInfo(Integer userId);
    UserInfoEntity nextUserInfo(Integer userId, String avaterPath);
}
