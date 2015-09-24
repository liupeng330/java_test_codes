package com.heika.test.verify.models;

import com.heika.test.utils.JsonParser;
import com.heika.test.utils.MappingWordUtil;
import com.heika.test.utils.MysqlHelper;
import org.testng.Reporter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class User
{
    private String user_id = "";
    private String is_ban = "";
    private String channel = "";
    private String channel_id = "";
    private String is_frozen = "";
    private String invite_user_id = "";
    private String mobile = "";
    private String nick_name = "";
    private String register_time = "";
    private String user_type = "";
    private String version = "";
    private String update_time = "";
    private String real_name = "";
    private String id_no = "";
    private String verify_user_status = "";

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public String getIs_ban()
    {
        return is_ban;
    }

    public void setIs_ban(String is_ban)
    {
        this.is_ban = is_ban;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getChannel_id()
    {
        return channel_id;
    }

    public void setChannel_id(String channel_id)
    {
        this.channel_id = channel_id;
    }

    public String getIs_frozen()
    {
        return is_frozen;
    }

    public void setIs_frozen(String is_frozen)
    {
        this.is_frozen = is_frozen;
    }

    public String getInvite_user_id()
    {
        return invite_user_id;
    }

    public void setInvite_user_id(String invite_user_id)
    {
        this.invite_user_id = invite_user_id;
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

    public String getRegister_time()
    {
        return register_time;
    }

    public void setRegister_time(String register_time)
    {
        this.register_time = register_time;
    }

    public String getUser_type()
    {
        return user_type;
    }

    public void setUser_type(String user_type)
    {
        this.user_type = user_type;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getUpdate_time()
    {
        return update_time;
    }

    public void setUpdate_time(String update_time)
    {
        this.update_time = update_time;
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

    private static final String getTotalQuery =
            "select count(*) as total\n" +
            "from `user` u ,`verify_user_status` vus\n" +
            "where u.user_id = vus.user_id and u.user_type = 'COMMON';";

    private static final String searchUserTemplate =
            "select ui.id_no, u.mobile, u.nick_name, ui.real_name, u.user_id, u.channel, vus.verify_user_status\n" +
            "from `user` u \n" +
            "inner join `verify_user_status` vus on u.user_id=vus.user_id\n" +
            "left join `user_info` ui on u.user_id=ui.user_id\n" +
            "where u.user_type='COMMON'\n";

    @Override
    public boolean equals(Object others)
    {
        if (others == null)
        {
            return false;
        }
        if (!(others instanceof User))
        {
            return false;
        }
        User that = (User) others;

        if (id_no != null ? !id_no.equals(that.id_no) : that.id_no != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (nick_name != null ? !nick_name.equals(that.nick_name) : that.nick_name != null) return false;
        if (real_name != null ? !real_name.equals(that.real_name) : that.real_name != null) return false;
        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null) return false;
        if (user_type != null ? !user_type.equals(that.user_type) : that.user_type != null) return false;
        if (verify_user_status != null ? !verify_user_status.equals(that.verify_user_status) : that.verify_user_status != null) return false;

        return true;
    }

    public static List<User> getUsersFromDB(String type, String key, String verifyStatus, MysqlHelper helper) throws SQLException
    {
        StringBuilder query = new StringBuilder(searchUserTemplate);
        if(type != "" && key != "")
        {
            switch(type)
            {
                case "NICKNAME":
                    type = "nick_name";
                    break;
                case "MOBILE":
                    type = "mobile";
                    break;
                case "IDCARD":
                    type = "id_no";
                    break;
                case "USERNAME":
                    type = "real_name";
                    break;
            }
            query.append(String.format("AND %s='%s'\n", type, key));
        }

        if(verifyStatus != "")
        {
            query.append(String.format("AND vus.verify_user_status='%s'\n", verifyStatus));
        }

        query.append(
                "order by u.register_time desc,\n" +
                        "u.user_id asc;");
        Reporter.log("Query for searchuser API: " + query.toString());
        String usersFromSQL = helper.Query(query.toString());
        List<LinkedHashMap<String, String>> data = new JsonParser().jsonGetHashMapList(usersFromSQL, "$.data");
        List<User> users = new ArrayList<>();
        for (LinkedHashMap<String, String> map : data)
        {
            User user = new User();
            if(map.get("channel") != null)
            {
                user.setUser_type(MappingWordUtil.getCN(map.get("channel")));
            }
            if(map.get("nick_name") != null) user.setNick_name(map.get("nick_name"));
            if(map.get("mobile") != null) user.setMobile(map.get("mobile"));
            if(map.get("user_id") != null) user.setUser_id(map.get("user_id"));
            if(map.get("real_name") != null) user.setReal_name(map.get("real_name"));
            if(map.get("id_no") != null) user.setId_no(map.get("id_no"));
            if (map.get("verify_user_status") != null)
            {
                user.setVerify_user_status(MappingWordUtil.getCN( map.get("verify_user_status")));
            }
            users.add(user);
        }
        return users;
    }

    public static Integer getTotalCount(MysqlHelper helper) throws SQLException
    {
        String count = helper.Query(getTotalQuery);
        List<LinkedHashMap<String, String>> data = new JsonParser().jsonGetHashMapList(count, "$.data");
        for (LinkedHashMap<String, String> map : data)
        {
            return Integer.parseInt(map.get("total"));
        }
        return null;
    }

    public static List<User> getUsersFromResponse(String responseBody)
    {
        List<LinkedHashMap<String, String>> data = new JsonParser().jsonGetHashMapList(responseBody, "$.data.rows");
        List<User> users = new ArrayList<>();
        if (data == null)
        {
            return null;
        }
        for (LinkedHashMap<String, String> map : data)
        {
            User user = new User();
            if(map.get("userType") != null) user.setUser_type(map.get("userType"));
            if(map.get("nickName") != null) user.setNick_name(map.get("nickName"));
            if(map.get("mobile") != null) user.setMobile(map.get("mobile"));
            if(map.get("userId") != null)
            {
                Object userId = map.get("userId");
                user.setUser_id(userId.toString());
            }
            if(map.get("realName") != null) user.setReal_name(map.get("realName"));
            if(map.get("idNo") != null) user.setId_no(map.get("idNo"));
            if(map.get("verifyUserStatus") != null) user.setVerify_user_status(map.get("verifyUserStatus"));
            users.add(user);
        }
        return users;
    }
}
