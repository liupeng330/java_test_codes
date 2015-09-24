package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

public class SpanImpl extends ElementImpl implements Span
{
    public SpanImpl(WebElement element)
    {
        super(element);
    }

    @Override
    public void click()
    {
        getWrappedElement().click();
    }
}
