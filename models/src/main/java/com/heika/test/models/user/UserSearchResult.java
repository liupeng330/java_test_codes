package com.heika.test.models.user;

import java.util.ArrayList;
import java.util.List;

public class UserSearchResult implements Comparable<UserSearchResult>
{
    private String userId;
    private String nickName;
    private String realName;
    private String mobile;
    private String idNo;
    private String userType;
    private String verifyUserStatus;
    private String operater;
    private String operateTime;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getVerifyUserStatus()
    {
        return verifyUserStatus;
    }

    public void setVerifyUserStatus(String verifyUserStatus)
    {
        this.verifyUserStatus = verifyUserStatus;
    }

    public String getOperater()
    {
        return operater;
    }

    public void setOperater(String operater)
    {
        this.operater = operater;
    }

    public String getOperateTime()
    {
        return operateTime;
    }

    public void setOperateTime(String operateTime)
    {
        this.operateTime = operateTime;
    }

    @Override
    public int compareTo(UserSearchResult o)
    {
        Integer userId1 = Integer.parseInt(this.getUserId());
        Integer userId2 = Integer.parseInt(o.getUserId());
        return userId1.compareTo(userId2);
    }

    @Override
    public boolean equals(Object others)
    {
        if (others == null)
        {
            return false;
        }
        if (!(others instanceof UserSearchResult))
        {
            return false;
        }
        UserSearchResult that = (UserSearchResult) others;

        if (idNo != null ? !idNo.equals(that.idNo) : that.idNo != null)
            return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null)
            return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null)
            return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null)
            return false;
        if (verifyUserStatus != null ? !verifyUserStatus.equals(that.verifyUserStatus) : that.verifyUserStatus != null)
            return false;

        return true;
    }

    public static List<UserSearchResult> filteredByMobile(List<UserSearchResult> allUsers, String mobile)
    {
        List<UserSearchResult> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if(i.getMobile() != null && i.getMobile().startsWith(mobile))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    public static List<UserSearchResult> filteredByNickName(List<UserSearchResult> allUsers, String nickName)
    {
        List<UserSearchResult> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if (i.getNickName() != null && i.getNickName().startsWith(nickName))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    public static List<UserSearchResult> filteredByIDCard(List<UserSearchResult> allUsers, String idCard)
    {
        List<UserSearchResult> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if(i.getIdNo() != null && i.getIdNo().startsWith(idCard))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    public static List<UserSearchResult> filteredByUserName(List<UserSearchResult> allUsers, String userName)
    {
        List<UserSearchResult> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if (i.getRealName() != null && i.getRealName().startsWith(userName))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    @Override
    public String toString()
    {
        return String.format("userId=%s\n" +
                "nickName=%s\n" +
                "realName=%s\n" +
                "mobile=%s\n" +
                "idNo=%s\n" +
                "userType=%s\n" +
                "verifyUserStatus=%s\n" +
                "operator=%s\n" +
                "operateTime=%s\n",
                userId, nickName, realName, mobile, idNo, userType, verifyUserStatus, operater, operateTime);
    }
}
