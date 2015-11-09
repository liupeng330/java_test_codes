package com.heika.test.ui.verify.page;

import com.heika.test.models.user.UserSearchResult;
import com.heika.test.ui.elements.widget.*;
import com.heika.test.utils.LogHelper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.soap.Text;
import java.util.ArrayList;
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

	@FindBy(how = How.XPATH, using = "//*[@id=\"waitSearch\"]/div/div[2]/span")
	private Span searchStatusSpan;

	@FindBy(how = How.XPATH, using = "//div[@class='panel combo-p' and not(contains(@style,'display: none'))]")
	private DropDownList dropDownList;

	@FindBy(how = How.ID, using = "oText")
	private TextInput searchTextInput;

	@FindBy(how = How.ID, using = "oSubmit")
	private Button searchButton;

    public UserSearch(WebDriver driver)
    {
        super(driver, driver.switchTo().frame(driver.findElement(By.tagName("iframe"))));
    }

	public void search(String type, String status, String searchContent)
	{
		setSearchType(type);
		setStatusType(status);
		this.searchTextInput.set(searchContent);
		this.searchButton.click();
	}

	public void setSearchType(String type)
	{
		this.searchTypeSpan.waitForExist();
		this.searchTypeSpan.click();
		this.dropDownList.waitForExist();
		this.dropDownList.selectByText(type);
	}

	public void setStatusType(String status)
	{
		this.searchStatusSpan.waitForExist();
		this.searchStatusSpan.click();
		this.dropDownList.waitForExist();
		this.dropDownList.selectByText(status);
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

	public List<UserSearchResult> parseObjectsFromDataGrid(Integer userId)
	{
		List<UserSearchResult> results = new ArrayList<>();
		this.datagrid.waitForExist();
		retryForStaleElement(() ->
		{
			List<WebElement> rows = this.datagrid.getRows();
			for (WebElement row : rows)
			{
				UserSearchResult result = new UserSearchResult();
				if(userId != null)
				{
					result.setUserId(String.valueOf(userId));
				}
				result.setNickName(getFieldValue(row, "nickName"));
				result.setRealName(getFieldValue(row, "realName"));
				result.setMobile(getFieldValue(row, "mobile"));
				result.setIdNo(getFieldValue(row, "idNo"));
				result.setUserType(getFieldValue(row, "userType"));
				result.setVerifyUserStatus(getFieldValue(row, "verifyUserStatus"));
				if(StringUtils.isNotBlank(getFieldValue(row, "operater")))
				{
					result.setOperater(getFieldValue(row, "operater"));
				}
				if(StringUtils.isNotBlank(getFieldValue(row, "operateTime")))
				{
					result.setOperateTime(getFieldValue(row, "operateTime"));
				}

				results.add(result);
			}
		});

		return results;
	}

	private String getFieldValue(WebElement row, String field)
	{
		return row.findElement(By.xpath("./td[@field='" + field + "']")).getText().trim();
	}

	public int getRowCount()
	{
		this.datagrid.waitForExist();
		return this.datagrid.getRows().size();
	}

    private void ClickButton(String type, String value, String field)
    {
        this.datagrid.waitForExist();
        retryForStaleElement(() ->
		{
			List<WebElement> rows = this.datagrid.getRows();
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
