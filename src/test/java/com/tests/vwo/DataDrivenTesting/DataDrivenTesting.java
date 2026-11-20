package com.tests.vwo.DataDrivenTesting;

import com.base.CommonToAllTest;
import com.driver.DriverManager;
import com.utils.PropertiesReader;
import com.pages.pageObjectModel.vwo.normalPOM.LoginPage;
import com.utils.UtilExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DataDrivenTesting extends CommonToAllTest {
    public static final Logger logger= LogManager.getLogger(DataDrivenTesting.class);

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password){
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(email,password);

        // Assertions - 3 - V

        logger.info("Asserting the Invalid credentials");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKeys("error_message"));
    }

    @DataProvider
    public Object[][] getData(){
        return UtilExcel.getDataFromExcel("sheet1");
    }
}
