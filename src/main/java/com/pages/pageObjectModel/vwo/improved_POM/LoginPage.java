package com.pages.pageObjectModel.vwo.improved_POM;

import com.base.CommonToAllPage;
import com.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver= driver;

    }

    // Step 1- Page Locators
    private By username= By.id("login-username");
    private By password= By.id("login-password");
    private By login_btn= By.id("js-login-btn");
    private By error_message= By.id("js-notification-box-msg");

    public String loginToVWOLoginInvalidCreds(String user, String pwd){
    openVWOUrl();
    enterInput(username,user);
enterInput(password,pwd);
clickElement(login_btn);
        WaitHelpers.waitJVM(4000);
return getText(error_message);

    }

}
