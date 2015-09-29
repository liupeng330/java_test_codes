package com.heika.test.verify.cases.UI;

import com.heika.test.ui.elements.factory.api.ElementFactory;
import com.heika.test.ui.verify.page.LoginPage;
import com.heika.test.ui.elements.widget.NavTreeImpl;
import com.heika.test.ui.verify.page.UserSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin
{
    @Parameters({"verify_ui_login_username", "verify_ui_login_password"})
    @Test(groups= {"UI"}, description = "")
    public void loginTest(String userName, String password) throws Exception
    {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://172.16.2.38:15081/login.html");

        LoginPage loginPage = ElementFactory.initElements(webDriver, LoginPage.class);
        loginPage.Login(userName, password);

        UserSearch userSearch = ElementFactory.initElements(webDriver, UserSearch.class);
        userSearch.switchTo("用户查询");
    }
}