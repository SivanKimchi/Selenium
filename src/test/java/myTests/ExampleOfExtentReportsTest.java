package myTests;

import Lametayel.GeneralProperties;
import Lametayel.ScreenshotTaker;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class ExampleOfExtentReportsTest {


    //members
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static ExtentReports extent;
    ExtentTest test;


    @BeforeClass
    public static void extentReports() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");  //configure right button
        reporter.config().setDocumentTitle("My reports");     // configure tab title

        extent = new ExtentReports();
        extent.attachReporter(reporter);  //what was created with ExtentSparkReporter
        extent.setSystemInfo("Tester", "Sivan");
    }


    @Before
    public void setUp(){

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
//            if (driver != null)
//                driver.quit();
        }
    };



    @Test
    public void loginWithExtentReport(){

        test = extent.createTest("loginWithExtentReport");

        HomePage home = new HomePage(driver);
        home.logInButton.click();
        home.logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        home.logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        home.logInSubmit.click();
        home.skipAd();
        test.log(Status.INFO, "Submitted login form");

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(home.userMenu));

            Assert.assertTrue(home.userMenu.isDisplayed());
            test.log(Status.PASS, "Test passed!");
        } catch (Exception e){
            test.log(Status.FAIL, "Test failed :(");
        }
        extent.flush();  //finish extent reports
    }


    @Test
    public void invalidLoginWithExtentReport(){

        test = extent.createTest("invalidLoginWithExtentReport");

        HomePage home = new HomePage(driver);
        home.logInButton.click();
        home.logInInputEmail.sendKeys("email@gmail.com");
        home.logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        home.logInSubmit.click();
        test.log(Status.INFO, "Submitted login form with wrong email");

        try {
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            Assert.assertTrue(home.logInSubmit.isDisplayed());
            test.pass("Yay, test passed!");
        } catch (Exception e){
            test.fail("Oh no, test failed :(");
        }
        extent.flush();  //finish extent reports
    }


}
