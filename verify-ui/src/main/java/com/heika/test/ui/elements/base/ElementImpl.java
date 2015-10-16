package com.heika.test.ui.elements.base;

import java.util.List;

import com.heika.test.utils.LogHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.pagefactory.ElementLocator;

/**
 * An implementation of the Element interface. Delegates its work to an underlying WebElement instance for
 * custom functionality.
 */
public class ElementImpl implements Element {

    private WebElement element;
    private ElementLocator locator;

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ElementImpl(WebElement element)
    {
        this.element = element;
    }

    public ElementImpl(WebElement element, ElementLocator locator)
    {
        this.element = element;
        this.locator = locator;
    }

    protected ElementLocator getLocator()
    {
        return this.locator;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public WebElement findElement(By by) {
        try
        {
            return element.findElement(by);
        }
        catch (org.openqa.selenium.StaleElementReferenceException e)
        {
            if(this.locator != null)
            {
                LogHelper.log("页面元素已腐败，重新获取！！");
                //Relocate when element got staled
                this.element = locator.findElement();
                //and using it to find its child element again
                return element.findElement(by);
            }
            throw e;
        }
    }

    @Override
    public List<WebElement> findElements(By by) {
        try
        {
            return element.findElements(by);
        }
        catch (org.openqa.selenium.StaleElementReferenceException e)
        {
            if(this.locator != null)
            {
                LogHelper.log("页面元素已腐败，重新获取！！");
                //Relocate when element got staled
                this.element = locator.findElement();
                //and using it to find its child element again
                return element.findElements(by);
            }
            throw e;
        }
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void waitForExist() { }

    @Override
    public void clear() {
        throw new NoSuchMethodError("Method clear is only available in the " + ElementImpl.class.getName() + "class.");
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) element).getCoordinates();
    }

    @Override
    public boolean elementWired() {
        return (element != null);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> var1) throws WebDriverException
    {
        throw new UnsupportedOperationException("Not implement for this method!!");
    }
}
