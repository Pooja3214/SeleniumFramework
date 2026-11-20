package com.tests.vwo.pageFactoryTC;


import com.base.CommonToAllTest;
import com.driver.DriverManager;
import com.pages.pageFactory.LoginPage_PF;
import com.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_PF extends CommonToAllTest {

    public static final Logger logger= LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public static void testLoginNegativeVWO_PF(){

        logger.info("Starting the Testcases Page Factory");
        LoginPage_PF loginPage=new LoginPage_PF(DriverManager.getDriver());
        String error_msg= loginPage.loginToVWOLoginInvalidCreds();

        logger.info("Error msg I got"+ error_msg);
        logger.info("Finished the Testcases Page Factory");
        Assert.assertEquals(error_msg, PropertiesReader.readKeys("error_message"));
    }
}
