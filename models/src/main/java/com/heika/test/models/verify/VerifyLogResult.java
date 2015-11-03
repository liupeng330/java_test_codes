package com.heika.test.models.verify;

import java.math.BigDecimal;

public class VerifyLogResult
{
    private BigDecimal amount;
    private String createTime;
    private String level;
    private String note;
    private String operation;
    private String operationResult;
    private String verifyUser;

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public String getOperationResult()
    {
        return operationResult;
    }

    public void setOperationResult(String operationResult)
    {
        this.operationResult = operationResult;
    }

    public String getVerifyUser()
    {
        return verifyUser;
    }

    public void setVerifyUser(String verifyUser)
    {
        this.verifyUser = verifyUser;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerifyLogResult that = (VerifyLogResult) o;
        if (amount != null ? amount.compareTo(that.amount) != 0 : that.amount != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null)
            return false;
        if (level != null ? !level.equals(that.level) : that.level != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null)
            return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null)
            return false;
        if (operationResult != null ? !operationResult.equals(that.operationResult) : that.operationResult != null)
            return false;
        if (verifyUser != null ? !verifyUser.equals(that.verifyUser) : that.verifyUser != null)
            return false;

        return true;
    }
}
