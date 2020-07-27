package myTests;

import Lametayel.GeneralProperties; //gitignore
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        driver.get(GeneralProperties.SiteURLShop);  //goes straight to shop url

    }

    @After
    public void closeTest(){
        driver.quit();
    }


    @Test
    public void addItemToCart() {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.addItemToCart(0);

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

    }


    @Test
    public void searchForItemPickAutoSuggestion() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        store.searchItemChooseFromAutocompleteList("נעלי", 3);

    }



    @Test
    public void pickAnItemFromTopBar(){

        OnlineStorePage store = new OnlineStorePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(store.shopTopBarList.get(5)));

        store.pickAnItemFromTopBarCategories(1, 3, 1);

    }



    @Test
    public void itemChangeColor() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("מכנסיים מתקצרים", 2); //  ("סנדלי גברים") הולך אחורה בצבע / "מכנסיים מתקצרים"-הולך קדימה

        store.changeItemColor();

    }

    @Test
    public void itemChangeSize() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("נעלי נשים", 1);

        store.changeItemSize();
    }

    @Test
    public void changeQuantityOfItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("בקבוק", 1);

        store.changeQuantityOfItem();
    }


    @Test
    public void saveProduct() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.tryToSaveProductUserNotLoggedIn();
        //goes to user's STORE account and then navigates back to item page as logged in user
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        store.saveItemAsLoggedInUserInStore();

    }



    @Test
    public void availabilityInBranches() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.availabilityInBranches(2);

    }



    @Test
    public void itemMoreOfSameBrand() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.moreProductsFromBrand();

    }



    @Test
    public void itemReviewsCount() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("נעלי טיולים לגברים Northside Weston Mid", 1);   //נעלי טיולים לגברים Northside Weston Mid ,  אוהל קמפינג

        store.exactAverage0fStarsRating();
    }


    @Test
    public void addReviewToItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);

        store.searchItemChooseFromAutocompleteList("סנדלי שורש", 1);

        store.addReviewToItem();

    }


    @Test
    public void shoppingCartUpdateQuantity() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);
        store.lametayelShopLogo.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        store.addItemToCart(2);

        store.changeCartItemsQuantity();
    }


    @Test  //sum of quantity and payment, delivery  (cart page)
    public void shoppingCartSummary() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);
        //increase +1 quantity
        store.increaseQuantityList.get(0).click();
        Thread.sleep(5000);

        store.lametayelShopLogo.click();
        Thread.sleep(5000);
        store.addItemToCart(2);

        store.shoppingCartItemTotalPrice();
        store.shoppingCartPaymentSummary();

    }



    @Test  //payment
    public void paymentWithoutPaying() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);
        store.continueToPaymentButton.click();
        store.paymentWithoutPayment("Buyme");  //paying methods: Buyme, Credit Card , PayPal

    }



}