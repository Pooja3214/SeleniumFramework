package com.utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.driver.DriverManager.getDriver;

public class TakeScreenShot {

    public void takeScreenshot(String name){
        WebDriver driver=getDriver();
        String methodName= "Screenshots_"+name;

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat formatter= new SimpleDateFormat("dd_mm_YYYY_hh_mm_ss");

        if(driver!=null){

            TakesScreenshot ts= (TakesScreenshot) driver;
           try{
               File srcFile= ts.getScreenshotAs(OutputType.FILE);

               String screenshotPath= "failure_screenshots/"+ methodName+
                       "_"+formatter.format(calendar.getTime())+".png";

               File desFile= new File(screenshotPath);
               FileUtils.copyFile(srcFile,desFile);

               //Add screenshot in testNG report
               Allure.addAttachment("Screenshot","image/png", screenshotPath ,"png");
           }catch (IOException e){
               e.printStackTrace();
           }

        }

    }
}
