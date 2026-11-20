package com.base;
import com.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.driver.DriverManager.driver;
import static com.driver.DriverManager.getDriver;

public class CommonToAllPage {

    public void openVWOUrl(){
       getDriver().get(PropertiesReader.readKeys("url"));
    }

    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKeys("ohr_url"));
    }

    public void openKatalonUrl(){
        getDriver().get(PropertiesReader.readKeys("katalon_url"));
    }

    public void clickElement(By by){
        driver.findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by, String key){
        driver.findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key){
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
       return by.getText();
    }

}
