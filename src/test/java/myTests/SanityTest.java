package myTests;

import Lametayel.GeneralProperties;
import org.junit.After;
import org.junit.Assert;
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

    @After
    public void closeTest(){
        driver.close();
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

        Assert.assertTrue(homePage.userMenu.isDisplayed());

    }

    @Test
    public void userMenuValues(){
        loginToSite();
        HomePage homePage = new HomePage(driver);
        homePage.userMenu.click();

        Assert.assertEquals(homePage.userMenuName.getText(), "היי earth_trekker");
        Assert.assertEquals(homePage.userMenuLametayelSheliClub.getText(), "מועדון למטייל שלי");
        Assert.assertEquals(homePage.userMenuEditProfile.getText(), "עריכת הפרופיל");
        Assert.assertEquals(homePage.userMenuViewProfile.getText(), "צפיה בפרופיל");
        Assert.assertEquals(homePage.userMenuNewsletterManagement.getText(), "ניהול הרשמות ודיוורים");
        Assert.assertEquals(homePage.userMenuAddNewContent.getText(), "הוספת תוכן חדש");
        Assert.assertEquals(homePage.userMenuAddNewTip.getText(), "טיפ");
        Assert.assertEquals(homePage.userMenuAddNewBlogPost.getText(), "פוסט לבלוג");
        Assert.assertEquals(homePage.userMenuAddNewPartnersAd.getText(), "מודעת מחפשים שותפים");
        Assert.assertEquals(homePage.userMenuMyContents.getText(), "התכנים שלי");
        Assert.assertEquals(homePage.userMenuMyMessages.getText(), "הודעות");
        Assert.assertEquals(homePage.userMenuMyFavorites.getText(), "המועדפים שלי");
        Assert.assertEquals(homePage.userMenuMyPublishedContents.getText(), "התכנים שפירסמתי");
        Assert.assertEquals(homePage.userMenuMyContentsComments.getText(), "תגובות לתכנים שפירסמתי");
        Assert.assertEquals(homePage.userMenuDisconnect.getText(), "יציאה מהמערכת");


        Assert.assertEquals(homePage.userMenuName.getAttribute("role"), "presentation");
        Assert.assertEquals(homePage.userMenuAddNewContent.getAttribute("role"), "presentation");
        Assert.assertEquals(homePage.userMenuMyContents.getAttribute("role"), "presentation");

    }







}
