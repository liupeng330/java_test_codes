package com.heika.test.entities.verifyUser;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "verify_user_status", schema = "", catalog = "heika_new")
public class VerifyUserStatusEntity
{
    private Integer id;
    private Integer userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String verifyUserStatus;
    private Timestamp commitTime;
    private String rejectOperation;
    private String rejectReasonList;
    private Timestamp investigateTime;
    private Timestamp firstVerifyTime;
    private Timestamp secondVerifyTime;
    private Integer investigateUserId;
    private Integer firstVerifyUserId;
    private Integer secondVerifyUserId;
    private String investigateNote;
    private String firstVerifyNote;
    private String secondVerifyNote;
    private BigDecimal firstVerifyAmount;
    private BigDecimal secondVerifyAmount;
    private Integer firstVerifyCardProductId;
    private Integer secondVerifyCardProductId;
    private String inYouxinBackList;
    private Integer version;

    @Id
    @Column(name = "id")
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "verify_user_status")
    public String getVerifyUserStatus()
    {
        return verifyUserStatus;
    }

    public void setVerifyUserStatus(String verifyUserStatus)
    {
        this.verifyUserStatus = verifyUserStatus;
    }

    @Basic
    @Column(name = "commit_time")
    public Timestamp getCommitTime()
    {
        return commitTime;
    }

    public void setCommitTime(Timestamp commitTime)
    {
        this.commitTime = commitTime;
    }

    @Basic
    @Column(name = "reject_operation")
    public String getRejectOperation()
    {
        return rejectOperation;
    }

    public void setRejectOperation(String rejectOperation)
    {
        this.rejectOperation = rejectOperation;
    }

    @Basic
    @Column(name = "reject_reason_list")
    public String getRejectReasonList()
    {
        return rejectReasonList;
    }

    public void setRejectReasonList(String rejectReasonList)
    {
        this.rejectReasonList = rejectReasonList;
    }

    @Basic
    @Column(name = "investigate_time")
    public Timestamp getInvestigateTime()
    {
        return investigateTime;
    }

    public void setInvestigateTime(Timestamp investigateTime)
    {
        this.investigateTime = investigateTime;
    }

    @Basic
    @Column(name = "first_verify_time")
    public Timestamp getFirstVerifyTime()
    {
        return firstVerifyTime;
    }

    public void setFirstVerifyTime(Timestamp firstVerifyTime)
    {
        this.firstVerifyTime = firstVerifyTime;
    }

    @Basic
    @Column(name = "second_verify_time")
    public Timestamp getSecondVerifyTime()
    {
        return secondVerifyTime;
    }

    public void setSecondVerifyTime(Timestamp secondVerifyTime)
    {
        this.secondVerifyTime = secondVerifyTime;
    }

    @Basic
    @Column(name = "investigate_user_id")
    public Integer getInvestigateUserId()
    {
        return investigateUserId;
    }

    public void setInvestigateUserId(Integer investigateUserId)
    {
        this.investigateUserId = investigateUserId;
    }

    @Basic
    @Column(name = "first_verify_user_id")
    public Integer getFirstVerifyUserId()
    {
        return firstVerifyUserId;
    }

    public void setFirstVerifyUserId(Integer firstVerifyUserId)
    {
        this.firstVerifyUserId = firstVerifyUserId;
    }

    @Basic
    @Column(name = "second_verify_user_id")
    public Integer getSecondVerifyUserId()
    {
        return secondVerifyUserId;
    }

    public void setSecondVerifyUserId(Integer secondVerifyUserId)
    {
        this.secondVerifyUserId = secondVerifyUserId;
    }

    @Basic
    @Column(name = "investigate_note")
    public String getInvestigateNote()
    {
        return investigateNote;
    }

    public void setInvestigateNote(String investigateNote)
    {
        this.investigateNote = investigateNote;
    }

    @Basic
    @Column(name = "first_verify_note")
    public String getFirstVerifyNote()
    {
        return firstVerifyNote;
    }

    public void setFirstVerifyNote(String firstVerifyNote)
    {
        this.firstVerifyNote = firstVerifyNote;
    }

    @Basic
    @Column(name = "second_verify_note")
    public String getSecondVerifyNote()
    {
        return secondVerifyNote;
    }

    public void setSecondVerifyNote(String secondVerifyNote)
    {
        this.secondVerifyNote = secondVerifyNote;
    }

    @Basic
    @Column(name = "first_verify_amount")
    public BigDecimal getFirstVerifyAmount()
    {
        return firstVerifyAmount;
    }

    public void setFirstVerifyAmount(BigDecimal firstVerifyAmount)
    {
        this.firstVerifyAmount = firstVerifyAmount;
    }

    @Basic
    @Column(name = "second_verify_amount")
    public BigDecimal getSecondVerifyAmount()
    {
        return secondVerifyAmount;
    }

    public void setSecondVerifyAmount(BigDecimal secondVerifyAmount)
    {
        this.secondVerifyAmount = secondVerifyAmount;
    }

    @Basic
    @Column(name = "first_verify_card_product_id")
    public Integer getFirstVerifyCardProductId()
    {
        return firstVerifyCardProductId;
    }

    public void setFirstVerifyCardProductId(Integer firstVerifyCardProductId)
    {
        this.firstVerifyCardProductId = firstVerifyCardProductId;
    }

    @Basic
    @Column(name = "second_verify_card_product_id")
    public Integer getSecondVerifyCardProductId()
    {
        return secondVerifyCardProductId;
    }

    public void setSecondVerifyCardProductId(Integer secondVerifyCardProductId)
    {
        this.secondVerifyCardProductId = secondVerifyCardProductId;
    }

    @Basic
    @Column(name = "in_youxin_back_list")
    public String getInYouxinBackList()
    {
        return inYouxinBackList;
    }

    public void setInYouxinBackList(String inYouxinBackList)
    {
        this.inYouxinBackList = inYouxinBackList;
    }

    @Basic
    @Column(name = "version")
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

        VerifyUserStatusEntity that = (VerifyUserStatusEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (verifyUserStatus != null ? !verifyUserStatus.equals(that.verifyUserStatus) : that.verifyUserStatus != null)
            return false;
        if (commitTime != null ? !commitTime.equals(that.commitTime) : that.commitTime != null) return false;
        if (rejectOperation != null ? !rejectOperation.equals(that.rejectOperation) : that.rejectOperation != null)
            return false;
        if (rejectReasonList != null ? !rejectReasonList.equals(that.rejectReasonList) : that.rejectReasonList != null)
            return false;
        if (investigateTime != null ? !investigateTime.equals(that.investigateTime) : that.investigateTime != null)
            return false;
        if (firstVerifyTime != null ? !firstVerifyTime.equals(that.firstVerifyTime) : that.firstVerifyTime != null)
            return false;
        if (secondVerifyTime != null ? !secondVerifyTime.equals(that.secondVerifyTime) : that.secondVerifyTime != null)
            return false;
        if (investigateUserId != null ? !investigateUserId.equals(that.investigateUserId) : that.investigateUserId != null)
            return false;
        if (firstVerifyUserId != null ? !firstVerifyUserId.equals(that.firstVerifyUserId) : that.firstVerifyUserId != null)
            return false;
        if (secondVerifyUserId != null ? !secondVerifyUserId.equals(that.secondVerifyUserId) : that.secondVerifyUserId != null)
            return false;
        if (investigateNote != null ? !investigateNote.equals(that.investigateNote) : that.investigateNote != null)
            return false;
        if (firstVerifyNote != null ? !firstVerifyNote.equals(that.firstVerifyNote) : that.firstVerifyNote != null)
            return false;
        if (secondVerifyNote != null ? !secondVerifyNote.equals(that.secondVerifyNote) : that.secondVerifyNote != null)
            return false;
        if (firstVerifyAmount != null ? !firstVerifyAmount.equals(that.firstVerifyAmount) : that.firstVerifyAmount != null)
            return false;
        if (secondVerifyAmount != null ? !secondVerifyAmount.equals(that.secondVerifyAmount) : that.secondVerifyAmount != null)
            return false;
        if (firstVerifyCardProductId != null ? !firstVerifyCardProductId.equals(that.firstVerifyCardProductId) : that.firstVerifyCardProductId != null)
            return false;
        if (secondVerifyCardProductId != null ? !secondVerifyCardProductId.equals(that.secondVerifyCardProductId) : that.secondVerifyCardProductId != null)
            return false;
        if (inYouxinBackList != null ? !inYouxinBackList.equals(that.inYouxinBackList) : that.inYouxinBackList != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    public boolean equalsForUserDetail(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyUserStatusEntity that = (VerifyUserStatusEntity) o;

        if (investigateTime != null ? !investigateTime.equals(that.investigateTime) : that.investigateTime != null)
            return false;
        if (firstVerifyTime != null ? !firstVerifyTime.equals(that.firstVerifyTime) : that.firstVerifyTime != null)
            return false;
        if (secondVerifyTime != null ? !secondVerifyTime.equals(that.secondVerifyTime) : that.secondVerifyTime != null)
            return false;
        if (investigateNote != null ? !investigateNote.equals(that.investigateNote) : that.investigateNote != null)
            return false;
        if (firstVerifyNote != null ? !firstVerifyNote.equals(that.firstVerifyNote) : that.firstVerifyNote != null)
            return false;
        if (secondVerifyNote != null ? !secondVerifyNote.equals(that.secondVerifyNote) : that.secondVerifyNote != null)
            return false;
        if (firstVerifyAmount != null ? !firstVerifyAmount.equals(that.firstVerifyAmount) : that.firstVerifyAmount != null)
            return false;
        if (secondVerifyAmount != null ? !secondVerifyAmount.equals(that.secondVerifyAmount) : that.secondVerifyAmount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (verifyUserStatus != null ? verifyUserStatus.hashCode() : 0);
        result = 31 * result + (commitTime != null ? commitTime.hashCode() : 0);
        result = 31 * result + (rejectOperation != null ? rejectOperation.hashCode() : 0);
        result = 31 * result + (rejectReasonList != null ? rejectReasonList.hashCode() : 0);
        result = 31 * result + (investigateTime != null ? investigateTime.hashCode() : 0);
        result = 31 * result + (firstVerifyTime != null ? firstVerifyTime.hashCode() : 0);
        result = 31 * result + (secondVerifyTime != null ? secondVerifyTime.hashCode() : 0);
        result = 31 * result + (investigateUserId != null ? investigateUserId.hashCode() : 0);
        result = 31 * result + (firstVerifyUserId != null ? firstVerifyUserId.hashCode() : 0);
        result = 31 * result + (secondVerifyUserId != null ? secondVerifyUserId.hashCode() : 0);
        result = 31 * result + (investigateNote != null ? investigateNote.hashCode() : 0);
        result = 31 * result + (firstVerifyNote != null ? firstVerifyNote.hashCode() : 0);
        result = 31 * result + (secondVerifyNote != null ? secondVerifyNote.hashCode() : 0);
        result = 31 * result + (firstVerifyAmount != null ? firstVerifyAmount.hashCode() : 0);
        result = 31 * result + (secondVerifyAmount != null ? secondVerifyAmount.hashCode() : 0);
        result = 31 * result + (firstVerifyCardProductId != null ? firstVerifyCardProductId.hashCode() : 0);
        result = 31 * result + (secondVerifyCardProductId != null ? secondVerifyCardProductId.hashCode() : 0);
        result = 31 * result + (inYouxinBackList != null ? inYouxinBackList.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
