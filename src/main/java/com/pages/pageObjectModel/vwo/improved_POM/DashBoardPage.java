package com.pages.pageObjectModel.vwo.improved_POM;

import com.base.CommonToAllPage;
import com.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver){
        this.driver= driver;
    }

    //Locators
    private By usernameOnDashboard= By.xpath("//h6");

    //Actions
    public String loggedInUsername(){
        WaitHelpers.visibilityOfElement(usernameOnDashboard);
        return getText(usernameOnDashboard);
    }

}
