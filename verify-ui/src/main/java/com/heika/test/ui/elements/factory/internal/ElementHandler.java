package com.heika.test.ui.elements.factory.internal;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.utils.LogHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import static com.heika.test.ui.elements.factory.internal.ImplementedByProcessor.getWrapperClass;

/**
 * Replaces DefaultLocatingElementHandler. Simply opens it up to descendants of the WebElement interface, and other
 * mix-ins of WebElement and Locatable, etc. Saves the wrapping type for calling the constructor of the wrapped classes.
 */
public class ElementHandler implements InvocationHandler {
    private final ElementLocator locator;
    private final Class<?> wrappingType;

    /**
     * Generates a handler to retrieve the WebElement from a locator for a given WebElement interface descendant.
     *
     * @param interfaceType Interface wrapping this class. It contains a reference the the implementation.
     * @param locator       Element locator that finds the element on a page.
     * @param <T>           type of the interface
     */
    public <T> ElementHandler(Class<T> interfaceType, ElementLocator locator) {
        this.locator = locator;
        if (!Element.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface not assignable to Element.");
        }

        this.wrappingType = getWrapperClass(interfaceType);
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable
    {
        WebElement element = null;
        if("waitForExist".equals(method.getName()))
        {
            Integer retry = 10;
            while (true)
            {
                try
                {
                    element = locator.findElement();
                    if("waitForExist".equals(method.getName()))
                    {
                        return element;
                    }
                    else
                    {
                        break;
                    }
                }
                catch (org.openqa.selenium.NoSuchElementException e)
                {
                    retry = handleException(retry, e);
                }
            }
        }
        else
        {
            element = locator.findElement();
        }

        if ("getWrappedElement".equals(method.getName()))
        {
            return element;
        }
        Constructor<?> cons = wrappingType.getConstructor(WebElement.class, ElementLocator.class);

        int defaultRetryTimes = 10;
        while(true)
        {
            Object thing = cons.newInstance(element, locator);
            try
            {
                return method.invoke(wrappingType.cast(thing), objects);
            }
            catch (InvocationTargetException e)
            {
                if (e.getCause() instanceof org.openqa.selenium.StaleElementReferenceException)
                {
                    if(--defaultRetryTimes > 0)
                    {
                        LogHelper.log("页面元素腐败，需要重新获取！！");
                        element = locator.findElement();
                    }
                    else
                    {
                        LogHelper.log("重新获取页面元素失败！！");
                        throw e.getCause();
                    }
                }
                else
                {
                    throw e.getCause();
                }
            }
        }
    }

    private Integer handleException(Integer retry, Throwable e) throws Throwable
    {
        if(--retry <= 0)
        {
            throw e;
        }
        try
        {
            Thread.sleep(1000);
            return retry;
        }
        catch (InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
