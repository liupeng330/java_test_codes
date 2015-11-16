package com.heika.test.entities.user;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by admin on 2015/9/6.
 */
@Entity
@javax.persistence.Table(name = "user_info", schema = "", catalog = "heika_new")
public class UserInfoEntity
{
    private Integer id;

    @Id
    @javax.persistence.Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    private Integer userId;

    @Basic
    @javax.persistence.Column(name = "user_id")
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    private String realName;

    @Basic
    @javax.persistence.Column(name = "real_name")
    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    private String creditCardNumber;

    @Basic
    @javax.persistence.Column(name = "credit_card_number")
    public String getCreditCardNumber()
    {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber)
    {
        this.creditCardNumber = creditCardNumber;
    }
    private String avatarPath;

    @Basic
    @javax.persistence.Column(name = "avatar_path")
    public String getAvatarPath()
    {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath)
    {
        this.avatarPath = avatarPath;
    }

    private String birth;

    @Basic
    @javax.persistence.Column(name = "birth")
    public String getBirth()
    {
        return birth;
    }

    public void setBirth(String birth)
    {
        this.birth = birth;
    }

    private String gender;

    @Basic
    @javax.persistence.Column(name = "gender")
    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    private String idNo;

    @Basic
    @javax.persistence.Column(name = "id_no")
    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    private String homeTownProvince;

    @Basic
    @javax.persistence.Column(name = "home_town_province")
    public String getHomeTownProvince()
    {
        return homeTownProvince;
    }

    public void setHomeTownProvince(String homeTownProvince)
    {
        this.homeTownProvince = homeTownProvince;
    }

    private String homeTownCity;

    @Basic
    @javax.persistence.Column(name = "home_town_city")
    public String getHomeTownCity()
    {
        return homeTownCity;
    }

    public void setHomeTownCity(String homeTownCity)
    {
        this.homeTownCity = homeTownCity;
    }

    private String accountLocationProvince;

    @Basic
    @javax.persistence.Column(name = "account_location_province")
    public String getAccountLocationProvince()
    {
        return accountLocationProvince;
    }

    public void setAccountLocationProvince(String accountLocationProvince)
    {
        this.accountLocationProvince = accountLocationProvince;
    }

    private String accountLocationCity;

    @Basic
    @javax.persistence.Column(name = "account_location_city")
    public String getAccountLocationCity()
    {
        return accountLocationCity;
    }

    public void setAccountLocationCity(String accountLocationCity)
    {
        this.accountLocationCity = accountLocationCity;
    }

    private String marriageStatus;

    @Basic
    @javax.persistence.Column(name = "marriage_status")
    public String getMarriageStatus()
    {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus)
    {
        this.marriageStatus = marriageStatus;
    }

    private String childStatus;

    @Basic
    @javax.persistence.Column(name = "child_status")
    public String getChildStatus()
    {
        return childStatus;
    }

    public void setChildStatus(String childStatus)
    {
        this.childStatus = childStatus;
    }

    private String graduation;

    @Basic
    @javax.persistence.Column(name = "graduation")
    public String getGraduation()
    {
        return graduation;
    }

    public void setGraduation(String graduation)
    {
        this.graduation = graduation;
    }

    private Integer graduatedYear;

    @Basic
    @javax.persistence.Column(name = "graduated_year")
    public Integer getGraduatedYear()
    {
        return graduatedYear;
    }

    public void setGraduatedYear(Integer graduatedYear)
    {
        this.graduatedYear = graduatedYear;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "address")
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    private String phone;

    @Basic
    @javax.persistence.Column(name = "phone")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    private Integer hasHouse;

    @Basic
    @javax.persistence.Column(name = "has_house")
    public Integer getHasHouse()
    {
        return hasHouse;
    }

    public void setHasHouse(Integer hasHouse)
    {
        this.hasHouse = hasHouse;
    }

    private Integer houseLoan;

    @Basic
    @javax.persistence.Column(name = "house_loan")
    public Integer getHouseLoan()
    {
        return houseLoan;
    }

    public void setHouseLoan(Integer houseLoan)
    {
        this.houseLoan = houseLoan;
    }

    private Integer hasCar;

    @Basic
    @javax.persistence.Column(name = "has_car")
    public Integer getHasCar()
    {
        return hasCar;
    }

    public void setHasCar(Integer hasCar)
    {
        this.hasCar = hasCar;
    }

    private Integer carLoan;

    @Basic
    @javax.persistence.Column(name = "car_loan")
    public Integer getCarLoan()
    {
        return carLoan;
    }

    public void setCarLoan(Integer carLoan)
    {
        this.carLoan = carLoan;
    }

    private String companyName;

    @Basic
    @javax.persistence.Column(name = "company_name")
    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    private String companyProvince;

