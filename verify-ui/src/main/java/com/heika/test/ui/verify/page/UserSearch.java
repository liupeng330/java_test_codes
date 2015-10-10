package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.Button;
import com.heika.test.ui.elements.widget.ButtonImpl;
import com.heika.test.ui.elements.widget.Table;
import com.sun.istack.internal.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Predicate;

public class UserSearch extends IFramePageBase
{
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[2]/div/div/div/div/div[2]/div[2]/div[2]/table")
    private Table datagrid;

    public UserSearch(WebDriver driver)
    {
        super(driver, driver.switchTo().frame(driver.findElement(By.tagName("iframe"))));
    }

    public void click_getUserVerifyLog_button(String realName) throws Exception
    {
        this.datagrid.waitForExist(10);
        List<WebElement> rows = this.datagrid.getRows();
        for(WebElement row: rows)
        {
            System.out.println(row.findElement(By.xpath("//*[@field=\"realName\"]")).getText());
            if(row.findElement(By.xpath("//*[@field=\"realName\"]")).getText().equals(realName))
            {
                row.findElement(By.xpath("//*[@field=\"made\"]")).findElement(By.tagName("a")).click();
            }
        }
    }

    public void click_getUserVerifyLog_button(int rowIndex) throws Exception
    {
        clickButton(rowIndex, 8);
    }

    public void click_getUserDetail_button(int rowIndex) throws Exception
    {
        clickButton(rowIndex, 9);
    }

    public void click_getUserPbcReport_button(int rowIndex) throws Exception
    {
        clickButton(rowIndex, 10);
    }

    private void clickButton(int rowIndex, int colIndex) throws Exception
    {
        this.datagrid.waitForExist(10);
        int retry = 2;
        while(true)
        {
            try
            {
                WebElement element = this.datagrid.getCellAtIndex(rowIndex, colIndex);
                WebElement button = element.findElement(By.tagName("a"));
                new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(button));
                button.click();
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
}
