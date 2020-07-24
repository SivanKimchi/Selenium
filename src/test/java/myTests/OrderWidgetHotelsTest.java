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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OrderWidgetOnHomePage;

import java.lang.reflect.Array;
import java.security.Key;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @After
    public void closeTest(){
        driver.quit();
    }


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