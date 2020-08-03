package myTests;

import Lametayel.ScreenshotTaker;
import Lametayel.GeneralProperties;   //uses JsonValues.json -- gitignore (template available)
import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OnlineStorePage;

import javax.mail.MessagingException;
import java.util.concurrent.TimeUnit;

public class OnlineStoreTest {


    //members
    private static WebDriver driver;
    public static Logger log = LogManager.getLogger(OnlineStoreTest.class.getName());


    @Before
    public void setUp() {

//        ChromeOptions options = new ChromeOptions();
//        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);


        System.setProperty(GeneralProperties.driverName, GeneralProperties.driverLocation);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get(GeneralProperties.SiteURLShop);  //goes straight to shop url
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
//            if (driver != null)
//                driver.quit();
        }
    };

//    @After
//    public void closeTest(){
//        driver.quit();
//    }



    @Test
    public void addItemToCart() {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.addItemToCart(1);
        log.info("Finished adding item to cart successfully");

        }



    @Test
    public void searchForItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        //search
        store.searchItem("מקלות הליכה");
        //sort results
        store.sortResults();
        //number of suggested items at bottom
        store.suggestedItems();
        log.info("Finished item search and sort successfully");
    }


    @Test
    public void searchForItemPickAutoSuggestion() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 2);
        log.info("Finished item search from Auto suggestion successfully");
    }



    @Test
    public void pickAnItemFromTopBar(){

        OnlineStorePage store = new OnlineStorePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(store.shopTopBarList.get(5)));

        store.pickAnItemFromTopBarCategories(1, 3, 1);
        log.info("Finished picking item from above bar successfully");
    }



    @Test
    public void itemChangeColor() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("מכנסיים מתקצרים", 2); //  ("סנדלי גברים") הולך אחורה בצבע / "מכנסיים מתקצרים"-הולך קדימה

        store.changeItemColor();
        log.info("Finished validating item's color change successfully");

    }

    @Test
    public void itemChangeSize() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("נעלי נשים", 1);

        store.changeItemSize();
        log.info("Finished validating item's size change successfully");
    }

    @Test
    public void changeQuantityOfItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("בקבוק", 1);

        store.changeQuantityOfItem();
        log.info("Finished validating item's quantity change successfully");
    }


    @Test
    public void saveProduct() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.tryToSaveProductUserNotLoggedIn();
        //goes to user's STORE account and then navigates back to item page as logged in user
        log.debug("Navigating back to item's page");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        store.saveItemAsLoggedInUserInStore();
        log.info("Finished validating 'save item' successfully");
    }



    @Test
    public void availabilityInBranches() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.availabilityInBranches(2);
        log.info("Finished validating availability in branches successfully");

    }



    @Test
    public void itemMoreOfSameBrand() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.moreProductsFromBrand();
        log.info("Finished validating item's brand successfully");
    }



    @Test
    public void itemReviewsCount() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("נעלי טיולים לגברים Northside Weston Mid", 1);   //נעלי טיולים לגברים Northside Weston Mid ,  אוהל קמפינג

        store.exactAverage0fStarsRating();
        log.info("Finished counting reviews successfully");
    }


    @Test
    public void addReviewToItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.addReviewToItem();
        log.info("Finished validating review add successfully");
    }


    @Test
    public void shoppingCartUpdateQuantity() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);
        store.lametayelShopLogo.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        store.addItemToCart(2);

        store.changeCartItemsQuantity();
        log.info("Finished validating shopping cart quantity update successfully");

    }


    @Test  //sum of quantity and payment, delivery  (cart page)
    public void shoppingCartSummary() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);
        //increase +1 quantity
        store.increaseQuantityList.get(0).click();
        log.debug("Increased quantity by 1");
        Thread.sleep(5000);

        store.lametayelShopLogo.click();
        Thread.sleep(5000);
        store.addItemToCart(4);

        store.shoppingCartItemTotalPrice();
        store.shoppingCartPaymentSummary();
        log.info("Finished validating shopping cart summary successfully");
    }



    @Test  //payment
    public void paymentWithoutPaying() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);
        store.continueToPaymentButton.click();
        log.debug("Clicked on button 'continue to payment'");
        store.paymentWithoutPayment("PayPal");  //paying methods: Buyme, Credit Card , PayPal
        log.info("Finished validating payment (without actual payment!!) successfully");
    }



    @Test
    public void sendEmailWhenItemOutOfStock () throws Exception {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.searchItemChooseFromAutocompleteList("חגורת כסף כפולה למותן Must Have", 0);   //חגורת כסף כפולה למותן Must Have  //סנדלי שורש
        store.sendEmailIfOutOfStock("sivankimchi@gmail.com");
        log.info("Finished validating email notification for out-of-stock item");

    }

    @Test    //example only... can't actually switch item from "not in stock" to "in stock" so this is made on 2 different items
    public void sendEmailToCustomerWhenItemReturnsToStock () throws Exception {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.searchItemChooseFromAutocompleteList("חגורת כסף כפולה למותן Must Have", 0);   //חגורת כסף כפולה למותן Must Have  //סנדלי שורש
        store.sendEmailIfBackInStock("חולצה", 0);
        log.info("Finished validating email notification for CUSTOMER when item is back in stock");

    }



    @Test    //check with specific item over time - scheduled for @daily test on Jenkins
    public void sendEmailToCustomerWhenItemReturnsToStock_JenkinsScheduler () throws Exception {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.searchItemChooseFromAutocompleteList("Estes Jacket", 4);   //חגורת כסף כפולה למותן Must Have  //סנדלי שורש//4 Estes Jacket
        store.sendEmailIfBackInStockJenkinsScheduler("sivankimchi@gmail.com");
        log.info("Finished validating email notification for CUSTOMER - Jenkins scheduler");

    }

}