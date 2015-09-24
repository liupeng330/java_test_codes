package com.heika.test.verify.cases.API;

import com.github.kevinsawicki.http.HttpRequest;
import com.heika.test.utils.MysqlHelper;
import org.testng.annotations.*;

public class TestBase
{
    protected String session;
    protected String baseURL;
    protected MysqlHelper sqlHelper;

    @Parameters({"verify_base_url", "verify_username", "verify_password", "sql_connection", "sql_username", "sql_passwd"})
    @BeforeClass(groups = {"verify"})
    public void init(String baseURL, String userName, String password, String mysqlUrl, String mysqlUserName, String mysqlPassword)
    {
        HttpRequest request = HttpRequest.post(baseURL + "login/login").
                send(String.format("username=%s&password=%s", userName, password));
        org.testng.Assert.assertEquals(200, request.code(), "Response code is not 200!!");
        this.session = request.header("Set-Cookie");
        org.testng.Assert.assertNotNull(this.session, "Fail to get cookie from server!!");
        this.baseURL = baseURL;

        //Init mysql helper
        this.sqlHelper = new MysqlHelper(mysqlUrl, mysqlUserName, mysqlPassword);
    }
}
