package com.heika.test.entities.user;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by admin on 2015/9/6.
 */
@Entity
@javax.persistence.Table(name = "user_verify_status", schema = "", catalog = "heika_new")
public class UserVerifyStatusEntity
{
    private Integer id;

    @Id
    @javax.persistence.Column(name = "id")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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

    private Timestamp firstVerifyDue;

    @Basic
    @javax.persistence.Column(name = "first_verify_due")
    public Timestamp getFirstVerifyDue()
    {
        return firstVerifyDue;
    }

    public void setFirstVerifyDue(Timestamp firstVerifyDue)
    {
        this.firstVerifyDue = firstVerifyDue;
    }

    private String idcardBackComment;

    @Basic
    @javax.persistence.Column(name = "idcard_back_comment")
    public String getIdcardBackComment()
    {
        return idcardBackComment;
    }

    public void setIdcardBackComment(String idcardBackComment)
    {
        this.idcardBackComment = idcardBackComment;
    }

    private Integer idcardBackId;

    @Basic
    @javax.persistence.Column(name = "idcard_back_id")
    public Integer getIdcardBackId()
    {
        return idcardBackId;
    }

    public void setIdcardBackId(Integer idcardBackId)
    {
        this.idcardBackId = idcardBackId;
    }

    private Integer idcardBackOperatorId;

    @Basic
    @javax.persistence.Column(name = "idcard_back_operator_id")
    public Integer getIdcardBackOperatorId()
    {
        return idcardBackOperatorId;
    }

    public void setIdcardBackOperatorId(Integer idcardBackOperatorId)
    {
        this.idcardBackOperatorId = idcardBackOperatorId;
    }

    private Timestamp idcardBackPassTime;

    @Basic
    @javax.persistence.Column(name = "idcard_back_pass_time")
    public Timestamp getIdcardBackPassTime()
    {
        return idcardBackPassTime;
    }

    public void setIdcardBackPassTime(Timestamp idcardBackPassTime)
    {
        this.idcardBackPassTime = idcardBackPassTime;
    }

    private String idcardBackStatus;

    @Basic
    @javax.persistence.Column(name = "idcard_back_status")
    public String getIdcardBackStatus()
    {
        return idcardBackStatus;
    }

    public void setIdcardBackStatus(String idcardBackStatus)
    {
        this.idcardBackStatus = idcardBackStatus;
    }

    private String idcardFrontComment;

    @Basic
    @javax.persistence.Column(name = "idcard_front_comment")
    public String getIdcardFrontComment()
    {
        return idcardFrontComment;
    }

    public void setIdcardFrontComment(String idcardFrontComment)
    {
        this.idcardFrontComment = idcardFrontComment;
    }

    private Integer idcardFrontId;

    @Basic
    @javax.persistence.Column(name = "idcard_front_id")
    public Integer getIdcardFrontId()
    {
        return idcardFrontId;
    }

    public void setIdcardFrontId(Integer idcardFrontId)
    {
        this.idcardFrontId = idcardFrontId;
    }

    private Integer idcardFrontOperatorId;

    @Basic
    @javax.persistence.Column(name = "idcard_front_operator_id")
    public Integer getIdcardFrontOperatorId()
    {
        return idcardFrontOperatorId;
    }

    public void setIdcardFrontOperatorId(Integer idcardFrontOperatorId)
    {
        this.idcardFrontOperatorId = idcardFrontOperatorId;
    }

    private Timestamp idcardFrontPassTime;

    @Basic
    @javax.persistence.Column(name = "idcard_front_pass_time")
    public Timestamp getIdcardFrontPassTime()
    {
        return idcardFrontPassTime;
    }

    public void setIdcardFrontPassTime(Timestamp idcardFrontPassTime)
    {
        this.idcardFrontPassTime = idcardFrontPassTime;
    }

    private String idcardFrontStatus;

    @Basic
    @javax.persistence.Column(name = "idcard_front_status")
    public String getIdcardFrontStatus()
    {
        return idcardFrontStatus;
    }

    public void setIdcardFrontStatus(String idcardFrontStatus)
    {
        this.idcardFrontStatus = idcardFrontStatus;
    }

    private String idcardNoComment;

    @Basic
    @javax.persistence.Column(name = "idcard_no_comment")
    public String getIdcardNoComment()
    {
        return idcardNoComment;
    }

    public void setIdcardNoComment(String idcardNoComment)
    {
        this.idcardNoComment = idcardNoComment;
    }

    private Timestamp idcardNoPassTime;

    @Basic
    @javax.persistence.Column(name = "idcard_no_pass_time")
    public Timestamp getIdcardNoPassTime()
    {
        return idcardNoPassTime;
    }

    public void setIdcardNoPassTime(Timestamp idcardNoPassTime)
    {
        this.idcardNoPassTime = idcardNoPassTime;
    }

    private String idcardNoStatus;

    @Basic
    @javax.persistence.Column(name = "idcard_no_status")
    public String getIdcardNoStatus()
    {
        return idcardNoStatus;
    }

