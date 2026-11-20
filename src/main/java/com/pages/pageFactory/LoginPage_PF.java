package com.pages.pageFactory;

import com.base.CommonToAllPage;
import com.utils.PropertiesReader;
import com.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_PF extends CommonToAllPage {
    WebDriver driver;

    public LoginPage_PF(WebDriver driver){
        this.driver=driver;
    }

    //Variables- locators
    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id="js-login-btn")
    private WebElement login_btn;

    @FindBy(id="js-notification-box-msg")
    private WebElement error_message;

    //page actions
    public String loginToVWOLoginInvalidCreds(){
        try{
            openVWOUrl();
            enterInput(username, PropertiesReader.readKeys("invalid_username"));
            enterInput(password,PropertiesReader.readKeys("invalid_password"));
            clickElement(login_btn);
            WaitHelpers.waitJVM(4000);
        }catch (Exception e){
            System.out.println("element not found");
        }

return getText(error_message);


    }
}
