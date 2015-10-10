package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

/**
 * Wraps a label on a html form with some behavior.
 */
public class LabelImpl extends ElementImpl implements Label {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public LabelImpl(WebElement element) {
        super(element);
    }

    public LabelImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    @Override
    public String getFor() {
        return getWrappedElement().getAttribute("for");
    }
}
