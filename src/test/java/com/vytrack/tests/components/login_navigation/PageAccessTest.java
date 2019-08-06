package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageAccessTest {
    WebDriver driver;
    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void vehicleContractsTestStoreManager() throws InterruptedException {
        VytrackUtils.login(driver,"storemanager246","UserUser123");
        Thread.sleep(2000);
        VytrackUtils.selectMenuOption(driver, "Fleet","Vehicle Contracts");
        Thread.sleep(2000);
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
    }

    @Test
    public void vehicleContractsTestSalesManager() throws InterruptedException {
        VytrackUtils.login(driver,"salesmanager149","UserUser123");
        Thread.sleep(2000);
        VytrackUtils.selectMenuOption(driver, "Fleet","Vehicle Contracts");
        Thread.sleep(2000);
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
    }

    @Test
    public void vehicleContractsTesDriver() throws InterruptedException {
        VytrackUtils.login(driver,"user45","UserUser123");
        Thread.sleep(2000);
        VytrackUtils.selectMenuOption(driver, "Fleet","Vehicle Contracts");
        Thread.sleep(2000);
//        Assert.assertTrue(driver.findElements(By.xpath("//*[text()='You do not have permission to perform this action.']")).size()==1);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You do not have permission to perform this action.']")).isDisplayed());

    }



}
