package com.heika.test.ui.verify.page;

import com.heika.test.common.VerifyUserInvestigateResultEnum;
import com.heika.test.ui.elements.widget.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserInvestigate extends IFramePageBase
{
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div[2]/div[2]/table")
    private Table datagrid;

    @FindBy(how = How.XPATH, using = "//*[@id=\"waitSurvey\"]/div/div[1]/span")
    private Span searchTypeSpan;

    @FindBy(how = How.ID, using = "searchInput")
    private TextInput searchTextInput;

    @FindBy(how = How.ID, using = "userSearchBtn")
    private Button searchButton;

    @FindBy(how = How.XPATH, using = "//div[@class='panel combo-p' and not(contains(@style,'display: none'))]")
    private DropDownList dropDownList;

    @FindBy(how = How.XPATH, using = "//div[(@class='panel window' or @class='panel window easyui-fluid') and not(contains(@style,'display: none'))]")
    private DivPanelWindow investigatePanleWindow;

    @FindBy(how = How.XPATH, using = "//*[@id=\"auditDialogBox\"]/div/div[5]/table/tbody/tr/td[2]/span/input[1]")
    private TextInput onlineTimeTextInput;

    @FindBy(how = How.ID, using = "investNote")
    private TextInput investigateNoteTextInput;

    @FindBy(how = How.ID, using = "approveInvestBtn")
    private Button approveButton;

    @FindBy(how = How.ID, using = "rejectInvest")
    private Button rejectButton;

    @FindBy(how = How.ID, using = "saveIvestBtn")
    private Button saveButton;

    @FindBy(how = How.XPATH, using = "//div[(@class='panel window messager-window') and not(contains(@style,'display: none'))]")
    private DivPanelMessageWindow messageWindow;

    public UserInvestigate(WebDriver driver)
    {
        super(driver, driver.switchTo().frame(driver.findElement(By.tagName("iframe"))));
    }

    public void clickByNickName(String nickName)
    {
        clickButton("nickName", nickName, "action");
    }

    public int getRowCount()
    {
        this.datagrid.waitForExist();
        return this.datagrid.getRows().size();
    }

    private void clickButton(String type, String value, String field)
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
                }
            }
        });
    }

    public void search(String type, String searchContent)
    {
        setSearchType(type);
        this.searchTextInput.set(searchContent);
        this.searchButton.click();
    }

    private void setSearchType(String type)
    {
        this.searchTypeSpan.waitForExist();
        this.searchTypeSpan.click();
        this.dropDownList.waitForExist();
        this.dropDownList.selectByText(type);
    }

    //最大化“调查”窗口
    public void maxInvestigateWindow()
    {
        this.operateUserVerifyLogPanelWindow(() -> this.investigatePanleWindow.maxWindow());
    }

    //关闭“调查“窗口
    public void closeInvestigateWindow()
    {
        this.operateUserVerifyLogPanelWindow(() -> this.investigatePanleWindow.closeWindow());
    }

    private void operateUserVerifyLogPanelWindow(Runnable run)
    {
        this.investigatePanleWindow.waitForExist();
        if(this.investigatePanleWindow.getWindowTitle().trim().equals("调查"))
        {
            run.run();
        }
    }

    private void selectInvRadioButton(String name, VerifyUserInvestigateResultEnum resultEnum)
    {
        this.investigatePanleWindow.waitForExist();
        String xpath = String.format("//input[@type='radio' and @value='%s' and @name='%s']", resultEnum.name(), name);
        this.investigatePanleWindow.findElement(By.xpath(xpath)).click();
    }

    public void selectInvRealName(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("realNameInvResult", resultEnum);
    }

    public void selectInvCompany(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("companyInvResult", resultEnum);
    }

    public void selectInvWorkPosition(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("workPositionInvResult", resultEnum);
    }

    public void selectInvMonthlySalary(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("monthlySalaryInvResult", resultEnum);
    }

    public void selectInvWorkPhone(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("workPhoneInvResult", resultEnum);
    }

    public void selectInvGraduation(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("graduationInvResult", resultEnum);
    }

    public void selectInvUniversity(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("universityInvResult", resultEnum);
    }

    public void selectInvGraduateYear(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("graduateYearInvResult", resultEnum);
    }

    public void selectInvMarriageStatus(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("marriageStatusInvResult", resultEnum);
    }

    public void selectInvChildStatus(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("childStatusInvResult", resultEnum);
    }

    public void selectInvAddress(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("addressInvResult", resultEnum);
    }

    public void selectInvPhone(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("phoneInvResult", resultEnum);
    }

    public void selectInvHasCar(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("hasCarInvResult", resultEnum);
    }

    public void selectInvHasHouse(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("hasHouseInvResult", resultEnum);
    }

    public void selectInvUrgentName(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("urgentNameInvResult", resultEnum);
    }

    public void selectInvUrgentRelation(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("urgentRelationInvResult", resultEnum);
    }

    public void selectInvUrgentMobile(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("urgentMobileInvResult", resultEnum);
    }

    public void selectInvCreditCardNumber(VerifyUserInvestigateResultEnum resultEnum)
    {
        this.selectInvRadioButton("creditCardNumberInvResult", resultEnum);
    }

    public void approveAll()
    {
        this.selectInvRealName(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvCompany(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvWorkPosition(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvMonthlySalary(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvWorkPhone(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvGraduation(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvUniversity(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvGraduateYear(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvMarriageStatus(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvChildStatus(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvAddress(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvPhone(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvHasCar(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvHasHouse(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvUrgentName(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvUrgentRelation(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvUrgentMobile(VerifyUserInvestigateResultEnum.VALID);
        this.selectInvCreditCardNumber(VerifyUserInvestigateResultEnum.VALID);
    }

    public void setOnlineTimeTextInput(Integer time)
    {
        this.onlineTimeTextInput.set(time.toString());
    }

    public void setInvestigateNoteTextInput(String note)
    {
        this.investigateNoteTextInput.set(note);
    }

    public void clickApproveButton()
    {
        this.approveButton.click();
    }

    public void clickRejectButton()
    {
        this.rejectButton.click();
    }

    public void clickSaveButton()
    {
        this.saveButton.click();
    }

    public String getMessaeDialogContent()
    {
        this.messageWindow.waitForExist();
        return this.messageWindow.getMessage();
    }

    public void dismissMessageDialog()
    {
        this.messageWindow.waitForExist();
        this.messageWindow.clickOK();
    }
}
