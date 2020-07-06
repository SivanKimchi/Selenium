package myTests;

import Lametayel.GeneralProperties;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

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

    @Test
    public void loginToSite(){

        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.logInButton.click();
        homePage.logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        homePage.logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        homePage.logInSubmit.click();
        System.out.println("Logged in as existing user");
        System.out.println("testing git");

    }
}
