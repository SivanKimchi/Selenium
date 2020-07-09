package myTests;

import Lametayel.GeneralProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

//    @After
//    public void closeTest(){
//        driver.close();
//    }


    @Test
    public void orderHotelDefaultDatesAndRoom() throws InterruptedException {     //1 room 2 adults

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.scrollDownToWidget(orderWidget.orderWidgetHotels);

        WebDriverWait wait = new WebDriverWait(driver,10);

        orderWidget.orderWidgetHotels.click();
        orderWidget.moveToiframe();

        try {
            orderWidget.hotelSearchButton.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            orderWidget.moveToNextTab();
        } catch (Exception e){
            System.out.println("No city or hotel inserted- can't continue search. Please type Hotel name or City.");
        }

        orderWidget.pickDestinationOrHotelName("Paris");   // english-first letter in CAPS)

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        orderWidget.moveToNextTab();

        //  ?? doesn't work when trying to check in HOTELS tab search results (even after switching to iframe)
        // orderWidget.moveToHotelsPageiframe();
        // wait.until(ExpectedConditions.visibilityOf(orderWidget.hotelsPageSearchBreadcrumb));
       // Assert.assertTrue(orderWidget.hotelsPageSearchBreadcrumb.getText().contains("פריז"));

        Assert.assertTrue(driver.getCurrentUrl().contains("Paris"));

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(windows.get(0));

        //Check the same with HOTEL name
        orderWidget.orderWidgetHotels.click();
        orderWidget.moveToiframe();
        orderWidget.pickDestinationOrHotelName("Ibis");   // english-first letter in CAPS)
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        orderWidget.moveToNextTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("Ibis"));

    }
}