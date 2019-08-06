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

public class LoginTest {
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
    public void logInTest() throws InterruptedException {
        VytrackUtils.login(driver,"storemanager246","UserUser123");
        Thread.sleep(2000);
        //Verify	name	of	the	store	manageris	displayed	on	top
        String expectedName = "Deven McClure";
        String actualName =driver.findElement(By.cssSelector("#user-menu > a")).getText().trim();
        Assert.assertEquals(expectedName,actualName);
        Thread.sleep(2000);
        //Verify Dashboad page
        String expectedPageName = "Dashboard";
        String actualPageName =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName,actualPageName);
        Thread.sleep(2000);
        //log out
        driver.findElement(By.cssSelector("#user-menu > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);

        VytrackUtils.login(driver,"salesmanager149","UserUser123");
        Thread.sleep(2000);
        //Verify Dashboad page
        String expectedPageName2 = "Dashboard";
        String actualPageName2 =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName2,actualPageName2);
        Thread.sleep(2000);

        //A	different	name	should	be	displayed	on
        String actualName2 =driver.findElement(By.cssSelector("#user-menu > a")).getText().trim();
        Assert.assertNotEquals(actualName2, expectedName);
        Thread.sleep(2000);

        //log out
        driver.findElement(By.cssSelector("#user-menu > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);

        VytrackUtils.login(driver,"user45","UserUser123");
        Thread.sleep(2000);
        String expectedPageName3 = "Quick Launchpad";
        String actualPageName3 =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName3,actualPageName3);
        Thread.sleep(2000);
        //A	different	name	should	be	displayed	on
        String actualName3 =driver.findElement(By.cssSelector("#user-menu > a")).getText().trim();
        Assert.assertNotEquals(actualName3, actualName);
        Assert.assertNotEquals(actualName3, actualName2);
        Thread.sleep(2000);

    }
    @Test
    public void negativeLoginTest() throws InterruptedException {
        String expectedTitle = driver.getTitle();
        String expectedUrl = driver.getCurrentUrl();
        VytrackUtils.login(driver,"storemanager246","UserUser12");
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        String expectedMessage = "Invalid user name or password.";
        String actualMessage = driver.findElement(By.cssSelector("div[class='alert alert-error'] > div")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertEquals(actualUrl,expectedUrl);
        Assert.assertEquals(actualTitle,expectedTitle);





    }


}