    @Basic
    @javax.persistence.Column(name = "company_province")
    public String getCompanyProvince()
    {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince)
    {
        this.companyProvince = companyProvince;
    }

    private String companyCity;

    @Basic
    @javax.persistence.Column(name = "company_city")
    public String getCompanyCity()
    {
        return companyCity;
    }

    public void setCompanyCity(String companyCity)
    {
        this.companyCity = companyCity;
    }

    private String companyAddress;

    @Basic
    @javax.persistence.Column(name = "company_address")
    public String getCompanyAddress()
    {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress)
    {
        this.companyAddress = companyAddress;
    }

    private String companyType;

    @Basic
    @javax.persistence.Column(name = "company_type")
    public String getCompanyType()
    {
        return companyType;
    }

    public void setCompanyType(String companyType)
    {
        this.companyType = companyType;
    }

    private String companyIndustry;

    @Basic
    @javax.persistence.Column(name = "company_industry")
    public String getCompanyIndustry()
    {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry)
    {
        this.companyIndustry = companyIndustry;
    }

    private String companyScale;

    @Basic
    @javax.persistence.Column(name = "company_scale")
    public String getCompanyScale()
    {
        return companyScale;
    }

    public void setCompanyScale(String companyScale)
    {
        this.companyScale = companyScale;
    }

    private String workPhone;

    @Basic
    @javax.persistence.Column(name = "work_phone")
    public String getWorkPhone()
    {
        return workPhone;
    }

    public void setWorkPhone(String workPhone)
    {
        this.workPhone = workPhone;
    }

    private String workEmail;

    @Basic
    @javax.persistence.Column(name = "work_email")
    public String getWorkEmail()
    {
        return workEmail;
    }

    public void setWorkEmail(String workEmail)
    {
        this.workEmail = workEmail;
    }

    private String workYears;

    @Basic
    @javax.persistence.Column(name = "work_years")
    public String getWorkYears()
    {
        return workYears;
    }

    public void setWorkYears(String workYears)
    {
        this.workYears = workYears;
    }

    private Integer monthlySalary;

    @Basic
    @javax.persistence.Column(name = "monthly_salary")
    public Integer getMonthlySalary()
    {
        return monthlySalary;
    }

    public void setMonthlySalary(Integer monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    private String urgentName;

    @Basic
    @javax.persistence.Column(name = "urgent_name")
    public String getUrgentName()
    {
        return urgentName;
    }

    public void setUrgentName(String urgentName)
    {
        this.urgentName = urgentName;
    }

    private String urgentRelation;

    @Basic
    @javax.persistence.Column(name = "urgent_relation")
    public String getUrgentRelation()
    {
        return urgentRelation;
    }

    public void setUrgentRelation(String urgentRelation)
    {
        this.urgentRelation = urgentRelation;
    }

    private String urgentMobile;

    @Basic
    @javax.persistence.Column(name = "urgent_mobile")
    public String getUrgentMobile()
    {
        return urgentMobile;
    }

    public void setUrgentMobile(String urgentMobile)
    {
        this.urgentMobile = urgentMobile;
    }

    private Integer workPositionInfoId;

    @Basic
    @javax.persistence.Column(name = "work_position_info_id")
    public Integer getWorkPositionInfoId()
    {
        return workPositionInfoId;
    }

    public void setWorkPositionInfoId(Integer workPositionInfoId)
    {
        this.workPositionInfoId = workPositionInfoId;
    }

    private Integer universityInfoId;

    @Basic
    @javax.persistence.Column(name = "university_info_id")
    public Integer getUniversityInfoId()
    {
        return universityInfoId;
    }

    public void setUniversityInfoId(Integer universityInfoId)
    {
        this.universityInfoId = universityInfoId;
    }

    private Integer regionId;

    @Basic
    @javax.persistence.Column(name = "region_id")
    public Integer getRegionId()
    {
        return regionId;
    }

    public void setRegionId(Integer regionId)
    {
        this.regionId = regionId;
    }

    private Timestamp createTime;

    @Basic
    @javax.persistence.Column(name = "create_time")
    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    private Timestamp updateTime;

    @Basic
    @javax.persistence.Column(name = "update_time")
    public Timestamp getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }

    private Integer version;

