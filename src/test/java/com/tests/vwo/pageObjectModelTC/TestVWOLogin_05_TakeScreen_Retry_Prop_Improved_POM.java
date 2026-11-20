package com.tests.vwo.pageObjectModelTC;

import com.base.CommonToAllTest;
import com.listeners.RetryAnalyzer;
import com.listeners.ScreenshotListener;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.driver.DriverManager.getDriver;
@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_05_TakeScreen_Retry_Prop_Improved_POM extends CommonToAllTest {

        private static final Logger logger = LogManager.getLogger(TestVWOLogin_05_TakeScreen_Retry_Prop_Improved_POM.class);

        @Description("Verify that invalid creds give error message")
        @Test
        public void testFail() {
            getDriver().get("https://app.vwo.com");
            logger.info("Starting the Testcases Page Object Model");
//        Allure.addAttachment("Log output", "text/plain", "This is some log text");
            Assert.assertTrue(false);
        }

        @Description("Verify that invalid creds give error message")
        @Test
        public void testPass() {
            getDriver().get("https://app.vwo.com");
            logger.info("Starting the Testcases Page Object Model");
            Assert.assertTrue(true);
        }




    }