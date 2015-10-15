package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

@ImplementedBy(DivPanelWindowImpl.class)
public interface DivPanelWindow extends Element
{
    void maxWindow();
    void closeWindow();
    void restoreWindow();
    String getWindowTitle();
}
