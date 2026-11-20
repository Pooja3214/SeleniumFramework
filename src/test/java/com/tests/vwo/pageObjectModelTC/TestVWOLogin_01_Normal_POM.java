package com.tests.vwo.pageObjectModelTC;

import com.pages.pageObjectModel.vwo.normalPOM.LoginPage;
import com.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TestVWOLogin_01_Normal_POM {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test

    public void test_negative_vwo_login(){
        // Driver Manager Code - 1
        WebDriver driver= new ChromeDriver();

        // Page Class Code (POM Code) -
        LoginPage page= new LoginPage(driver);
        String error_msg= page.loginToVWOLoginInvalidCreds(PropertiesReader.readKeys("invalid_username"),PropertiesReader.readKeys("invalid_password"));

        //   // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKeys("error_message"));

        driver.quit();
    }
}
