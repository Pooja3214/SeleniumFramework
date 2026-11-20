package com.pages.pageObjectModel.vwo.normalPOM;

import com.utils.PropertiesReader;
import com.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Page class

    //Step0- param constructor
    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    // Step 1- Page Locators
    private By username= By.id("login-username");
    private By password= By.id("login-password");
    private By login_btn= By.id("js-login-btn");
    private By error_message= By.id("js-notification-box-msg");

    // Step 2 - Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd){
        driver.get(PropertiesReader.readKeys("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(login_btn).click();

        new WaitHelpers().checkVisibility(driver,5000,error_message);
        String error_messageText= driver.findElement(error_message).getText();
        return error_messageText;
    }

    public void loginToVWOLoginValidCreds(String user, String pwd){
        driver.get(PropertiesReader.readKeys("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(login_btn).click();

        new WaitHelpers().waitJVM(5000);
    }
}
