package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.NavTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftPage extends PageBase
{
    @FindBy(how = How.ID, using = "navTree")
    protected NavTree navTree;

    public LeftPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void switchTo(String name) throws Exception
    {
        navTree.waitForExist(10);
        navTree.populateTree();
        navTree.clickTreeNodeByTitle(name);
    }
}
