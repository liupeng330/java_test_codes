package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class SpanImpl extends ElementImpl implements Span
{
    public SpanImpl(WebElement element)
    {
        super(element);
    }

    public SpanImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    @Override
    public void click()
    {
        getWrappedElement().click();
    }
}
