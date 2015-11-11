package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

@ImplementedBy(RadioButtonImpl.class)
public interface RadioButton extends Element
{
    void select();
}
