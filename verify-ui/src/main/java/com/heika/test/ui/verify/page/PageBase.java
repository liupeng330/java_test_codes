package com.heika.test.ui.verify.page;

import com.sun.deploy.net.proxy.WebProxyAutoDetection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase
{
    public PageBase(WebDriver driver)
    {
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
}
