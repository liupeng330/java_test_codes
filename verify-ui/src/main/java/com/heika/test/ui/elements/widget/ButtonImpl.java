package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class ButtonImpl extends ElementImpl implements Button
{
    public ButtonImpl(WebElement element)
    {
        super(element);
    }

    public ButtonImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    @Override
    public void click()
    {
        getWrappedElement().click();
    }
}
