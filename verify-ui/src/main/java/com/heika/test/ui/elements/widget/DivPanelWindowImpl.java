package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class DivPanelWindowImpl extends ElementImpl implements DivPanelWindow
{
    public DivPanelWindowImpl(WebElement element)
    {
        super(element);
    }

    public DivPanelWindowImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    private String windowTitle;

    public void setWindowTitle(String title)
    {
        this.windowTitle = title;
    }

    @Override
    public void maxWindow()
    {
        this.getWrappedElement().findElement(By.className("panel-tool-max")).click();
    }

    @Override
    public void closeWindow()
    {
        this.getWrappedElement().findElement(By.className("panel-tool-close")).click();
    }

    @Override
    public void restoreWindow()
    {
        //this.getWrappedElement().findElement(By.className("panel-tool-max panel-tool-restore")).click();
        this.getWrappedElement().findElement(By.cssSelector("a.panel-tool-max.panel-tool-restore")).click();
    }

    @Override
    public String getWindowTitle()
    {
        return this.getWrappedElement().findElement(By.className("panel-title")).getText();
    }
}
