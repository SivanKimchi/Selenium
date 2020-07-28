package myTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.OrderWidgetOnHomePage;
import Lametayel.GeneralProperties;    //uses JsonValues.json -- gitignore (template available)

public class OrderWidgetVehicleTest {


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
    public void orderCar() {


        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.enterOrderWidgetSection(orderWidget.orderWidgetCar, orderWidget.orderVehicleButton);

        Assert.assertTrue(driver.getCurrentUrl().contains("car-rental.lametayel.co.il"));
    }
}