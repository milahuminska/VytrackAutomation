package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuOptionsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com");
    }

    String accountLocator = "//span[text()='Accounts']";
    String contactsLocator = "//li[@class='dropdown dropdown-level-1'][2]/a/span";

    @Test
    public void loginAsADriver() throws InterruptedException {

        driver.findElement(By.id("prependedInput")).sendKeys("user45");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(1000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);

        VytrackUtils.selectMenuOption(driver, "Fleet","Vehicles");
        String expected = "Car - Entities - System - Car - Entities - System";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
//        String expectedPageName = "All Cars";
//        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
//        Assert.assertEquals(expectedPageName, actualPageName);


        driver.findElement(By.xpath(contactsLocator)).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Accounts")).click();
        Thread.sleep(2000);
        String expected2 = "Accounts - Customers";
        String actual2 = driver.getTitle();
        Assert.assertEquals(actual2, expected2);
        Thread.sleep(2000);
        String expectedPageName2 = "Accounts";
        String actualPageName2 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName2, actualPageName2);



        driver.navigate().back();

        Thread.sleep(2000);
        driver.findElement(By.xpath(contactsLocator)).click();
        driver.findElement(By.partialLinkText("Contacts")).click();
        Thread.sleep(2000);
        String expected3 = "Contacts - Customers";
        String actual3 = driver.getTitle();
        Assert.assertEquals(actual3, expected3);
        Thread.sleep(2000);
        String expectedPageName3 = "Contacts";
        String actualPageName3 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName3, actualPageName3);


        driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Calendar Events")).click();
        Thread.sleep(2000);
        String expected4 = "Calendar Events - Activities";
        String actual4 = driver.getTitle();
        Assert.assertEquals(actual4, expected4);
        Thread.sleep(2000);
        String expectedPageName4 = "Calendar Events";
        String actualPageName4 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName4, actualPageName4);


        driver.quit();

    }

    @Test
    public void loginAsStoreManager() throws InterruptedException {

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager246");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(1000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);

        VytrackUtils.selectMenuOption(driver, "Dashboards","Dashboard");
        Thread.sleep(2000);
        String expected = "Dashboard - Dashboards";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
        String expectedPageName = "Dashboard";
        String actualPageName =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName,actualPageName);

        VytrackUtils.selectMenuOption(driver, "Fleet","Vehicles");
        Thread.sleep(2000);
        String expected1 = "All - Car - Entities - System - Car - Entities - System";
        String actual1 = driver.getTitle();
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
//        String expectedPageName1 = "All Cars";
//        String actualPageName1 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
//        Assert.assertEquals(expectedPageName1, actualPageName1);

        VytrackUtils.selectMenuOption(driver, "Customers","Accounts");
        Thread.sleep(2000);
        String expected2 = "All - Accounts - Customers";
        String actual2 = driver.getTitle();
        Assert.assertEquals(actual2, expected2);
        Thread.sleep(2000);
        String expectedPageName2 = "All Accounts";
        String actualPageName2 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName2, actualPageName2);

        VytrackUtils.selectMenuOption(driver, "Customers","Contacts");
        Thread.sleep(2000);
        String expected3 = "All - Contacts - Customers";
        String actual3 = driver.getTitle();
        Assert.assertEquals(actual3, expected3);
        Thread.sleep(2000);
        String expectedPageName3 = "All Contacts";
        String actualPageName3 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName3, actualPageName3);

        VytrackUtils.selectMenuOption(driver, "Sales","Opportunities");
        Thread.sleep(2000);
        String expected4 = "Open Opportunities - Opportunities - Sales";
        String actual4= driver.getTitle();
        Assert.assertEquals(actual4, expected4);
        Thread.sleep(2000);
        String expectedPageName4 = "Open Opportunities";
        String actualPageName4 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName4, actualPageName4);

        VytrackUtils.selectMenuOption(driver, "Activities","Calls");
        Thread.sleep(2000);
        String expected5 = "All - Calls - Activities";
        String actual5= driver.getTitle();
        Assert.assertEquals(actual5, expected5);
        Thread.sleep(2000);
        String expectedPageName5 = "All Calls";
        String actualPageName5 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName5, actualPageName5);

        VytrackUtils.selectMenuOption(driver, "Activities","Calendar Events");
        Thread.sleep(2000);
        String expected6 = "All - Calendar Events - Activities";
        String actual6= driver.getTitle();
        Assert.assertEquals(actual5, expected5);
        Thread.sleep(2000);
        String expectedPageName6 = "All Calendar Events";
        String actualPageName6 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName6, actualPageName6);













    }



}
