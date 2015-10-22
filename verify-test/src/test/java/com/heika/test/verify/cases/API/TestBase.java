package com.heika.test.verify.cases.API;

import com.github.kevinsawicki.http.HttpRequest;
import com.heika.test.services.user.UserSearchService;
import com.heika.test.services.user.UserService;
import com.heika.test.services.user.impl.UserImpl;
import com.heika.test.utils.MysqlHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

import java.net.URLEncoder;

public class TestBase
{
    protected String session;
    protected String baseURL;
    protected MysqlHelper sqlHelper;
    protected UserSearchService userSearchService;

    @Parameters({"verify_base_url", "verify_username", "verify_password", "sql_connection", "sql_username", "sql_passwd"})
    @BeforeClass(groups = {"verify-debug"})
    public void init(String baseURL, String userName, String password, String mysqlUrl, String mysqlUserName, String mysqlPassword) throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("main_spring.xml");
        this.userSearchService = (UserSearchService)ctx.getBean("userSearchService");

        HttpRequest request = HttpRequest.post(baseURL + "login/login").
                send(String.format("username=%s&password=%s", URLEncoder.encode(userName, "UTF-8"), password));

        this.session = request.header("Set-Cookie");
        org.testng.Assert.assertNotNull(this.session, "Fail to get cookie from server!!");
        this.baseURL = baseURL;

        //Init mysql helper
        this.sqlHelper = new MysqlHelper(mysqlUrl, mysqlUserName, mysqlPassword);
    }
}
