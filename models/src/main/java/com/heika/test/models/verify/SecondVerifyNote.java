package com.heika.test.models.verify;

public class SecondVerifyNote
{
    private String secondVerifyAmount;
    private String secondVerifyCardProductName;
    private String secondVerifyNote;
    private String secondVerifyTime;
    private String secondVerifyUserName;

    public String getSecondVerifyAmount()
    {
        return secondVerifyAmount;
    }

    public void setSecondVerifyAmount(String secondVerifyAmount)
    {
        this.secondVerifyAmount = secondVerifyAmount;
    }

    public String getSecondVerifyCardProductName()
    {
        return secondVerifyCardProductName;
    }

    public void setSecondVerifyCardProductName(String secondVerifyCardProductName)
    {
        this.secondVerifyCardProductName = secondVerifyCardProductName;
    }

    public String getSecondVerifyNote()
    {
        return secondVerifyNote;
    }

    public void setSecondVerifyNote(String secondVerifyNote)
    {
        this.secondVerifyNote = secondVerifyNote;
    }

    public String getSecondVerifyTime()
    {
        return secondVerifyTime;
    }

    public void setSecondVerifyTime(String secondVerifyTime)
    {
        this.secondVerifyTime = secondVerifyTime;
    }

    public String getSecondVerifyUserName()
    {
        return secondVerifyUserName;
    }

    public void setSecondVerifyUserName(String secondVerifyUserName)
    {
        this.secondVerifyUserName = secondVerifyUserName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecondVerifyNote that = (SecondVerifyNote) o;

        if (secondVerifyAmount != null ? !secondVerifyAmount.equals(that.secondVerifyAmount) : that.secondVerifyAmount != null)
            return false;
        if (secondVerifyCardProductName != null ? !secondVerifyCardProductName.equals(that.secondVerifyCardProductName) : that.secondVerifyCardProductName != null)
            return false;
        if (secondVerifyNote != null ? !secondVerifyNote.equals(that.secondVerifyNote) : that.secondVerifyNote != null)
            return false;
        if (secondVerifyUserName != null ? !secondVerifyUserName.equals(that.secondVerifyUserName) : that.secondVerifyUserName != null)
            return false;
        if (secondVerifyTime != null ? !secondVerifyTime.equals(that.secondVerifyTime) : that.secondVerifyTime != null)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return String.format("secondVerifyAmount=%s\n" +
                        "secondVerifyCardProductName=%s\n" +
                        "secondVerifyNote=%s\n" +
                        "secondVerifyUserName=%s\n" +
                        "secondVerifyTime=%s\n",
                secondVerifyAmount, secondVerifyCardProductName, secondVerifyNote, secondVerifyUserName, secondVerifyTime);
    }
}
