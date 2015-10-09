package com.heika.test.ui.verify.page;

import org.openqa.selenium.WebDriver;

public class IFramePageBase extends PageBase
{
    protected WebDriver iframeDriver;
    public IFramePageBase(WebDriver driver, WebDriver iframeDriver)
    {
        super(driver);
        this.iframeDriver = iframeDriver;
    }

    public WebDriver getIFrameDriver()
    {
        return iframeDriver;
    }
}