    public void setIdcardNoStatus(String idcardNoStatus)
    {
        this.idcardNoStatus = idcardNoStatus;
    }

    private Boolean pbcApplied;

    @Basic
    @javax.persistence.Column(name = "pbc_applied")
    public Boolean getPbcApplied()
    {
        return pbcApplied;
    }

    public void setPbcApplied(Boolean pbcApplied)
    {
        this.pbcApplied = pbcApplied;
    }

    private String pbcComment;

    @Basic
    @javax.persistence.Column(name = "pbc_comment")
    public String getPbcComment()
    {
        return pbcComment;
    }

    public void setPbcComment(String pbcComment)
    {
        this.pbcComment = pbcComment;
    }

    private Integer pbcId;

    @Basic
    @javax.persistence.Column(name = "pbc_id")
    public Integer getPbcId()
    {
        return pbcId;
    }

    public void setPbcId(Integer pbcId)
    {
        this.pbcId = pbcId;
    }

    private Integer pbcOperatorId;

    @Basic
    @javax.persistence.Column(name = "pbc_operator_id")
    public Integer getPbcOperatorId()
    {
        return pbcOperatorId;
    }

    public void setPbcOperatorId(Integer pbcOperatorId)
    {
        this.pbcOperatorId = pbcOperatorId;
    }

    private Timestamp pbcPassTime;

    @Basic
    @javax.persistence.Column(name = "pbc_pass_time")
    public Timestamp getPbcPassTime()
    {
        return pbcPassTime;
    }

    public void setPbcPassTime(Timestamp pbcPassTime)
    {
        this.pbcPassTime = pbcPassTime;
    }

    private String pbcStatus;

    @Basic
    @javax.persistence.Column(name = "pbc_status")
    public String getPbcStatus()
    {
        return pbcStatus;
    }

    public void setPbcStatus(String pbcStatus)
    {
        this.pbcStatus = pbcStatus;
    }

    private Timestamp secondVerifyDue;

    @Basic
    @javax.persistence.Column(name = "second_verify_due")
    public Timestamp getSecondVerifyDue()
    {
        return secondVerifyDue;
    }

