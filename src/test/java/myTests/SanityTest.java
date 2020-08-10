package myTests;

import Lametayel.ScreenshotTaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public static Logger log = LogManager.getLogger(SanityTest.class.getName());




    @Before
    public void setUp() throws IOException, ParseException {


        System.setProperty(GeneralProperties.driverName, GeneralProperties.driverLocation);
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(GeneralProperties.SiteURL1);
        log.info("Opened driver");
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
            System.out.println("Logged test data to testLogs.log using log4j");
            if (driver != null)
                driver.quit();
        }
    };




    @Test
    public void loginToSite() {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        log.debug("Clicked on main login button");
        homePage.logIntoSite();
        Assert.assertTrue(homePage.userMenu.isDisplayed());
        log.info("Finished main login successfully");

    }


    @Test
    public void invalidLogin() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.invalidLogIn();
        log.info("Finished validating login successfully");

    }


    @Test
    public void userMenuValues() {

        loginToSite();
        HomePage homePage = new HomePage(driver);
        homePage.skipAd();
        homePage.userMenu.click();
        log.debug("Clicked on logged-in user menu");
        homePage.assertUserMenuValuesValid();   // specific to user
        log.info("Finished validating all user menu links");
    }



    @Test
    public void centralBarLinks() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));

        homePage.flights.click();
        log.debug("Clicked on 'flights'");
//        Thread.sleep(5000);
        homePage.skipAd();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("fly.lametayel.co.il"));
        log.info("Entered flights page");

        driver.navigate().back();
        homePage.skipAd();
//        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.hotels.click();
        log.debug("Clicked on 'hotels'");
//        Thread.sleep(5000);
        homePage.skipAd();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("hotels.lametayel.co.il"));
        log.info("Entered hotels page");

        driver.navigate().back();
//        Thread.sleep(5000);
        homePage.skipAd();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.insurance.click();
        log.debug("Clicked on 'insurance'");
//        Thread.sleep(3000);
        homePage.skipAd();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("insurance.lametayel.co.il"));
        log.info("Entered insurance page");

        driver.navigate().back();
//        Thread.sleep(5000);
        homePage.skipAd();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.benefits.click();
        log.debug("Clicked on 'benefits'");
//        Thread.sleep(3000);
        homePage.skipAd();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("club-lametayel"));
        log.info("Entered benefits page");

        driver.navigate().back();
//        Thread.sleep(5000);
        homePage.skipAd();
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.moreOptions.click();
        log.debug("Clicked on 'more options'");
//        Thread.sleep(5000);
        Assert.assertTrue(homePage.bottomWidget.isDisplayed());
        log.info("Scrolled to bottom widget");
        log.info("Finished validating all central bar links");

    }


    @Test
    public void searchBarWithAutoComplete(){

        HomePage homePage = new HomePage(driver);
        homePage.searchBarAutoComplete("far", "faroe-islands");
        log.info("Finished validating main search with auto complete");

    }


    @Test
    public void searchBarInstantEnter(){
        HomePage homePage = new HomePage(driver);

        //check PARTIAL input (no autocomplete) in HEBREW >> goes to generic results page   **button does not work on site
        homePage.searchBarInstantEnter("איי פא", "תוצאות עבור \"איי פא\"");
        log.info("Finished validating main search with instant Enter");

    }


    @Test
    public void mainMenuDestinations(){

        HomePage homePage = new HomePage(driver);
        homePage.mainMenuDestinationDropDown(0, 2);
        log.info("Finished picking destinations from top bar successfully");

    }


    @Test  //example of moving to another tab
    public void enterOnlineShop() {

        HomePage homePage = new HomePage(driver);
        homePage.mainMenuLametayelOnlineShop.click();
        log.debug("Clicked on shop link");
        homePage.moveToNextTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("shop.lametayel.co.il"));
        log.info("Entered online shop successfully");

    }


    @Test   //example for using JavaScript
    public void scrollDownToFacebookLike(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage homepage = new HomePage(driver);
        js.executeScript("arguments[0].scrollIntoView();", homepage.facebookLikeBox);
        log.info("Scrolled down successfully using JavascriptExecutor- " + homepage.facebookLikeBox.getText());

    }

}
