package com.heika.test.verify.cases.UI;

import com.heika.test.ui.elements.factory.api.ElementFactory;
import com.heika.test.ui.verify.page.LeftPage;
import com.heika.test.ui.verify.page.LoginPage;
import com.heika.test.ui.elements.widget.NavTreeImpl;
import com.heika.test.ui.verify.page.PageBase;
import com.heika.test.ui.verify.page.UserSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
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

        webDriver.get("http://172.16.2.111:9601/login/index.html");

        LoginPage loginPage = ElementFactory.initElements(webDriver, LoginPage.class);
        loginPage.Login(userName, password);

        LeftPage navTree = ElementFactory.initElements(webDriver, LeftPage.class);
        navTree.switchTo("用户查询");

        UserSearch userSearch = ElementFactory.initElements(webDriver, UserSearch.class);
        userSearch.click_getUserDetail_button(0);
        //userSearch.click_getUserVerifyLog_button("张三");
        //userSearch.click_getUserDetail_button(0);
    }
}