package com.tests.vwo.pageFactoryTC;


import com.driver.DriverManager;
import com.pages.pageFactory.DashBoardPage_PF;
import com.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWODashboard_PF {
    public static final Logger logger= LogManager.getLogger(TestVWODashboard_PF.class);

    @Test
    public static void loggedInUsername(){
        logger.info("Starting the Testcases Page Factory");
        DashBoardPage_PF dashBoardPagePf= new DashBoardPage_PF(DriverManager.getDriver());
        String dashboard= dashBoardPagePf.loggedInUsername();
        Assert.assertEquals(dashboard, PropertiesReader.readKeys("username"));
    }
}
