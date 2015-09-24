package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

@ImplementedBy(ButtonImpl.class)
public interface Button extends Element
{
    void click();
}
