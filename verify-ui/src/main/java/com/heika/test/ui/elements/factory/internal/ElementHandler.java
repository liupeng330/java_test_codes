package com.heika.test.ui.elements.factory.internal;

import com.heika.test.ui.elements.base.Element;
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
            Integer retry = (Integer)objects[objects.length-1];
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
        Constructor<?> cons = wrappingType.getConstructor(WebElement.class);
        Object thing = cons.newInstance(element);
        try
        {
            return method.invoke(wrappingType.cast(thing), objects);
        }
        catch (InvocationTargetException e)
        {
            // Unwrap the underlying exception
            throw e.getCause();
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
