package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.*;
import com.heika.test.utils.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*
<table class="datagrid-btable" cellspacing="0" cellpadding="0" border="0">
	<tbody>
		<tr id="datagrid-row-r2-2-0" datagrid-row-index="0" class="datagrid-row datagrid-row-checked datagrid-row-selected">
			<td field="index">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-index">1</div>
			</td>
			<td field="nickName">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-nickName">nick0930_1</div>
			</td>
			<td field="realName">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-realName">张三</div>
			</td>
			<td field="mobile">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-mobile">13300000003</div>
			</td>
			<td field="idNo">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-idNo"></div>
			</td>
			<td field="userType">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-userType">BD渠道用户</div>
			</td>
			<td field="verifyUserStatus">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-verifyUserStatus">等待提交</div>
			</td>
			<td field="operater">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-operater"></div>
			</td>
			<td field="operateTime">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-operateTime"></div>
			</td>
			<td field="made">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-made">
					<a href="javascript:;" data-userid="100034774" onclick="searchUserDetile(this)" class="newButtonUi">审核流水</a>
				</div>
			</td>
			<td field="linkDetail">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-linkDetail">
					<a href="javascript:;" data-userid="100034774" class="linkParticulars newButtonUi">用户详情</a>
				</div>
			</td>
			<td field="reportOld">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-reportOld">
					<a href="javascript:;" data-userid="100034774" class="report_old newButtonUi">征信原件</a>
				</div>
			</td>
			<td field="detail">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-detail">
					<a href="javascript:;" data-userid="100034774" class="report_detail newButtonUi">查看征信明细</a>
				</div>
			</td>
			<td field="feature">
				<div style="text-align:center;height:auto;" class="datagrid-cell datagrid-cell-c2-feature">
					<a href="javascript:;" data-userid="100034774" class="feature newButtonUi" onclick="User.requireFeature(this)">feature</a>
				</div>
			</td>
			<td field="userId" style="display:none;">
				<div style="height:auto;" class="datagrid-cell datagrid-cell-c2-userId">100034774</div>
			</td>
		</tr>
	</tbody>
</table>
*/
public class UserSearch extends IFramePageBase
{
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[2]/div/div/div/div/div[2]/div[2]/div[2]/table")
    private Table datagrid;

	@FindBy(how = How.XPATH, using = "//div[(@class='panel window' or @class='panel window easyui-fluid') and not(contains(@style,'display: none'))]")
	private DivPanelWindow userVeirfyLogPanleWindow;

	@FindBy(how = How.XPATH, using = "//div[(@class='panel window messager-window') and not(contains(@style,'display: none'))]")
	private DivPanelMessageWindow messageWindow;

	@FindBy(how = How.XPATH, using = "//*[@id=\"waitSearch\"]/div/div[1]/span")
	private Span searchTypeSpan;

	@FindBy(how = How.XPATH, using = "//div[@class='panel combo-p' and not(contains(@style,'display: none'))]")
	private DropDownList searchTypeDropDownList;

    public UserSearch(WebDriver driver)
    {
        super(driver, driver.switchTo().frame(driver.findElement(By.tagName("iframe"))));
    }

	public void setSearchType(String type)
	{
		this.searchTypeSpan.waitForExist();
		this.searchTypeSpan.click();
		this.searchTypeDropDownList.waitForExist();
		this.searchTypeDropDownList.selectByText(type);
	}

    //按姓名点击“审核流水”按钮
    public void click_getUserVerifyLog_button(String realName) throws Exception
    {
        ClickButton("realName", realName, "made");
    }

    //按行号点击“审核流水”按钮
    public void click_getUserVerifyLog_button(int rowIndex) throws Exception
    {
        clickButton(rowIndex, 8);
    }

    //按姓名点击“用户详情”按钮
    public void click_getUserDetail_button(String realName) throws Exception
    {
        ClickButton("realName", realName, "linkDetail");
    }

    //按行号点击“用户详情”按钮
    public void click_getUserDetail_button(int rowIndex) throws Exception
    {
        clickButton(rowIndex, 9);
    }

    //按行号点击“征信原件”按钮
    public void click_getUserPbcReport_button(int rowIndex) throws Exception
    {
        clickButton(rowIndex, 10);
    }

	public void clickOkButtonForMessageWindow()
	{
		this.messageWindow.waitForExist();
		this.messageWindow.clickOK();
	}

	public String getTextForMessageWindow()
	{
		this.messageWindow.waitForExist();
		return this.messageWindow.getMessage();
	}

    private void ClickButton(String type, String value, String field)
    {
        this.datagrid.waitForExist();
        retryForStaleElement(() ->
		{
			List<WebElement> rows = this.datagrid.getRows();
			LogHelper.log(rows.size() + "");
			for (WebElement row : rows)
			{
				if (row.findElement(By.xpath("./td[@field='" + type + "']")).getText().trim().equals(value))
				{
					row.findElement(By.xpath("./td[@field='" + field + "']")).click();
					return;
				}
			}
		});
    }

    private void clickButton(int rowIndex, int colIndex) throws Exception
    {
        this.datagrid.waitForExist();
        retryForStaleElement(() ->
		{
			WebElement button = this.datagrid.getCellAtIndex(rowIndex, colIndex).findElement(By.tagName("a"));
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(button));
			button.click();
		});
    }

	//最大化“审核流水明细”窗口
	public void maxUserVerifyLogWindow()
	{
		this.operateUserVerifyLogPanelWindow(() -> this.userVeirfyLogPanleWindow.maxWindow());
	}

	//关闭“审核流水明细“窗口
	public void closeUserVerifyLogWindow()
	{
		this.operateUserVerifyLogPanelWindow(() -> this.userVeirfyLogPanleWindow.closeWindow());
	}

	//恢复“审核流水明细“窗口
	public void restoreUserVerifyLogWindow()
	{
		this.operateUserVerifyLogPanelWindow(() -> this.userVeirfyLogPanleWindow.restoreWindow());
	}

	private void operateUserVerifyLogPanelWindow(Runnable run)
	{
		this.userVeirfyLogPanleWindow.waitForExist();
		if(this.userVeirfyLogPanleWindow.getWindowTitle().trim().equals("审核流水明细"))
		{
			run.run();
		}
	}
}
