package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

@ImplementedBy(SpanImpl.class)
public interface Span extends Element
{
    void click();
}
