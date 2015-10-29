package com.heika.test.models.verify;

public class InvestigateNoteInfo
{
    private String investigateNote;
    private String investigateTime;
    private String investigateUserName;

    public String getInvestigateNote()
    {
        return investigateNote;
    }

    public void setInvestigateNote(String investigateNote)
    {
        this.investigateNote = investigateNote;
    }

    public String getInvestigateTime()
    {
        return investigateTime;
    }

    public void setInvestigateTime(String investigateTime)
    {
        this.investigateTime = investigateTime;
    }

    public String getInvestigateUserName()
    {
        return investigateUserName;
    }

    public void setInvestigateUserName(String investigateUserName)
    {
        this.investigateUserName = investigateUserName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvestigateNoteInfo that = (InvestigateNoteInfo) o;

        if (investigateNote!= null ? !investigateNote.equals(that.investigateNote) : that.investigateNote != null)
            return false;
        if (investigateUserName != null ? !investigateUserName.equals(that.investigateUserName) : that.investigateUserName != null)
            return false;
        if (investigateTime != null ? !investigateTime.equals(that.investigateTime) : that.investigateTime != null)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return String.format("investigateNote=%s\n" +
                        "investigateUserName=%s\n" +
                        "investigateTime=%s\n",
                investigateNote, investigateUserName, investigateTime);
    }
}
