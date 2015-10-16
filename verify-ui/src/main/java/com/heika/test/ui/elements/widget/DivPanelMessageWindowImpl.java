package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.List;

public class DivPanelMessageWindowImpl extends ElementImpl implements DivPanelMessageWindow
{
    public DivPanelMessageWindowImpl(WebElement element)
    {
        super(element);
    }

    public DivPanelMessageWindowImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    @Override
    public void clickOK()
    {
        clickButton("确认");
    }

    @Override
    public void clickCancel()
    {
        clickButton("取消");
    }

    private void clickButton(String buttonText)
    {
        List<WebElement> buttons = this.getWrappedElement().findElement(By.className("messager-button")).findElements(By.tagName("a"));
        for(WebElement button: buttons)
        {
            if(button.getText().trim().equals(buttonText))
            {
                button.click();
                return;
            }
        }
    }

    @Override
    public String getMessage()
    {
        return this.getWrappedElement().findElement(By.cssSelector("div.messager-body.panel-body.panel-body-noborder.window-body")).getText();
    }

    @Override
    public String getTitle()
    {
        return this.getWrappedElement().findElement(By.className("panel-title")).getText();
    }
}