    public void setSecondVerifyDue(Timestamp secondVerifyDue)
    {
        this.secondVerifyDue = secondVerifyDue;
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

    private String userInfoComment;

    @Basic
    @javax.persistence.Column(name = "user_info_comment")
    public String getUserInfoComment()
    {
        return userInfoComment;
    }

    public void setUserInfoComment(String userInfoComment)
    {
        this.userInfoComment = userInfoComment;
    }

    private Integer userInfoOperatorId;

    @Basic
    @javax.persistence.Column(name = "user_info_operator_id")
    public Integer getUserInfoOperatorId()
    {
        return userInfoOperatorId;
    }

    public void setUserInfoOperatorId(Integer userInfoOperatorId)
    {
        this.userInfoOperatorId = userInfoOperatorId;
    }

    private Timestamp userInfoPassTime;

    @Basic
    @javax.persistence.Column(name = "user_info_pass_time")
    public Timestamp getUserInfoPassTime()
    {
        return userInfoPassTime;
    }

    public void setUserInfoPassTime(Timestamp userInfoPassTime)
    {
        this.userInfoPassTime = userInfoPassTime;
    }

    private String userInfoStatus;

    @Basic
    @javax.persistence.Column(name = "user_info_status")
    public String getUserInfoStatus()
    {
        return userInfoStatus;
    }

    public void setUserInfoStatus(String userInfoStatus)
    {
        this.userInfoStatus = userInfoStatus;
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

    private String userVerifyStatus;

    @Basic
    @javax.persistence.Column(name = "user_verify_status")
    public String getUserVerifyStatus()
    {
        return userVerifyStatus;
    }

    public void setUserVerifyStatus(String userVerifyStatus)
    {
        this.userVerifyStatus = userVerifyStatus;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVerifyStatusEntity that = (UserVerifyStatusEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (firstVerifyDue != null ? !firstVerifyDue.equals(that.firstVerifyDue) : that.firstVerifyDue != null)
            return false;
        if (idcardBackComment != null ? !idcardBackComment.equals(that.idcardBackComment) : that.idcardBackComment != null)
            return false;
        if (idcardBackId != null ? !idcardBackId.equals(that.idcardBackId) : that.idcardBackId != null) return false;
        if (idcardBackOperatorId != null ? !idcardBackOperatorId.equals(that.idcardBackOperatorId) : that.idcardBackOperatorId != null)
            return false;
        if (idcardBackPassTime != null ? !idcardBackPassTime.equals(that.idcardBackPassTime) : that.idcardBackPassTime != null)
            return false;
        if (idcardBackStatus != null ? !idcardBackStatus.equals(that.idcardBackStatus) : that.idcardBackStatus != null)
            return false;
        if (idcardFrontComment != null ? !idcardFrontComment.equals(that.idcardFrontComment) : that.idcardFrontComment != null)
            return false;
        if (idcardFrontId != null ? !idcardFrontId.equals(that.idcardFrontId) : that.idcardFrontId != null)
            return false;
        if (idcardFrontOperatorId != null ? !idcardFrontOperatorId.equals(that.idcardFrontOperatorId) : that.idcardFrontOperatorId != null)
            return false;
        if (idcardFrontPassTime != null ? !idcardFrontPassTime.equals(that.idcardFrontPassTime) : that.idcardFrontPassTime != null)
            return false;
        if (idcardFrontStatus != null ? !idcardFrontStatus.equals(that.idcardFrontStatus) : that.idcardFrontStatus != null)
            return false;
        if (idcardNoComment != null ? !idcardNoComment.equals(that.idcardNoComment) : that.idcardNoComment != null)
            return false;
        if (idcardNoPassTime != null ? !idcardNoPassTime.equals(that.idcardNoPassTime) : that.idcardNoPassTime != null)
            return false;
        if (idcardNoStatus != null ? !idcardNoStatus.equals(that.idcardNoStatus) : that.idcardNoStatus != null)
            return false;
        if (pbcApplied != null ? !pbcApplied.equals(that.pbcApplied) : that.pbcApplied != null) return false;
        if (pbcComment != null ? !pbcComment.equals(that.pbcComment) : that.pbcComment != null) return false;
        if (pbcId != null ? !pbcId.equals(that.pbcId) : that.pbcId != null) return false;
        if (pbcOperatorId != null ? !pbcOperatorId.equals(that.pbcOperatorId) : that.pbcOperatorId != null)
            return false;
        if (pbcPassTime != null ? !pbcPassTime.equals(that.pbcPassTime) : that.pbcPassTime != null) return false;
        if (pbcStatus != null ? !pbcStatus.equals(that.pbcStatus) : that.pbcStatus != null) return false;
        if (secondVerifyDue != null ? !secondVerifyDue.equals(that.secondVerifyDue) : that.secondVerifyDue != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userInfoComment != null ? !userInfoComment.equals(that.userInfoComment) : that.userInfoComment != null)
            return false;
        if (userInfoOperatorId != null ? !userInfoOperatorId.equals(that.userInfoOperatorId) : that.userInfoOperatorId != null)
            return false;
        if (userInfoPassTime != null ? !userInfoPassTime.equals(that.userInfoPassTime) : that.userInfoPassTime != null)
            return false;
        if (userInfoStatus != null ? !userInfoStatus.equals(that.userInfoStatus) : that.userInfoStatus != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (userVerifyStatus != null ? !userVerifyStatus.equals(that.userVerifyStatus) : that.userVerifyStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (firstVerifyDue != null ? firstVerifyDue.hashCode() : 0);
        result = 31 * result + (idcardBackComment != null ? idcardBackComment.hashCode() : 0);
        result = 31 * result + (idcardBackId != null ? idcardBackId.hashCode() : 0);
        result = 31 * result + (idcardBackOperatorId != null ? idcardBackOperatorId.hashCode() : 0);
        result = 31 * result + (idcardBackPassTime != null ? idcardBackPassTime.hashCode() : 0);
        result = 31 * result + (idcardBackStatus != null ? idcardBackStatus.hashCode() : 0);
        result = 31 * result + (idcardFrontComment != null ? idcardFrontComment.hashCode() : 0);
        result = 31 * result + (idcardFrontId != null ? idcardFrontId.hashCode() : 0);
        result = 31 * result + (idcardFrontOperatorId != null ? idcardFrontOperatorId.hashCode() : 0);
        result = 31 * result + (idcardFrontPassTime != null ? idcardFrontPassTime.hashCode() : 0);
        result = 31 * result + (idcardFrontStatus != null ? idcardFrontStatus.hashCode() : 0);
        result = 31 * result + (idcardNoComment != null ? idcardNoComment.hashCode() : 0);
        result = 31 * result + (idcardNoPassTime != null ? idcardNoPassTime.hashCode() : 0);
        result = 31 * result + (idcardNoStatus != null ? idcardNoStatus.hashCode() : 0);
        result = 31 * result + (pbcApplied != null ? pbcApplied.hashCode() : 0);
        result = 31 * result + (pbcComment != null ? pbcComment.hashCode() : 0);
        result = 31 * result + (pbcId != null ? pbcId.hashCode() : 0);
        result = 31 * result + (pbcOperatorId != null ? pbcOperatorId.hashCode() : 0);
        result = 31 * result + (pbcPassTime != null ? pbcPassTime.hashCode() : 0);
        result = 31 * result + (pbcStatus != null ? pbcStatus.hashCode() : 0);
        result = 31 * result + (secondVerifyDue != null ? secondVerifyDue.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userInfoComment != null ? userInfoComment.hashCode() : 0);
        result = 31 * result + (userInfoOperatorId != null ? userInfoOperatorId.hashCode() : 0);
        result = 31 * result + (userInfoPassTime != null ? userInfoPassTime.hashCode() : 0);
        result = 31 * result + (userInfoStatus != null ? userInfoStatus.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (userVerifyStatus != null ? userVerifyStatus.hashCode() : 0);
        return result;
    }
}
