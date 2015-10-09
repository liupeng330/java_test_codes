package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserSearch extends IFramePageBase
{
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[2]/div/div/div/div/div[2]/div[2]/div[2]/table")
    private Table datagrid;

    public UserSearch(WebDriver driver)
    {
        super(driver, driver.switchTo().frame(driver.findElement(By.tagName("iframe"))));
    }

    public void clickButtonGetUserVerifyLog(int rowIndex) throws Exception
    {
        this.datagrid.waitForExist(10);
        int attempt = 0;
        while(attempt++ <2)
        {
            try
            {
                this.datagrid.getCellAtIndex(rowIndex, 8).findElement(By.tagName("a")).click();
                return;
            }
            catch (org.openqa.selenium.StaleElementReferenceException e)
            {
                e.printStackTrace();
            }
        }
        throw new Exception("Fail to click 'get user verify log' button!!");
    }
}
