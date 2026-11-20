package com.tests.vwo.pageObjectModelTC;

import com.base.CommonToAllTest;
import com.driver.DriverManager;
import com.pages.pageObjectModel.vwo.normalPOM.LoginPage;
import com.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_Prop_POM extends CommonToAllTest {

    //D
    //L
    //V

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Prop_POM.class);


    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){

        logger.info("Starting the Testcases Page Object Model");
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());

        String error_msg= loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKeys("invalid_username"),PropertiesReader.readKeys("invalid_password"));

        //   // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKeys("error_message"));

        tearDown();
    }
}
