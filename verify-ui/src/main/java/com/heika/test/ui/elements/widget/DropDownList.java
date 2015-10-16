package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

@ImplementedBy(DropDownListImpl.class)
public interface DropDownList extends Element
{
    void selectByText(String text);
}