    @Basic
    @javax.persistence.Column(name = "version")
    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (avatarPath != null ? !avatarPath.equals(that.avatarPath) : that.avatarPath != null) return false;
        if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (idNo != null ? !idNo.equals(that.idNo) : that.idNo != null) return false;
        if (homeTownProvince != null ? !homeTownProvince.equals(that.homeTownProvince) : that.homeTownProvince != null)
            return false;
        if (homeTownCity != null ? !homeTownCity.equals(that.homeTownCity) : that.homeTownCity != null) return false;
        if (accountLocationProvince != null ? !accountLocationProvince.equals(that.accountLocationProvince) : that.accountLocationProvince != null)
            return false;
        if (accountLocationCity != null ? !accountLocationCity.equals(that.accountLocationCity) : that.accountLocationCity != null)
            return false;
        if (marriageStatus != null ? !marriageStatus.equals(that.marriageStatus) : that.marriageStatus != null)
            return false;
        if (childStatus != null ? !childStatus.equals(that.childStatus) : that.childStatus != null) return false;
        if (graduation != null ? !graduation.equals(that.graduation) : that.graduation != null) return false;
        if (graduatedYear != null ? !graduatedYear.equals(that.graduatedYear) : that.graduatedYear != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (hasHouse != null ? !hasHouse.equals(that.hasHouse) : that.hasHouse != null) return false;
        if (houseLoan != null ? !houseLoan.equals(that.houseLoan) : that.houseLoan != null) return false;
        if (hasCar != null ? !hasCar.equals(that.hasCar) : that.hasCar != null) return false;
        if (carLoan != null ? !carLoan.equals(that.carLoan) : that.carLoan != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyProvince != null ? !companyProvince.equals(that.companyProvince) : that.companyProvince != null)
            return false;
        if (companyCity != null ? !companyCity.equals(that.companyCity) : that.companyCity != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (companyType != null ? !companyType.equals(that.companyType) : that.companyType != null) return false;
        if (companyIndustry != null ? !companyIndustry.equals(that.companyIndustry) : that.companyIndustry != null)
            return false;
        if (companyScale != null ? !companyScale.equals(that.companyScale) : that.companyScale != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (workEmail != null ? !workEmail.equals(that.workEmail) : that.workEmail != null) return false;
        if (workYears != null ? !workYears.equals(that.workYears) : that.workYears != null) return false;
        if (monthlySalary != null ? !monthlySalary.equals(that.monthlySalary) : that.monthlySalary != null)
            return false;
        if (urgentName != null ? !urgentName.equals(that.urgentName) : that.urgentName != null) return false;
        if (urgentRelation != null ? !urgentRelation.equals(that.urgentRelation) : that.urgentRelation != null)
            return false;
        if (urgentMobile != null ? !urgentMobile.equals(that.urgentMobile) : that.urgentMobile != null) return false;
        if (workPositionInfoId != null ? !workPositionInfoId.equals(that.workPositionInfoId) : that.workPositionInfoId != null)
            return false;
        if (universityInfoId != null ? !universityInfoId.equals(that.universityInfoId) : that.universityInfoId != null)
            return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (avatarPath != null ? avatarPath.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (idNo != null ? idNo.hashCode() : 0);
        result = 31 * result + (homeTownProvince != null ? homeTownProvince.hashCode() : 0);
        result = 31 * result + (homeTownCity != null ? homeTownCity.hashCode() : 0);
        result = 31 * result + (accountLocationProvince != null ? accountLocationProvince.hashCode() : 0);
        result = 31 * result + (accountLocationCity != null ? accountLocationCity.hashCode() : 0);
        result = 31 * result + (marriageStatus != null ? marriageStatus.hashCode() : 0);
        result = 31 * result + (childStatus != null ? childStatus.hashCode() : 0);
        result = 31 * result + (graduation != null ? graduation.hashCode() : 0);
        result = 31 * result + (graduatedYear != null ? graduatedYear.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (hasHouse != null ? hasHouse.hashCode() : 0);
        result = 31 * result + (houseLoan != null ? houseLoan.hashCode() : 0);
        result = 31 * result + (hasCar != null ? hasCar.hashCode() : 0);
        result = 31 * result + (carLoan != null ? carLoan.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyProvince != null ? companyProvince.hashCode() : 0);
        result = 31 * result + (companyCity != null ? companyCity.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (companyType != null ? companyType.hashCode() : 0);
        result = 31 * result + (companyIndustry != null ? companyIndustry.hashCode() : 0);
        result = 31 * result + (companyScale != null ? companyScale.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (workEmail != null ? workEmail.hashCode() : 0);
        result = 31 * result + (workYears != null ? workYears.hashCode() : 0);
        result = 31 * result + (monthlySalary != null ? monthlySalary.hashCode() : 0);
        result = 31 * result + (urgentName != null ? urgentName.hashCode() : 0);
        result = 31 * result + (urgentRelation != null ? urgentRelation.hashCode() : 0);
        result = 31 * result + (urgentMobile != null ? urgentMobile.hashCode() : 0);
        result = 31 * result + (workPositionInfoId != null ? workPositionInfoId.hashCode() : 0);
        result = 31 * result + (universityInfoId != null ? universityInfoId.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
