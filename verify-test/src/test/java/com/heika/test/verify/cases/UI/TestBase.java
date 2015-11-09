package com.heika.test.verify.cases.UI;

import com.heika.test.services.user.PrepareTestDataService;
import com.heika.test.services.user.UserSearchService;
import com.heika.test.services.user.UserService;
import com.heika.test.ui.elements.factory.api.ElementFactory;
import com.heika.test.ui.verify.page.LoginPage;
import com.heika.test.utils.LogHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class TestBase
{
    private PrepareTestDataService prepareTestDataService;
    private UserService userService;
    private UserSearchService userSearchService;
    private WebDriver webDriver;

    @Parameters({"verify_ui_url", "verify_ui_login_username", "verify_ui_login_password"})
    @BeforeClass(groups = {"UI"})
    public void init(String url, String userName, String password)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("main_spring.xml");
        this.setPrepareTestDataService((PrepareTestDataService) ctx.getBean("prepareTestDataService"));
        this.setUserService((UserService) ctx.getBean("userService"));
        this.setUserSearchService((UserSearchService)ctx.getBean("userSearchService"));
        this.setWebDriver(new ChromeDriver());
        this.getWebDriver().manage().window().maximize();
        this.getWebDriver().get(url);

        LoginPage loginPage = ElementFactory.initElements(webDriver, LoginPage.class);
        LogHelper.log("登陆审核系统");
        loginPage.Login(userName, password);
    }

    @AfterClass(groups = {"UI"})
    public void cleanup()
    {
        LogHelper.log("开始清理");
        this.getWebDriver().close();
    }

    protected void updateTestDataToINQUIREING(Integer userId) throws Exception
    {
        this.getPrepareTestDataService().updateUserStatusToINQUIREING(userId);
        this.getPrepareTestDataService().updateUserStatusResultToPending(userId);
        this.getPrepareTestDataService().cleanupUserInfoRefine(userId);
        this.getPrepareTestDataService().cleanupUserStatusLog(userId);
        this.getPrepareTestDataService().cleanupStrategyOutput(userId);
    }

    public PrepareTestDataService getPrepareTestDataService()
    {
        return prepareTestDataService;
    }

    public void setPrepareTestDataService(PrepareTestDataService prepareTestDataService)
    {
        this.prepareTestDataService = prepareTestDataService;
    }

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public UserService getUserService()
    {
        return userService;
    }

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    public UserSearchService getUserSearchService()
    {
        return userSearchService;
    }

    public void setUserSearchService(UserSearchService userSearchService)
    {
        this.userSearchService = userSearchService;
    }
}
