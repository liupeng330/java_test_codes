package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.NavTree;
import com.heika.test.ui.elements.widget.NavTreeImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserSearch extends PageBase
{
    @FindBy(how = How.ID, using = "navTree")
    private NavTree navTree;

    public UserSearch(WebDriver driver)
    {
        super(driver);
    }

    public void switchTo(String name) throws Exception
    {
        navTree.waitForExist(10);
        navTree.populateTree();
        navTree.clickTreeNodeByTitle(name);
    }
}
