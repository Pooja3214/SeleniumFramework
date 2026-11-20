package com.pages.pageFactory;

import com.base.CommonToAllPage;
import com.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage_PF extends CommonToAllPage {
    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver){
        this.driver=driver;
    }

    //Locators
    @FindBy(xpath="//h6")
    private WebElement usernameOnDashboard;

    public String loggedInUsername(){
        try{
            WaitHelpers.visibilityOfElement(usernameOnDashboard);
        }catch (Exception e){
            System.out.println("Element not found");
        }
        return getText(usernameOnDashboard);
    }
}
