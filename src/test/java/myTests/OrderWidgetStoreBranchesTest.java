package myTests;

import Lametayel.GeneralProperties; //gitignore
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OrderWidgetOnHomePage;

import java.util.concurrent.TimeUnit;

public class OrderWidgetStoreBranchesTest {


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
    public void storeBranches() {


        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);

        orderWidget.enterOrderWidgetSection(orderWidget.orderWidgetStores, orderWidget.orderStoreBranchesButton);

        Assert.assertTrue(orderWidget.firstBranch.getText().contains("דיזנגוף סנטר"));
        Assert.assertTrue(orderWidget.firstBranchLowerMenu.getText().contains("דיזנגוף סנטר"));

        orderWidget.firstBranch.click();
        Assert.assertTrue(orderWidget.firstBranchMoreInfoPageHeadline.getText().contains("דיזנגוף סנטר"));


    }
}