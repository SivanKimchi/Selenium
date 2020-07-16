package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OnlineStorePage {


    //members
    private WebDriver driver;


    @FindBy (xpath = "//button[contains(text(), 'דלג לאתר')]")
    public WebElement skipToPageButton;

    @FindBy (id="_hjRemoteVarsFrame")
    public WebElement popUpSummerSaleId;

    @FindBy (xpath= "//*[@id=\"index\"]/div[10]/div/div[1]")
    public WebElement closeiframe;

    @FindBy (css = "section[class='products_section']")   //0 is first section
    public List<WebElement> productSectionItem;


    @FindBy (css = "section[class='products_section'] div[class*='product_list_item'] h3") //0 is first item's title
    public List<WebElement> productitemsh3;

    @FindBy (css = "div[class='product_name_wrap flex_container flex_start hidden-md-down'] div h1")
    public WebElement itemTitle;

    @FindBy (css = "button[data-button-action='add-to-cart']")
    public WebElement addItemToCart;

    @FindBy (css = "div[class='modal-content'] div[class='modal-body modal_cart general_border']")
    public WebElement itemAddedToCartMessageBox;

    @FindBy (css = "div[class='modal-content'] div[class='modal-body modal_cart general_border'] div[class='alert alert-success']")
    public WebElement itemAddedToCartMessageHeadline;

    @FindBy (css = "div[class='col-md-6'] a")
    public WebElement goToCart;


    @FindBy (css = "div[class='card-header']")
    public WebElement cartHeader;

    @FindBy (css = "ul[class='cart-items base_list_line mb-3 m-t-1']")
    public WebElement cartItemsList;

    @FindBy (css = "ul[class='cart-items base_list_line mb-3 m-t-1'] li")
    public List<WebElement> cartItem;

    @FindBy (css = "input[class='form-control search_widget_text js-child-focus']")
    public WebElement searchBar;

    @FindBy (css = "div[id='search_products']" )
    public WebElement searchResultsDiv;

    @FindBy (css = "div[class='products product_list  row grid'] div article")
    public List<WebElement> searchResultsList;

    @FindBy (css = "div[class='product_count']")
    public WebElement itemsCountString;

    @FindBy (css = "ul[class='pagination'] li" )
    public List<WebElement> nextPage;

    @FindBy (css = "div[class='products-sort-order dropdown_wrap mar_r1']")
    public WebElement sortingBeforeHoover;

    @FindBy (css = "ul[class='dropdown_list_ul dropdown_box'] li")
    public List<WebElement> sortingAfterHoover;


    @FindBy (css = "div[class*='product_list_item']")
    public List<WebElement> resultList;

    @FindBy (css = "div[class*='product_list_item'] span[class='price ']")
    public List<WebElement> resultPriceList;

//    //
//    @FindBy (css = "div[class*='product_list_item'] article div div[class='pro_second_box pro_block_align_0'] div:nth-child(3) div span[class='price ']")
//    public List<WebElement> resultPriceList;

    @FindBy (id="cbar_w0_header_s")
    public WebElement bottomSuggestionsHeader;


    @FindBy (id = "cbar_widget0")
    public WebElement bottomSuggestionsWidget;

    @FindBy (css = "div[id='cbar_w0_items_s'] div div div[class='owl-item']")
    public List<WebElement> bottomSuggestionsList;

    @FindBy (css = "div[class='autocomplete-suggestions']")
    public WebElement suggestedAutocompleteItemSearch;

    @FindBy (css = "div[class='autocomplete-suggestions'] div[class*='autocomplete-suggestion']")
    public List<WebElement> searchSuggestionsList;





    public void scroll(WebElement waitForVisibilityOf) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void moveToNextTab(){

        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

    }

    public void skipAd(){
        try {
            skipToPageButton.click();
        } catch (Exception e) {
            System.out.println("no ad page was skipped");
        }
    }


    public void addItemToCart(int itemIndex) {


        scroll(productSectionItem.get(0));   //first section of products

        String itemName = productitemsh3.get(itemIndex).getText();   //first product
        productitemsh3.get(itemIndex).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(itemTitle));

        Assert.assertEquals(itemName, itemTitle.getText());
        System.out.println("Clicked on first item amd opened it in a new window");

        addItemToCart.click();

        wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
        Assert.assertTrue(itemAddedToCartMessageHeadline.getText().contains("המוצר נוסף לסל הקניות!"));

        goToCart.click();

        checkItemAddedToCart(itemName);

    }


    public void checkItemAddedToCart(String itemTitle){

        boolean itemAdded = false;

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cartHeader));
        Assert.assertTrue(cartItemsList.isDisplayed());

        for (int i = 0; i < cartItem.size(); i++) {
            if (cartItem.get(i).getText().contains(itemTitle)) {
                System.out.println("Item was successfully added to cart.");
                itemAdded = true;
            }

            Assert.assertTrue(itemAdded);

        }

    }


    public void searchItem(String searchFor) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.clear();

        //general ENTER
        searchBar.sendKeys(searchFor, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(searchResultsDiv));
        String itemsCount = itemsCountString.getText();
        String[] itemsCountSplitArray = itemsCount.split(" ");
        int numOfItems = Integer.parseInt(itemsCountSplitArray[0]);

        //there are more pages to show items
        if (numOfItems > 95) {
            Assert.assertTrue(nextPage.size() > 1);
            System.out.println("More results in the next page. Each page holds up to 95 results");
        }

        //sort results
        sortResults();

        // suggested product at the bottom
        scroll(bottomSuggestionsWidget);
        Thread.sleep(5000);
        System.out.println(bottomSuggestionsList.size());
        Assert.assertTrue(bottomSuggestionsList.size() == 6);

    }


    public void searchItemChooseFromList(String searchFor) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.clear();

        searchBar.sendKeys(searchFor);
        Thread.sleep(3000);
        Assert.assertTrue(suggestedAutocompleteItemSearch.isDisplayed());

        Actions actions = new Actions(driver);
        actions.moveToElement(searchSuggestionsList.get(2)).build().perform();
        Assert.assertTrue(searchSuggestionsList.get(2).getAttribute("class").contains("autocomplete-selected"));
        String itemName = searchSuggestionsList.get(2).getText();
        searchSuggestionsList.get(2).click();
        wait.until(ExpectedConditions.visibilityOf(itemTitle));
        Assert.assertTrue(itemName.contains(itemTitle.getText()));
        System.out.println("Item was chosen from autocomplete search suggestion");
    }


    public void sortResults() throws InterruptedException {

        Assert.assertTrue(sortingBeforeHoover.isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(sortingBeforeHoover).build().perform();
        // System.out.println(sortingBeforeHoover.getAttribute("class"));
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(sortingBeforeHoover, "class", "open")));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(sortingAfterHoover.get(1).isDisplayed());
        System.out.println("Sorting filter is hoovered on and open");
        sortingAfterHoover.get(3).click();
        Thread.sleep(8000);  //sometimes it still goes to another item. why??
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(resultPriceList));//sometimes it still goes to another item. why??

        try {
            if ((resultPriceList.size() > 1)) {

                double price = 0.0;
                // trying only 2 rows for visibility issues
                for (int i = 0; i <= 5; i++) {
                    double itemPrice = Double.parseDouble(resultPriceList.get(i).getAttribute("content"));
                    Assert.assertTrue(itemPrice >= price);
                    System.out.println("price- " + price + " itemprice- "+ itemPrice);
                    double a = itemPrice;
                    price = a;
                }
            } else if (resultPriceList.size() == 1) {
                System.out.println("There is only 1 item in results");
            }

            System.out.println("Results are ordered as asked - lowest price to highest");

        } catch (Exception e) {
            System.out.println("There are no results");
        }
    }

    //constructor
    public OnlineStorePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
