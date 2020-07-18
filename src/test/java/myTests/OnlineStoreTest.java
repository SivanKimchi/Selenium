package myTests;

import Lametayel.GeneralProperties;
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
    public void searchForItem() throws InterruptedException {
        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        store.searchItem("מקלות הליכה");

    }


    @Test
    public void searchForItemPickAutoSuggestion() throws InterruptedException {
        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        store.searchItemChooseFromList("נעלי");

    }



    @Test
    public void pickAnItemFromTopBar(){
        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();
        wait.until(ExpectedConditions.visibilityOf(store.shopTopBarList.get(5)));

        store.pickAnItemFromTopBar(1, 3, 1);

    }

    @Test    //color(if exists) , size(if exists) , amount, save(+my saved products), branches, add to cart(exists already), brand
    public void itemPageInteraction(){






    }


    @Test
    public void itemReviews(){


    }



    @Test  //items and amounts, summary of amount and payment
    public void shoppingCartUpdateItems(){




    }



    @Test  //items and amounts, summary of amount and payment
    public void paymentWithoutPaying(){




    }



}