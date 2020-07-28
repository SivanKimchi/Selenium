package myTests;

import Lametayel.GeneralProperties;  //gitignore
import Lametayel.ScreenshotTaker;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OrderWidgetOnHomePage;

import java.text.ParseException;
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


    @Rule      //screenshot taken when test fails
    public TestRule testWatcher = new TestWatcher() {

        @Override
        public void failed(Throwable e, Description test) {
            ScreenshotTaker screenshotTaker = new ScreenshotTaker(driver);
            screenshotTaker.failed(e, test);

        }

        @Override
        protected void finished(Description description) {
            if (driver != null)
                driver.quit();
        }
    };


//    @After
//    public void closeTest(){
//        driver.quit();
//    }


    @Test
    public void orderFlightOneWay() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        Assert.assertTrue(orderWidget.orderWidgetFlightsApp.isDisplayed());
        Assert.assertEquals(orderWidget.flightsDirection.getText(), "הלוך - חזור");

        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionOneWay.click();

        //search and hit first destination result
        orderWidget.pickDestination("rey");
        Assert.assertTrue(orderWidget.flightsTo.getText().contains("ריאונוסה"));
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        orderWidget.flightsSearchButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        orderWidget.moveToNextTab();

        Assert.assertTrue(driver.getCurrentUrl().contains("flights.lametayel.co.il"));

    }



    @Test
    public void orderFlightInputArrowDown() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.flightsTo.click();
        orderWidget.flightsTo_InputBox.clear();
        Thread.sleep(3000);
        orderWidget.flightsTo_InputBox.sendKeys("rey");
        Thread.sleep(5000);
        orderWidget.flightsTo_InputBox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(orderWidget.flightsTo.getText().contains("רייקייאוויק"));

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
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


    @Test  // enter FUTURE dates only
    public void returnFlightWithSelectedDates() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.pickDestination("paris");

        orderWidget.flightsDatesOneWay.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.calendarMonth));

        orderWidget.pickADateInCalendar("דצמבר", "20");   // future date
        orderWidget.pickADateInCalendar("דצמבר", "25");   // future date
        orderWidget.flightsSearchButton.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        Thread.sleep(3000);
        //Check month and day on flights page filter (according to previously inserted day and month)
        Assert.assertTrue(orderWidget.flightsPageOutboundDate.getAttribute("value").contains("20/12"));
        Assert.assertTrue(orderWidget.flightsPageInboundDate.getAttribute("value").contains("25/12"));
    }



    @Test     //same month
    public void flightWithInvalidDate() throws InterruptedException, ParseException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionOneWay.click();

        orderWidget.flightsDatesOneWay.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.calendarMonth));

//        orderWidget.dontAllowPastDates("יולי", 2);    //int type
        orderWidget.pastDateInCurrentMonthIsInvalid("יולי", 28);    //date type

    }


    @Test
    public void dateInPastMonthInvalid() throws InterruptedException, ParseException{

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.moveToiframe();

        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionOneWay.click();

        orderWidget.flightsDatesOneWay.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.calendarMonth));

        orderWidget.flightsCalenderMoveToPreviousMonth.click();

        orderWidget.dateInPastMonthInvalid("יוני 2020");

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

        orderWidget.flightsMultiplePassengers();     //specific*

        orderWidget.pickDestination("paris");
        orderWidget.flightsSearchButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        Thread.sleep(5000);

        Assert.assertTrue(orderWidget.flightsPageNumOfPassengers.getText().equals("6"));   //specific*

    }

}
