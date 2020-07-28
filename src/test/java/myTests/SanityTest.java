package myTests;

import Lametayel.ScreenshotTaker;
import org.json.simple.parser.ParseException;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import Lametayel.GeneralProperties;    //uses JsonValues.json -- gitignore (template available)


public class SanityTest {


    //members
    private static WebDriver driver;
    public static String siteURL;
    public static String LoginEmail;
    public static String LoginPassword;



//    public static WebDriver getDriver(){
//        return driver;
//    }


    @Before
    public void setUp() throws IOException, ParseException {


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




    @Test
    public void loginToSite() {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        homePage.logIntoSite();
        Assert.assertTrue(homePage.userMenu.isDisplayed());

    }


    @Test
    public void invalidLogin() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.invalidLogIn();

    }


    @Test
    public void userMenuValues() {

        loginToSite();
        HomePage homePage = new HomePage(driver);
        homePage.userMenu.click();

        homePage.assertUserMenuValuesValid();   // specific to user

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
    public void searchBarWithAutoComplete(){

        HomePage homePage = new HomePage(driver);
        homePage.searchBarAutoComplete("far", "faroe-islands");

    }


    @Test
    public void searchBarInstantEnter(){
        HomePage homePage = new HomePage(driver);

        //check PARTIAL input (no autocomplete) in HEBREW >> goes to generic results page   **button does not work on site
        homePage.searchBarInstantEnter("איי פא", "תוצאות עבור \"איי פא\"");

    }


    @Test
    public void mainMenuDestinations(){

        HomePage homePage = new HomePage(driver);
        homePage.mainMenuDestinationDropDown(0, 2);

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
