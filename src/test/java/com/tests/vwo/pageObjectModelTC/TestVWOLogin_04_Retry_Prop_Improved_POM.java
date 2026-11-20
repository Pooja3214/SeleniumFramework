package com.tests.vwo.pageObjectModelTC;

import com.base.CommonToAllTest;
import com.listeners.RetryAnalyzer;
import com.pages.pageObjectModel.vwo.improved_POM.LoginPage;
import com.utils.PropertiesReader;
import com.utils.TakeScreenShot;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import static com.driver.DriverManager.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_04_Retry_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_04_Retry_Prop_Improved_POM.class);

    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail(){
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }

    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass(){
        LoginPage loginPage= new LoginPage(getDriver());
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        String error_msg= loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKeys("invalid_username"),PropertiesReader.readKeys("invalid_password"));
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        new TakeScreenShot().takeScreenshot("testPass_1");
        //new TakesScreenshot().takeScree;
        Assert.assertTrue(true);
    }
}
