package com.pages.pageObjectModel.vwo.normalPOM;

import com.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;

    public DashBoardPage(WebDriver driver){
        this.driver= driver;
    }

    //Locators
    private By usernameOnDashboard= By.xpath("//h6");

    //Actions
    public String loggedInUsername(){
        WaitHelpers.waitJVM(5000);
        driver.get("https://app.vwo.com/#/dashboard\"");
        return driver.findElement(usernameOnDashboard).getText();
    }
}
