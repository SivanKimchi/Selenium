package myTests;


import Lametayel.ScreenshotTaker;
import Lametayel.GeneralProperties;   //gitignore
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OrderWidgetOnHomePage;

public class OrderWidgetHotelsTest {


    //members
    private static WebDriver driver;


    @Before
    public void setUp() {

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
    public void orderHotelByCityDefaultDatesAndRoom() throws InterruptedException {     //1 room 2 adults

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.scrollToHotelsiframe();

        orderWidget.cantOrderHotelWithoutInput();

        orderWidget.pickDestinationOrHotelName("Paris");   // english-first letter in CAPS)

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        orderWidget.moveToNextTab();

        Assert.assertTrue(driver.getCurrentUrl().contains("Paris"));
        System.out.println("Search successful for hotel by city" );

        //  ?? doesn't work when trying to check in HOTELS tab search results (even after switching to iframe)
        // orderWidget.moveToHotelsPageiframe();
        // wait.until(ExpectedConditions.visibilityOf(orderWidget.hotelsPageSearchBreadcrumb));
       // Assert.assertTrue(orderWidget.hotelsPageSearchBreadcrumb.getText().contains("פריז"));

    }



    @Test
    public void orderHotelByNameDefaultDatesAndRoom() throws InterruptedException {     //1 room 2 adults

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.scrollToHotelsiframe();

        orderWidget.pickDestinationOrHotelName("Ibis");   // english-first letter in CAPS)
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        orderWidget.moveToNextTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("Ibis"));
        System.out.println("Search successful for hotel by hotel name");

    }


    @Test
    public void orderHotelChangeRoomOption() {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.scrollToHotelsiframe();

        orderWidget.changeRoomAndGuestsNumbers("חדר אחד, 2 אורחים", "4", "2", "1", "2 חדרים, 8 אורחים", "חדר אחד, 6 אורחים");  //format:  "2 חדרים, 8 אורחים"
    }



    @Test
    public void orderHotelPickDates() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.scrollToHotelsiframe();

        orderWidget.hotelsDates.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(orderWidget.calendarMonth));

        orderWidget.pickADateInCalendar("דצמבר", "20");
        orderWidget.pickADateInCalendar("דצמבר", "25");

        Assert.assertTrue(orderWidget.hotelsDates.getText().contains("20 דצמ"));
        Assert.assertTrue(orderWidget.hotelsDates.getText().contains("25 דצמ"));

        //invalid calendar is tested in OrderWidgetFlightsTest
    }
}