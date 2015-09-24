package com.heika.test.entities.verifyUser;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by admin on 2015/8/14.
 */
@Entity
@Table(name = "verify_strategy_output", schema = "", catalog = "heika_new")
public class VerifyStrategyOutputEntity
{
    private Integer id;
    private Integer userId;
    private BigDecimal amount;
    private Integer cardProductId;
    private String result;
    private Boolean isRrdUser;
    private Timestamp createTime;
    private Timestamp updateTime;
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
    @Column(name = "result")
    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    @Basic
    @Column(name = "is_rrd_user")
    public Boolean getIsRrdUser()
    {
        return isRrdUser;
    }

    public void setIsRrdUser(Boolean isRrdUser)
    {
        this.isRrdUser = isRrdUser;
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

        VerifyStrategyOutputEntity that = (VerifyStrategyOutputEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (cardProductId != null ? !cardProductId.equals(that.cardProductId) : that.cardProductId != null)
            return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (isRrdUser != null ? !isRrdUser.equals(that.isRrdUser) : that.isRrdUser != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    public boolean equalsForUserDetail(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyStrategyOutputEntity that = (VerifyStrategyOutputEntity) o;

        if(result ==null)
        {
            if(result != null)
            {
                return false;
            }
        }
        else
        {
            if(result.equals("拒绝审批"))
            {
                return result.equals(that.result);
            }
        }

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (isRrdUser != null ? !isRrdUser.equals(that.isRrdUser) : that.isRrdUser != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (userId != null ? userId.hashCode() : 0);
        result1 = 31 * result1 + (amount != null ? amount.hashCode() : 0);
        result1 = 31 * result1 + (cardProductId != null ? cardProductId.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (isRrdUser != null ? isRrdUser.hashCode() : 0);
        result1 = 31 * result1 + (createTime != null ? createTime.hashCode() : 0);
        result1 = 31 * result1 + (updateTime != null ? updateTime.hashCode() : 0);
        result1 = 31 * result1 + (version != null ? version.hashCode() : 0);
        return result1;
    }
}
