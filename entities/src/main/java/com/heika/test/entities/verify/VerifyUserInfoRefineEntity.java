package com.heika.test.entities.verify;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@javax.persistence.Table(name = "verify_user_info_refine", schema = "", catalog = "heika_new")
public class VerifyUserInfoRefineEntity
{
    private int id;

    @Id
    @javax.persistence.Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    private int userId;

    @Basic
    @javax.persistence.Column(name = "user_id")
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
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

    private int version;

    @Basic
    @javax.persistence.Column(name = "version")
    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyUserInfoRefineEntity that = (VerifyUserInfoRefineEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (version != that.version) return false;
        if (monthlySalary != null ? !monthlySalary.equals(that.monthlySalary) : that.monthlySalary != null)
            return false;
        if (graduation != null ? !graduation.equals(that.graduation) : that.graduation != null) return false;
        if (graduatedYear != null ? !graduatedYear.equals(that.graduatedYear) : that.graduatedYear != null)
            return false;
        if (marriageStatus != null ? !marriageStatus.equals(that.marriageStatus) : that.marriageStatus != null)
            return false;
        if (childStatus != null ? !childStatus.equals(that.childStatus) : that.childStatus != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (hasHouse != null ? !hasHouse.equals(that.hasHouse) : that.hasHouse != null) return false;
        if (hasCar != null ? !hasCar.equals(that.hasCar) : that.hasCar != null) return false;
        if (urgentName != null ? !urgentName.equals(that.urgentName) : that.urgentName != null) return false;
        if (urgentRelation != null ? !urgentRelation.equals(that.urgentRelation) : that.urgentRelation != null)
            return false;
        if (urgentMobile != null ? !urgentMobile.equals(that.urgentMobile) : that.urgentMobile != null) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (workPositionInfoId != null ? !workPositionInfoId.equals(that.workPositionInfoId) : that.workPositionInfoId != null)
            return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (universityInfoId != null ? !universityInfoId.equals(that.universityInfoId) : that.universityInfoId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (monthlySalary != null ? monthlySalary.hashCode() : 0);
        result = 31 * result + (graduation != null ? graduation.hashCode() : 0);
        result = 31 * result + (graduatedYear != null ? graduatedYear.hashCode() : 0);
        result = 31 * result + (marriageStatus != null ? marriageStatus.hashCode() : 0);
        result = 31 * result + (childStatus != null ? childStatus.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (hasHouse != null ? hasHouse.hashCode() : 0);
        result = 31 * result + (hasCar != null ? hasCar.hashCode() : 0);
        result = 31 * result + (urgentName != null ? urgentName.hashCode() : 0);
        result = 31 * result + (urgentRelation != null ? urgentRelation.hashCode() : 0);
        result = 31 * result + (urgentMobile != null ? urgentMobile.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (workPositionInfoId != null ? workPositionInfoId.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (universityInfoId != null ? universityInfoId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
