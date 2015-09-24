package com.heika.test.entities.card;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "card_product", schema = "", catalog = "heika_new")
public class CardProductEntity
{
    private Integer id;
    private String name;
    private Integer cardStar;
    private BigDecimal supportMaxAmount;
    private String repayType;
    private String feeRatioMap;
    private Integer validityTerm;
    private Integer contractTemplateId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer version;
    private Integer operator;

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
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "card_star")
    public Integer getCardStar()
    {
        return cardStar;
    }

    public void setCardStar(Integer cardStar)
    {
        this.cardStar = cardStar;
    }

    @Basic
    @Column(name = "support_max_amount")
    public BigDecimal getSupportMaxAmount()
    {
        return supportMaxAmount;
    }

    public void setSupportMaxAmount(BigDecimal supportMaxAmount)
    {
        this.supportMaxAmount = supportMaxAmount;
    }

    @Basic
    @Column(name = "repay_type")
    public String getRepayType()
    {
        return repayType;
    }

    public void setRepayType(String repayType)
    {
        this.repayType = repayType;
    }

    @Basic
    @Column(name = "fee_ratio_map")
    public String getFeeRatioMap()
    {
        return feeRatioMap;
    }

    public void setFeeRatioMap(String feeRatioMap)
    {
        this.feeRatioMap = feeRatioMap;
    }

    @Basic
    @Column(name = "validity_term")
    public Integer getValidityTerm()
    {
        return validityTerm;
    }

    public void setValidityTerm(Integer validityTerm)
    {
        this.validityTerm = validityTerm;
    }

    @Basic
    @Column(name = "contract_template_id")
    public Integer getContractTemplateId()
    {
        return contractTemplateId;
    }

    public void setContractTemplateId(Integer contractTemplateId)
    {
        this.contractTemplateId = contractTemplateId;
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

    @Basic
    @Column(name = "operator")
    public Integer getOperator()
    {
        return operator;
    }

    public void setOperator(Integer operator)
    {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardProductEntity that = (CardProductEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cardStar != null ? !cardStar.equals(that.cardStar) : that.cardStar != null) return false;
        if (supportMaxAmount != null ? !supportMaxAmount.equals(that.supportMaxAmount) : that.supportMaxAmount != null)
            return false;
        if (repayType != null ? !repayType.equals(that.repayType) : that.repayType != null) return false;
        if (feeRatioMap != null ? !feeRatioMap.equals(that.feeRatioMap) : that.feeRatioMap != null) return false;
        if (validityTerm != null ? !validityTerm.equals(that.validityTerm) : that.validityTerm != null) return false;
        if (contractTemplateId != null ? !contractTemplateId.equals(that.contractTemplateId) : that.contractTemplateId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cardStar != null ? cardStar.hashCode() : 0);
        result = 31 * result + (supportMaxAmount != null ? supportMaxAmount.hashCode() : 0);
        result = 31 * result + (repayType != null ? repayType.hashCode() : 0);
        result = 31 * result + (feeRatioMap != null ? feeRatioMap.hashCode() : 0);
        result = 31 * result + (validityTerm != null ? validityTerm.hashCode() : 0);
        result = 31 * result + (contractTemplateId != null ? contractTemplateId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
