package com.heika.test.models.verify;

public class FirstVerifyNote
{
    private String firstVerifyAmount;
    private String firstVerifyCardProductName;
    private String firstVerifyNote;
    private String firstVerifyTime;
    private String firstVerifyUserName;

    public String getFirstVerifyAmount()
                                    {
                                       return firstVerifyAmount;
                                                                                       }

    public void setFirstVerifyAmount(String firstVerifyAmount)
                                                          {
                                                             this.firstVerifyAmount = firstVerifyAmount;
                                                                                                                                                     }

    public String getFirstVerifyCardProductName()
                                             {
                                                return firstVerifyCardProductName;
                                                                                                                  }

    public void setFirstVerifyCardProductName(String firstVerifyCardProductName)
    {
            this.firstVerifyCardProductName = firstVerifyCardProductName;
    }

    public String getFirstVerifyNote()
                                  {
                                     return firstVerifyNote;
                                                                                 }

    public void setFirstVerifyNote(String firstVerifyNote)
                                                      {
                                                         this.firstVerifyNote = firstVerifyNote;
                                                                                                                                         }

    public String getFirstVerifyTime()
                                  {
                                     return firstVerifyTime;
                                                                                 }

    public void setFirstVerifyTime(String firstVerifyTime)
                                                      {
                                                         this.firstVerifyTime = firstVerifyTime;
                                                                                                                                         }

    public String getFirstVerifyUserName()
                                      {
                                         return firstVerifyUserName;
                                                                                             }

    public void setFirstVerifyUserName(String firstVerifyUserName)
    {
            this.firstVerifyUserName = firstVerifyUserName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstVerifyNote that = (FirstVerifyNote) o;

        if (firstVerifyAmount != null ? !firstVerifyAmount.equals(that.firstVerifyAmount) : that.firstVerifyAmount != null)
            return false;
        if (firstVerifyCardProductName != null ? !firstVerifyCardProductName.equals(that.firstVerifyCardProductName) : that.firstVerifyCardProductName != null)
            return false;
        if (firstVerifyNote != null ? !firstVerifyNote.equals(that.firstVerifyNote) : that.firstVerifyNote != null)
            return false;
        if (firstVerifyUserName != null ? !firstVerifyUserName.equals(that.firstVerifyUserName) : that.firstVerifyUserName != null)
            return false;
        if (firstVerifyTime != null ? !firstVerifyTime.equals(that.firstVerifyTime) : that.firstVerifyTime != null)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return String.format("firstVerifyAmount=%s\n" +
                        "firstVerifyCardProductName=%s\n" +
                        "firstVerifyNote=%s\n" +
                        "firstVerifyUserName=%s\n" +
                        "firstVerifyTime=%s\n",
                firstVerifyAmount, firstVerifyCardProductName, firstVerifyNote, firstVerifyUserName, firstVerifyTime);
    }
}
