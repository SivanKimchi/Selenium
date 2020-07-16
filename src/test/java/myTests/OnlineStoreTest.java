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
import pageObjects.OnlineStorePage;

import java.util.concurrent.TimeUnit;

public class OnlineStoreTest {


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
    public void addItemToCart() {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        store.addItemToCart(0);

        }



    @Test
    public void searchForItem(){
        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        store.searchItem("מקלות הליכה");

    }



}