package com.heika.test.entities.verify;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by admin on 2015/9/6.
 */
@Entity
@Table(name = "verify_user_status_log", schema = "", catalog = "heika_new")
public class VerifyUserStatusLogEntity
{
    private Long id;
    private Integer userId;
    private Timestamp createTime;
    private Integer verifyUserId;
    private String operation;
    private String operationResult;
    private String note;
    private String rejectReasonList;
    private BigDecimal amount;
    private Integer cardProductId;
    private Integer version;

    @Id
    @Column(name = "id")
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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
    @Column(name = "verify_user_id")
    public Integer getVerifyUserId()
    {
        return verifyUserId;
    }

    public void setVerifyUserId(Integer verifyUserId)
    {
        this.verifyUserId = verifyUserId;
    }

    @Basic
    @Column(name = "operation")
    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    @Basic
    @Column(name = "operation_result")
    public String getOperationResult()
    {
        return operationResult;
    }

    public void setOperationResult(String operationResult)
    {
        this.operationResult = operationResult;
    }

    @Basic
    @Column(name = "note")
    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
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
    @Column(name = "amount")
    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    @Basic
    @Column(name = "card_product_id")
    public Integer getCardProductId()
    {
        return cardProductId;
    }

    public void setCardProductId(Integer cardProductId)
    {
        this.cardProductId = cardProductId;
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

        VerifyUserStatusLogEntity that = (VerifyUserStatusLogEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (verifyUserId != null ? !verifyUserId.equals(that.verifyUserId) : that.verifyUserId != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (operationResult != null ? !operationResult.equals(that.operationResult) : that.operationResult != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (rejectReasonList != null ? !rejectReasonList.equals(that.rejectReasonList) : that.rejectReasonList != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (cardProductId != null ? !cardProductId.equals(that.cardProductId) : that.cardProductId != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (verifyUserId != null ? verifyUserId.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (operationResult != null ? operationResult.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (rejectReasonList != null ? rejectReasonList.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (cardProductId != null ? cardProductId.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
