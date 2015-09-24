package com.heika.test.ui.verify.page;

import com.heika.test.ui.elements.widget.Button;
import com.heika.test.ui.elements.widget.TextInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends PageBase
{
    @FindBy(how = How.ID, using = "username")
    private TextInput userNameTextBox;

    @FindBy(how = How.ID, using = "password")
    private TextInput passwordTextBox;

    @FindBy(how = How.ID, using = "loginCheck")
    private Button loginButton;

    public void Login(String username, String password)
    {
        userNameTextBox.set(username);
        passwordTextBox.set(password);
        loginButton.click();
    }
}
