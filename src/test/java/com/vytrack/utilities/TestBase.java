package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    //test 1
    //before driver has value
    //test
    // after driver.quit

    //test 2
    // before driver has new value
    //

    @BeforeMethod
    public void setUpMethod() {
        // initializing the webdriver object in the test base class using the Driver utility

        //setting implicit wait --> when elements not found, it will keep trying to find it for 10 seconds
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //open home page
        Driver.get().manage().window().maximize();
        Driver.get().get("http://qa3.vytrack.com");
    }
//
//    @AfterMethod
//    public void tearDownMethod() {
//        // driver.quit();
//        Driver.closeDriver();
//    }


}

