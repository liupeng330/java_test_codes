package com.heika.test.ui.verify.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.Callable;

public abstract class PageBase
{
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public PageBase(WebDriver driver)
    {
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    protected WebDriver getWebDriver()
    {
        return this.webDriver;
    }

    protected WebDriverWait getWebDriverWait()
    {
        return this.webDriverWait;
    }

    public void retryForStaleElement(Runnable run)
    {
        int retry = 2;
        while(true)
        {
            try
            {
                run.run();
                return;
            }
            catch (org.openqa.selenium.StaleElementReferenceException e)
            {
                if(--retry < 0)
                {
                    throw e;
                }
                System.out.println("Element got staled, try again!!");
            }
        }
    }

    public <T> T retryForStaleElement(Callable<T> call) throws Exception
    {
        int retry = 2;
        while(true)
        {
            try
            {
                return call.call();
            }
            catch (org.openqa.selenium.StaleElementReferenceException e)
            {
                if(--retry < 0)
                {
                    throw e;
                }
                System.out.println("Element got staled, try again!!");
            }
        }

    }
}
