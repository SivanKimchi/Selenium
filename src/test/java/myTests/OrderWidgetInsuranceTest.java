package myTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.OrderWidgetOnHomePage;
import Lametayel.GeneralProperties;    //uses JsonValues.json -- gitignore (template available)

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

    @After
    public void closeTest(){
        driver.quit();
    }


    @Test
    public void orderInsurance() {


        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        orderWidget.enterOrderWidgetSection(orderWidget.orderWidgetInsurance, orderWidget.orderInsuranceButton);

        Assert.assertTrue(driver.getCurrentUrl().contains("insurance.lametayel.co.il"));
    }
}