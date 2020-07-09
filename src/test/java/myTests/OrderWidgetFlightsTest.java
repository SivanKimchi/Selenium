package myTests;

import Lametayel.GeneralProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.OrderWidgetOnHomePage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OrderWidgetFlightsTest {


    //members
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }



    @Before
    public void setUp(){

        System.setProperty(GeneralProperties.driverName, GeneralProperties.driverLocation);
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(GeneralProperties.SiteURL1);


    }

    @After
    public void closeTest(){
        driver.close();
    }


    @Test
    public void orderFlightOneWay() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        Assert.assertTrue(orderWidget.orderWidgetFlightsApp.isDisplayed());
        Assert.assertEquals(orderWidget.flightsDirection.getText(), "הלוך - חזור");

        //check direction with click on first result and then with arrow down
        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionFirstChoice.click();

        orderWidget.pickDestination("rey");

        Assert.assertTrue(orderWidget.flightsTo.getText().contains("ריאונוסה"));
        orderWidget.flightsTo.click();
        orderWidget.flightsTo_InputBox.clear();
        Thread.sleep(3000);
        orderWidget.flightsTo_InputBox.sendKeys("rey");
        Thread.sleep(5000);
        orderWidget.flightsTo_InputBox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(orderWidget.flightsTo.getText().contains("רייקייאוויק"));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        orderWidget.flightsSearchButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        Assert.assertTrue(driver.getCurrentUrl().contains("flights.lametayel.co.il"));

    }




    @Test
    public void directFlightsOnly() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        //check box for direct flights
        orderWidget.flightsDirectIfChecked.click();
        Assert.assertTrue(orderWidget.flightsDirectIfChecked.isSelected());

        orderWidget.pickDestination("paris");
        orderWidget.flightsSearchButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        wait.until(ExpectedConditions.visibilityOf(orderWidget.flightsPageFilterBar));

        //check for direct flights
        Assert.assertEquals(orderWidget.directFlightSelected.getAttribute("class"), "stops-button selected");
        Assert.assertNotEquals(orderWidget.nondirectFlightSelected.getAttribute("class"), "stops-button selected");

    }


    @Test
    public void returnFlightWithSelectedDates() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.pickDestination("paris");

        orderWidget.flightsDatesOneWay.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.flightsCalendarMonth));

        orderWidget.pickADateToFly("דצמבר", "20");
        orderWidget.pickADateToFly("דצמבר", "25");
        orderWidget.flightsSearchButton.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        //Check month and day on flights page filter (according to previously inserted day and month)
        Assert.assertTrue(orderWidget.flightsPageOutboundDate.getAttribute("value").contains("20/12"));
        Assert.assertTrue(orderWidget.flightsPageInboundDate.getAttribute("value").contains("25/12"));
    }



    @Test
    public void flightWithInvalidDate() throws InterruptedException, ParseException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionFirstChoice.click();

        orderWidget.flightsDatesOneWay.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.flightsCalendarMonth));

        //orderWidget.dontAllowPastDates("אוגוסט", 7);
        orderWidget.pastDateIsInvalid("יולי", 1);

    }


    @Test
    public void dateInPastMonthInvalid() throws InterruptedException, ParseException{

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionFirstChoice.click();

        orderWidget.flightsDatesOneWay.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.flightsCalendarMonth));

        orderWidget.flightsCalenderMoveToPreviousMonth.click();

        orderWidget.dateInPastMonthInvalid("מאי 2020");

    }


    @Test
    public void flightFromAnotherCity() throws InterruptedException {
        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        Assert.assertEquals(orderWidget.flightsFrom.getText(), "תל אביב (TLV)");
        orderWidget.pickOutboundCity("לונדון");
        orderWidget.pickDestination("רומא");

        orderWidget.flightsSearchButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        Thread.sleep(5000);
        //Check to&from on flights page filter (according to previously inserted values)
        Assert.assertTrue(orderWidget.flightsPageOutboundCity.getAttribute("data-label").contains("לונדון"));
        Assert.assertTrue(orderWidget.flightsPageInboundCity.getAttribute("data-label").contains("רומא"));

    }


    @Test
    public void changeNumberOfPassengers() throws InterruptedException {
        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.flightsMultiplePassengers();

        orderWidget.pickDestination("paris");
        orderWidget.flightsSearchButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        Thread.sleep(5000);

        Assert.assertTrue(orderWidget.flightsPageNumOfPassengers.getText().equals("6"));

    }




}
