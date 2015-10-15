package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
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

    @Override
    public void maxWindow()
    {

    }

    @Override
    public void closeWindow()
    {

    }

    @Override
    public void restoreWindow()
    {

    }

    @Override
    public String getWindowTitle()
    {
        return null;
    }
}
