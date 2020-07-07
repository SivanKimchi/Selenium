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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.OrderWidgetOnHomePage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OrderWidgetTest {


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

//    @After
//    public void closeTest(){
//        driver.close();
//    }


    @Test
    public void orderFlightOneWay() throws InterruptedException {

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", orderWidget.orderWidget);
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(orderWidget.flightsiframe));
        driver.switchTo().frame(orderWidget.flightsiframe);

        Assert.assertTrue(orderWidget.orderWidgetFlightsApp.isDisplayed());
        Assert.assertEquals(orderWidget.flightsDirection.getText(), "הלוך - חזור");

        //check direction with click on first result and then with arrow down
        orderWidget.flightsDirection.click();
        orderWidget.flightsDirectionFirstChoice.click();
        orderWidget.flightsTo.click();


       // driver.switchTo().defaultContent();
       // driver.switchTo().frame(2);

  //      wait.until(ExpectedConditions.visibilityOf(orderWidget.flightsDestinationiframe));
//        driver.switchTo().frame(orderWidget.flightsDestinationiframe);
//2 not interactable


        orderWidget.flightsTo_InputBox.clear();
        Thread.sleep(3000);
        orderWidget.flightsTo_InputBox.sendKeys("rey");
        Thread.sleep(5000);
        orderWidget.flightsTo_InputBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

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

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        Assert.assertTrue(driver.getCurrentUrl().contains("flights.lametayel.co.il"));

    }



}
