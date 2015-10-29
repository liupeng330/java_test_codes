package com.heika.test.models.verify;

public class Strategy
{
    private String isOld;
    private String result;
    private String amount;
    private String cardProductId;

    public String getIsOld()
    {
        return isOld;
    }

    public void setIsOld(String isOld)
    {
        this.isOld = isOld;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getCardProductId()
    {
        return cardProductId;
    }

    public void setCardProductId(String cardProductId)
    {
        this.cardProductId = cardProductId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Strategy that = (Strategy) o;

        if (isOld != null ? !isOld.equals(that.isOld) : that.isOld != null)
            return false;
        if (result != null ? !result.equals(that.result) : that.result != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null)
            return false;
        if (cardProductId != null ? !cardProductId.equals(that.cardProductId) : that.cardProductId != null)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return String.format("isOld=%s\n" +
                        "result=%s\n" +
                        "amount=%s\n" +
                        "cardProductId=%s\n",
                isOld, result, amount, cardProductId);
    }
}
