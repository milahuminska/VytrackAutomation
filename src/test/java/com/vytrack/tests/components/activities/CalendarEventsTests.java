package com.vytrack.tests.components.activities;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VytrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarEventsTests extends TestBase {


    @Test
    public void verifyDateAutoJustTest() {
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.selectNextday();
        Assert.assertEquals(calendarEventsPage.startDate.getAttribute("value"), calendarEventsPage.endDate.getAttribute("value"));

        calendarEventsPage.selectTodayday();
        Assert.assertEquals(calendarEventsPage.startDate.getAttribute("value"), calendarEventsPage.endDate.getAttribute("value"));

    }

    @Test
    public void verifyDateAutoJustTest2() {
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.selectStartTime(0);

        VytrackUtils.waitForUIOverlay();
        Assert.assertEquals(1, calendarEventsPage.differenceBetweenStartTimeAndEndTime());

    }

    @Test
    public void verifyDateTimeEnddateTimeAutoAdjustTest3() {
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.selectStartTimeWithStr("11:30 PM");

        //verify that end date is tomorrows date
        Assert.assertEquals(calendarEventsPage.endDate.getAttribute("value"), calendarEventsPage.getDate(1));

        Assert.assertEquals(calendarEventsPage.differenceBetweenStartTimeAndEndTime(), 1);

    }

    @Test(description = "Daily repeat option, Repeat every, summary")
    public void dailyRepeatTest1() {

        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.clickOnRepeatBox();
        Assert.assertEquals(calendarEventsPage.getRepeats(), "Daily");

        Assert.assertTrue(calendarEventsPage.verifyDaysCheckboxIsSelected());

        Assert.assertEquals(calendarEventsPage.getRepeatsEveryValue(), "1");

        Assert.assertEquals(calendarEventsPage.getSummaryMessage(), "Daily every 1 day");

        calendarEventsPage.clickOnWeekdayCheckBox();

        Assert.assertTrue(calendarEventsPage.verifyRepeatEveryInputDisabled());
        Assert.assertEquals(calendarEventsPage.getSummaryMessage(), "Daily, every weekday");


    }

    @Test(description = "Daily repeat option, Repeat every, default values")
    public void DailyRepeatOptionRepeatEveryDefaultValuesTest2(){
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.clickOnRepeatBox();
        Assert.assertEquals(calendarEventsPage.getRepeats(), "Daily");

        Assert.assertTrue(calendarEventsPage.verifyDaysCheckboxIsSelected());

        Assert.assertEquals(calendarEventsPage.getRepeatsEveryValue(), "1");

        Assert.assertEquals(calendarEventsPage.getSummaryMessage(), "Daily every 1 day");


    }

    @Test(description = "Daily repeat option, Repeat every day(s), error messages")
    public void verifyDailyRepeatWarningMessage(){
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.clickOnRepeatBox();
        calendarEventsPage.enterRepeatEveryInputBox("120");
        Assert.assertEquals("The value have not to be more than 99.", calendarEventsPage.getWarningMessageForRepeatEveryInput());

        calendarEventsPage.enterRepeatEveryInputBox("0");
        Assert.assertEquals("The value have not to be less than 1.", calendarEventsPage.getWarningMessageForRepeatEveryInput());

        calendarEventsPage.enterRepeatEveryInputBox("55");

        Assert.assertFalse(calendarEventsPage.verifyWarningMessageForRepeatEveryInputIsDisplayed());
    }

    @Test(description = "Daily repeat option, Repeat every day(s), functionality")
    public void verifyDailyRepeatValueTest(){
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.clickOnRepeatBox();
        calendarEventsPage.enterRepeatEveryInputBox("55");
        Assert.assertEquals("Daily every 55 days", calendarEventsPage.getSummaryMessage());

        calendarEventsPage.enterRepeatEveryInputBox("86");
        Assert.assertEquals("Daily every 86 days", calendarEventsPage.getSummaryMessage());
    }


    @Test(description = "Daily repeat option, blank fields")
    public void verifyDailyRepeatValueBlankTest(){
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login("user45", "UserUser123");

        VytrackUtils.selectMenuOption(Driver.get(), "Activities", "Calendar Events");

        calendarEventsPage.createCalendarEventBtn.click();
        VytrackUtils.waitForUIOverlay();

        calendarEventsPage.clickOnRepeatBox();
        calendarEventsPage.clearRepeatEveryInputBox();

        Assert.assertEquals("This value should not be blank.", calendarEventsPage.getWarningMessageForRepeatEveryInput());

        calendarEventsPage.enterRepeatEveryInputBox("55");

        Assert.assertFalse(calendarEventsPage.verifyWarningMessageForRepeatEveryInputIsDisplayed());

        calendarEventsPage.clickOnAfterRadioButton();
        calendarEventsPage.clearAfterInputBox();

        Assert.assertEquals("This value should not be blank.", calendarEventsPage.getWarningMessageForOccurrencesInput());

        calendarEventsPage.enterAfterValue("5");

        Assert.assertFalse(calendarEventsPage.verifyWarningMessageForOccurrencesInputIsDisplayed());


    }


}
