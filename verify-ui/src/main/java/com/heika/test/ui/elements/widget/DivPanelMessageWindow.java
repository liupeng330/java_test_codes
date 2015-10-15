package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

@ImplementedBy(DivPanelMessageWindowImpl.class)
public interface DivPanelMessageWindow extends Element
{
    void clickOK();
    void clickCancel();
    String getMessage();
    String getTitle();
}
