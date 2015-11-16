package com.heika.test.models.user;

public class UserInvestigateDetailResult
{
    private Integer onlineTime;
    private UserInfoResult userInfo;

    public Integer getOnlineTime()
    {
        return onlineTime;
    }

    public void setOnlineTime(Integer onlineTime)
    {
        this.onlineTime = onlineTime;
    }

    public UserInfoResult getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfoResult userInfo)
    {
        this.userInfo = userInfo;
    }
}
