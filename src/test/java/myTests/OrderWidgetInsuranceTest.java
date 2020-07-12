package myTests;

import Lametayel.GeneralProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.OrderWidgetOnHomePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OrderWidgetInsuranceTest {


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
    public void orderInsurance() {


        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.scrollDownToWidget(orderWidget.orderWidgetInsurance);

        WebDriverWait wait = new WebDriverWait(driver,5);

        orderWidget.orderWidgetInsurance.click();
        orderWidget.orderInsuranceButton.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        orderWidget.moveToNextTab();

        Assert.assertTrue(driver.getCurrentUrl().contains("insurance.lametayel.co.il"));
    }
}