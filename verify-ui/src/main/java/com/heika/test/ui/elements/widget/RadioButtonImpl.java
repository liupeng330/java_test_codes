package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class RadioButtonImpl extends ElementImpl implements RadioButton
{
    public RadioButtonImpl(WebElement element)
    {
        super(element);
    }

    public RadioButtonImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    @Override
    public void select()
    {
        getWrappedElement().click();
    }
}
