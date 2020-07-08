package myTests;

import Lametayel.GeneralProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ls.LSOutput;
import pageObjects.HomePage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SanityTest {


    //members
    private static WebDriver driver;
    public static String siteURL;
    public static String LoginEmail;
    public static String LoginPassword;


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
    public void loginToSite(){

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logIntoSite();

    }


    @Test
    public void userMenuValues(){
        loginToSite();
        HomePage homePage = new HomePage(driver);
        homePage.userMenu.click();

        homePage.assertUserMenuValuesValid();

    }



    @Test
    public void centralBarLinks(){

        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));

        homePage.flights.click();
        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
        driver.navigate().forward();
        Assert.assertTrue(driver.getCurrentUrl().contains("fly.lametayel.co.il"));

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.hotels.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("hotels.lametayel.co.il"));

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.insurance.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("insurance.lametayel.co.il"));

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.benefits.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("club-lametayel"));

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.moreOptions.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(homePage.bottomWidget.isDisplayed());

    }


    @Test
    public void searchBar(){

        HomePage homePage = new HomePage(driver);
        homePage.searchBar.sendKeys("far");

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(homePage.searchAutocomplete));

        //autocomplete dropdown
        homePage.searchBar.sendKeys(Keys.ARROW_DOWN);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        homePage.searchBar.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("faroe-islands"));

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(homePage.searchBar));

        //check PARTIAL input (no autocomplete) in HEBREW >> goes to generic results page   **button does not work on site
        homePage.searchBar.sendKeys("איי פא");
        homePage.searchBar.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(homePage.searchResultsPageH1.getText(),"תוצאות עבור \"איי פא\"");

    }



    @Test
    public void mainMenuDestinations(){

        WebDriverWait wait = new WebDriverWait(driver,10);

        HomePage homePage = new HomePage(driver);
        Actions actions = new Actions(driver);

        actions.moveToElement(homePage.mainMenuDestinations).build().perform();
        wait.until(ExpectedConditions.visibilityOf(homePage.mainMenuDestinationNorthAmerica));
        actions.moveToElement(homePage.mainMenuDestinationNorthAmerica).build().perform();
        homePage.mainMenuDestinationCanada.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("canada"));

    }


    @Test
    public void enterOnlineShop() {

        HomePage homePage = new HomePage(driver);
        homePage.mainMenuLametayelOnlineShop.click();

        homePage.moveToNextTab();

        Assert.assertTrue(driver.getCurrentUrl().contains("shop.lametayel.co.il"));


    }



    @Test
    public void scrollDownToFacebookLike(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        HomePage homepage = new HomePage(driver);

        js.executeScript("arguments[0].scrollIntoView();", homepage.facebookLikeBox);
        System.out.println(homepage.facebookLikeBox.getText());
    }



}
