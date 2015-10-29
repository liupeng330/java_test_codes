package com.heika.test.models.user;

import com.heika.test.models.verify.FirstVerifyNote;
import com.heika.test.models.verify.InvestigateNoteInfo;
import com.heika.test.models.verify.SecondVerifyNote;
import com.heika.test.models.verify.Strategy;

public class UserDetailResult
{
    private InvestigateNoteInfo investigateNoteInfo;
    private FirstVerifyNote firstVerifyNote;
    private SecondVerifyNote secondVerify;
    private Strategy strategy;
    private String youxinBlackListEnum;

    public InvestigateNoteInfo getInvestigateNoteInfo()
    {
        return investigateNoteInfo;
    }

    public void setInvestigateNoteInfo(InvestigateNoteInfo investigateNoteInfo)
    {
        this.investigateNoteInfo = investigateNoteInfo;
    }

    public FirstVerifyNote getFirstVerifyNote()
    {
        return firstVerifyNote;
    }

    public void setFirstVerifyNote(FirstVerifyNote firstVerifyNote)
    {
        this.firstVerifyNote = firstVerifyNote;
    }

    public SecondVerifyNote getSecondVerify()
    {
        return secondVerify;
    }

    public void setSecondVerify(SecondVerifyNote secondVerify)
    {
        this.secondVerify = secondVerify;
    }

    public Strategy getStrategy()
    {
        return strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public String getYouxinBlackListEnum()
    {
        return youxinBlackListEnum;
    }

    public void setYouxinBlackListEnum(String youxinBlackListEnum)
    {
        this.youxinBlackListEnum = youxinBlackListEnum;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailResult that = (UserDetailResult) o;

        if (investigateNoteInfo != null ? !investigateNoteInfo.equals(that.investigateNoteInfo) : that.investigateNoteInfo != null)
            return false;
        if (firstVerifyNote != null ? !firstVerifyNote.equals(that.firstVerifyNote) : that.firstVerifyNote != null)
            return false;
        if (secondVerify != null ? !secondVerify.equals(that.secondVerify) : that.secondVerify != null)
            return false;
        if (strategy != null ? !strategy.equals(that.strategy) : that.strategy != null)
            return false;
        if (youxinBlackListEnum != null ? !youxinBlackListEnum.equals(that.youxinBlackListEnum) : that.youxinBlackListEnum != null)
            return false;

        return true;
    }
}
