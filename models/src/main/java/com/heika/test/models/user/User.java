package com.heika.test.models.user;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>
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

//    private static final String searchUserTemplate =
//            "select ui.id_no, u.mobile, u.nick_name, ui.real_name, u.user_id, u.channel, vus.verify_user_status\n" +
//            "from `user` u \n" +
//            "inner join `verify_user_status` vus on u.user_id=vus.user_id\n" +
//            "left join `user_info` ui on u.user_id=ui.user_id\n" +
//            "where u.user_type='COMMON'\n";

    @Override
    public int compareTo(User o)
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
        if (!(others instanceof User))
        {
            return false;
        }
        User that = (User) others;

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

    public static List<User> filteredByMobile(List<User> allUsers, String mobile)
    {
        List<User> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if(i.getMobile().startsWith(mobile))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    public static List<User> filteredByNickName(List<User> allUsers, String nickName)
    {
        List<User> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if (i.getNick_name().startsWith(nickName))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    public static List<User> filteredByIDCard(List<User> allUsers, String idCard)
    {
        List<User> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if(i.getId_no().startsWith(idCard))
            {
                filteredUsers.add(i);
            }
        });
        return filteredUsers;
    }

    public static List<User> filteredByUserName(List<User> allUsers, String userName)
    {
        List<User> filteredUsers = new ArrayList<>();
        allUsers.forEach(i->
        {
            if (i.getReal_name().startsWith(userName))
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

//    public static List<User> getUsersFromDB(String type, String key, String verifyStatus, MysqlHelper helper) throws SQLException
//    {
//        StringBuilder query = new StringBuilder(searchUserTemplate);
//        if(type != "" && key != "")
//        {
//            switch(type)
//            {
//                case "NICKNAME":
//                    type = "nick_name";
//                    break;
//                case "MOBILE":
//                    type = "mobile";
//                    break;
//                case "IDCARD":
//                    type = "id_no";
//                    break;
//                case "USERNAME":
//                    type = "real_name";
//                    break;
//            }
//            query.append(String.format("AND %s='%s'\n", type, key));
//        }
//
//        if(verifyStatus != "")
//        {
//            query.append(String.format("AND vus.verify_user_status='%s'\n", verifyStatus));
//        }
//
//        query.append(
//                "order by u.register_time desc,\n" +
//                        "u.user_id asc;");
//        Reporter.log("Query for searchuser API: " + query.toString());
//        String usersFromSQL = helper.Query(query.toString());
//        List<LinkedHashMap<String, String>> data = new JsonParser().jsonGetHashMapList(usersFromSQL, "$.data");
//        List<User> users = new ArrayList<>();
//        for (LinkedHashMap<String, String> map : data)
//        {
//            User user = new User();
//            if(map.get("channel") != null)
//            {
//                user.setUser_type(MappingWordUtil.getCN(map.get("channel")));
//            }
//            if(map.get("nick_name") != null) user.setNick_name(map.get("nick_name"));
//            if(map.get("mobile") != null) user.setMobile(map.get("mobile"));
//            if(map.get("user_id") != null) user.setUser_id(map.get("user_id"));
//            if(map.get("real_name") != null) user.setReal_name(map.get("real_name"));
//            if(map.get("id_no") != null) user.setId_no(map.get("id_no"));
//            if (map.get("verify_user_status") != null)
//            {
//                user.setVerify_user_status(MappingWordUtil.getCN(map.get("verify_user_status")));
//            }
//            users.add(user);
//        }
//        return users;
//    }
}
