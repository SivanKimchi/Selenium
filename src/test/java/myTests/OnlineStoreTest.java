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

        store.searchItemChooseFromList("נעלי", 3);

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



    @Test
    public void itemChangeColor() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        wait.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("מכנסיים מתקצרים", 2); //  ("סנדלי גברים") הולך אחורה בצבע / "מכנסיים מתקצרים"-הולך קדימה

        store.changeItemColor();

    }

    @Test
    public void itemChangeSize() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        wait.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("נעלי נשים", 1);

        store.changeItemSize();
    }

    @Test
    public void changeQuantityOfItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homepage.centralBar));
        homepage.mainMenuLametayelOnlineShop.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        wait.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("נעלי נשים", 1);

        store.changeQuantityOfItem();
    }


    @Test
    public void saveProduct() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait w = new WebDriverWait(driver, 20);

        w.until(ExpectedConditions.visibilityOf(homepage.mainMenuLametayelOnlineShop));
        homepage.mainMenuLametayelOnlineShop.click();
        w.until(ExpectedConditions.numberOfWindowsToBe(2));
        store.moveToNextTab();

        w.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("סנדלי שורש", 1);

        store.saveProduct();

    }


    @Test
    public void availabilityInBranches() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait w = new WebDriverWait(driver, 10);

        w.until(ExpectedConditions.visibilityOf(homepage.mainMenuLametayelOnlineShop));
        homepage.mainMenuLametayelOnlineShop.click();
        w.until(ExpectedConditions.numberOfWindowsToBe(2));

        store.moveToNextTab();

        w.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("סנדלי שורש", 1);

        store.availabilityInBranches(2);

    }



    @Test
    public void itemMoreOfSameBrand() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait w = new WebDriverWait(driver, 10);

        w.until(ExpectedConditions.visibilityOf(homepage.mainMenuLametayelOnlineShop));
        homepage.mainMenuLametayelOnlineShop.click();
        w.until(ExpectedConditions.numberOfWindowsToBe(2));

        store.moveToNextTab();

        w.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("סנדלי שורש", 1);
        store.moreProductsFromBrand();

    }



    @Test
    public void itemReviewsCounts() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait w = new WebDriverWait(driver, 10);

        w.until(ExpectedConditions.visibilityOf(homepage.mainMenuLametayelOnlineShop));
        homepage.mainMenuLametayelOnlineShop.click();
        w.until(ExpectedConditions.numberOfWindowsToBe(2));

        store.moveToNextTab();

        w.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("אוהל קמפינג", 1);   //נעלי טיולים לגברים Northside Weston Mid
        store.itemReviewsCount();
    }


    @Test
    public void addReviewToItem() throws InterruptedException {

        OnlineStorePage store = new OnlineStorePage(driver);
        HomePage homepage = new HomePage(driver);
        WebDriverWait w = new WebDriverWait(driver, 10);

        w.until(ExpectedConditions.visibilityOf(homepage.mainMenuLametayelOnlineShop));
        homepage.mainMenuLametayelOnlineShop.click();
        w.until(ExpectedConditions.numberOfWindowsToBe(2));

        store.moveToNextTab();

        w.until(ExpectedConditions.visibilityOf(store.searchBar));
        store.searchItemChooseFromList("סנדלי שורש", 1);
        store.addReviewToItem();

    }


    @Test
    public void shoppingCartUpdateQuantity() throws InterruptedException {

        addItemToCart();
        OnlineStorePage store = new OnlineStorePage(driver);

        store.lametayelShopLogo.click();
        //WebDriverWait w = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        store.addItemToCart(2);

        store.changeCartItemsQuantity();


    }


    @Test  //summary of amount and payment, delivery
    public void shoppingCartSummary() {




    }



    @Test  //items and amounts, summary of amount and payment
    public void paymentWithoutPaying(){




    }



}