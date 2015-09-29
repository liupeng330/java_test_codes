package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;
import com.heika.test.utils.TreeNode;
import org.openqa.selenium.WebElement;

@ImplementedBy(NavTreeImpl.class)
public interface NavTree extends Element
{
    void populateTree();
    void clickTreeNodeByTitle(String title);
    boolean existTitleInTree(String title);
}
