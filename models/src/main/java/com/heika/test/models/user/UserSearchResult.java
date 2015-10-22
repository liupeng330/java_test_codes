package com.heika.test.models.user;

import java.util.ArrayList;
import java.util.List;

public class UserSearchResult implements Comparable<UserSearchResult>
{
    private String user_id;
    private String nick_name;
    private String real_name;
    private String mobile;
    private String id_no;
    private String user_type;
    private String verify_user_status;
    private String operater;
    private String operateTime;

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getNick_name()
    {
        return nick_name;
    }

    public void setNick_name(String nick_name)
    {
        this.nick_name = nick_name;
    }

    public String getUser_type()
    {
        return user_type;
    }

    public void setUser_type(String user_type)
    {
        this.user_type = user_type;
    }

    public String getReal_name()
    {
        return real_name;
    }

    public void setReal_name(String real_name)
    {
        this.real_name = real_name;
    }

    public String getId_no()
    {
        return id_no;
    }

    public void setId_no(String id_no)
    {
        this.id_no = id_no;
    }

    public String getVerify_user_status()
    {
        return verify_user_status;
    }

    public void setVerify_user_status(String verify_user_status)
    {
        this.verify_user_status = verify_user_status;
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
        Integer userId1 = Integer.parseInt(this.getUser_id());
        Integer userId2 = Integer.parseInt(o.getUser_id());
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

        if (id_no != null ? !id_no.equals(that.id_no) : that.id_no != null)
            return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null)
            return false;
        if (nick_name != null ? !nick_name.equals(that.nick_name) : that.nick_name != null)
            return false;
        if (real_name != null ? !real_name.equals(that.real_name) : that.real_name != null)
            return false;
        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null)
            return false;
        if (user_type != null ? !user_type.equals(that.user_type) : that.user_type != null)
            return false;
        if (verify_user_status != null ? !verify_user_status.equals(that.verify_user_status) : that.verify_user_status != null)
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
            if (i.getNick_name() != null && i.getNick_name().startsWith(nickName))
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
            if(i.getId_no() != null && i.getId_no().startsWith(idCard))
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
            if (i.getReal_name() != null && i.getReal_name().startsWith(userName))
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
                user_id, nick_name, real_name, mobile, id_no, user_type, verify_user_status, operater, operateTime);
    }
}
