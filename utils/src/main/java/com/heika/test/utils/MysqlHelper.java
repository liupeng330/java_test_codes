package com.heika.test.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class MysqlHelper
{
    private String url;
    private String userName;
    private String password;

    public MysqlHelper(String url, String userName, String password)
    {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public boolean execute(String[] para)
    {
        boolean ret = false;

        if (para[0].equals("mysql"))
        {
            try
            {
                mysql(para);
            } catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ret = true;
        }

        return ret;
    }

    public void mysql(String[] para) throws SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Connection connect = null;
        Statement stmt = null;
        String jsonstring = null;
        try
        {
            connect = (Connection) DriverManager
                    .getConnection(para[1]);

            String query = para[2];

            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            jsonstring = JsonUtil.ResultSet2JSONString(rs);
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            if (stmt != null)
            {
                stmt.close();
            }
        }
    }

    public String Query(String query) throws SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connect = null;
        Statement stmt = null;
        String jsonstring = null;
        try
        {
            connect = (Connection) DriverManager
                    .getConnection(url, userName, password);
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            jsonstring = JsonUtil.ResultSet2JSONString(rs);
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            if (stmt != null)
            {
                stmt.close();
            }
        }
        return jsonstring;
    }
}
