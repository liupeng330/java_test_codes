package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.ElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.List;

/*
<div class="combo-panel panel-body panel-body-noheader" title="" style="width: 100px;">
	<div id="_easyui_combobox_i1_0" class="combobox-item">昵称</div>
	<div id="_easyui_combobox_i1_1" class="combobox-item combobox-item-selected">手机号</div>
	<div id="_easyui_combobox_i1_2" class="combobox-item">身份证</div>
	<div id="_easyui_combobox_i1_3" class="combobox-item">姓名</div>
</div>
 */
public class DropDownListImpl extends ElementImpl implements DropDownList
{
    public DropDownListImpl(WebElement element)
    {
        super(element);
    }

    public DropDownListImpl(WebElement element, ElementLocator locator)
    {
        super(element, locator);
    }

    @Override
    public void selectByText(String text)
    {
        List<WebElement> comboboxes = this.getWrappedElement()
                .findElement(By.cssSelector("div.combo-panel.panel-body.panel-body-noheader"))
                .findElements(By.xpath("./div[contains(@class,'combobox-item')]"));
        for(WebElement combobox : comboboxes)
        {
            if(combobox.getText().trim().equals(text))
            {
                combobox.click();
                return;
            }
        }
    }
}
