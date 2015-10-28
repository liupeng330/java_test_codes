package com.heika.test.models.user;

import com.heika.test.models.verify.FirstVerifyNote;
import com.heika.test.models.verify.InvestigateNoteInfo;
import com.heika.test.models.verify.SecondVerifyNote;
import com.heika.test.models.verify.Strategy;

public class UserDetailResult
{
    private InvestigateNoteInfo investigateNoteInfo;
    private FirstVerifyNote firstVerifyNote;
    private SecondVerifyNote secondVerifyNote;
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

    public SecondVerifyNote getSecondVerifyNote()
    {
        return secondVerifyNote;
    }

    public void setSecondVerifyNote(SecondVerifyNote secondVerifyNote)
    {
        this.secondVerifyNote = secondVerifyNote;
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
}
