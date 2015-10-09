package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.NavTree;
import com.sun.deploy.net.proxy.WebProxyAutoDetection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase
{
    @FindBy(how = How.ID, using = "navTree")
    protected NavTree navTree;

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public PageBase(WebDriver driver)
    {
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    public void switchTo(String name) throws Exception
    {
        navTree.waitForExist(10);
        navTree.populateTree();
        navTree.clickTreeNodeByTitle(name);
    }
}
