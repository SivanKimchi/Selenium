package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import Lametayel.GeneralProperties;  //uses JsonValues.json -- gitignore (template available)
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OnlineStorePage {


    //members
    private WebDriver driver;


    @FindBy (xpath = "//button[contains(text(), 'דלג לאתר')]")
    public WebElement skipToPageButton;

    @FindBy(id = "_hjRemoteVarsFrame")
    public WebElement popUpSummerSaleId;

    @FindBy(xpath = "//*[@id=\"index\"]/div[10]/div/div[1]")
    public WebElement closeiframe;

    @FindBy(css = "section[class='products_section']")   //0 is first section
    public List<WebElement> productSectionItem;


    @FindBy(css = "section[class='products_section'] div[class*='product_list_item'] h3") //0 is first item's title
    public List<WebElement> productitemsh3;

    @FindBy(css = "div[class='product_name_wrap flex_container flex_start hidden-md-down'] div h1")
    public WebElement itemTitle;

    @FindBy(css = "button[data-button-action='add-to-cart']")
    public WebElement addItemToCart;

    @FindBy(css = "div[class='modal-content'] div[class='modal-body modal_cart general_border']")
    public WebElement itemAddedToCartMessageBox;

    @FindBy(css = "div[class='modal-content'] div[class='modal-body modal_cart general_border'] div[class='alert alert-success']")
    public WebElement itemAddedToCartMessageHeadline;

    @FindBy (css = "ul[class='list_detail_item m-b-1'] li")
    public List<WebElement> colorSizeAmountLine;

    @FindBy(css = "div[class='col-md-6'] a")
    public WebElement goToCart;


    @FindBy(css = "div[class='card-header']")
    public WebElement cartHeader;

    @FindBy(css = "ul[class='cart-items base_list_line mb-3 m-t-1']")
    public WebElement cartItems;

    @FindBy(css = "ul[class='cart-items base_list_line mb-3 m-t-1'] li a[class='label']")
    public List<WebElement> cartItemTitleList;

    @FindBy(css = "input[class='form-control search_widget_text js-child-focus']")
    public WebElement searchBar;

    @FindBy(css = "div[id='search_products']")
    public WebElement searchResultsDiv;

    @FindBy(css = "div[class='products product_list  row grid'] div article")
    public List<WebElement> searchResultsList;

    @FindBy(css = "div[class='product_count']")
    public WebElement itemsCountString;

    @FindBy(css = "ul[class='pagination'] li")
    public List<WebElement> nextPage;

    @FindBy(css = "div[class='products-sort-order dropdown_wrap mar_r1']")
    public WebElement sortingBeforeHoover;

    @FindBy(css = "ul[class='dropdown_list_ul dropdown_box'] li")
    public List<WebElement> sortingAfterHoover;


    @FindBy(css = "div[class^='product_list_item']")
    public List<WebElement> resultList;

    @FindBy(css = "div[class^='product_list_item'] span[class='price ']")
    public List<WebElement> resultPriceList;

    @FindBy(id = "cbar_w0_header_s")
    public WebElement bottomSuggestionsHeader;


    @FindBy(id = "cbar_widget0")
    public WebElement bottomSuggestionsWidget;

    @FindBy(css = "div[id='cbar_w0_items_s'] div div div[class='owl-item']")
    public List<WebElement> bottomSuggestionsList;

    @FindBy(css = "div[class='autocomplete-suggestions']")
    public WebElement suggestedAutocompleteItemSearch;

    @FindBy(css = "div[class='autocomplete-suggestions'] div[class*='autocomplete-suggestion']")
    public List<WebElement> searchSuggestionsList;

    @FindBy(css = "div[id='st_mega_menu_header_container'] nav[id='st_mega_menu_wrap'] ul li[id*='st_menu']")
    public List<WebElement> shopTopBarList;   //נשים גברים ציוד טיולים


    @FindBy(css = "div[class*='stmenu_sub style_wide col-md'][style*='display: block; overflow: visible'] div[class='row m_column_row'] div[id*='st_menu_column'] div[id*='st_menu_block'] div[class='row']")
    public List<WebElement> shopTopBarChoiceRowList;

    @FindBy(css = "div[class*='stmenu_sub style_wide col-md'][style*='display: block; overflow: visible'] div[class='row m_column_row'] div[id*='st_menu_column'] div[id*='st_menu_block'] div[class='row'] div[class*='col-md']")
    public List<WebElement> shopTopBarChoiceRowColumnList;

    @FindBy(css = "div[class*='stmenu_sub style_wide col-md'][style*='display: block; overflow: visible'] div[id*='st_menu_column'] div[id*='st_menu_block'] div[class='row'] li[class*='ml_level'] a[class='ma_level_1 ma_item']")
    public List<WebElement> shopTopBarChoiceRowColumnHeadlineList;

    @FindBy(css = "div[class*='stmenu_sub style_wide col-md'][style*='display: block; overflow: visible'] div[id*='st_menu_column'] div[id*='st_menu_block'] div[class='row'] ul[class*='p_granditem'] a")
    public List<WebElement> shopTopBarChoiceRowColumnCategoryList;

    @FindBy (css = "section[id='main'] h1")
    public WebElement categoryTitle;

    @FindBy (css = "div[class='product-variants'] div[class='clearfix product-variants-item']")
    public List<WebElement> colorSizeRows;

    @FindBy (css = "ul[id*='group_'] li input")
    public List<WebElement> itemColorList;

    @FindBy (css = "ul[id*='group_'] li span[class='radio-label']")
    public List<WebElement> itemColorTextList;

    @FindBy (css = "ul[id*='group_']")
    public WebElement sizeRow;

    @FindBy (css = "ul[id*='group_'] li input[class='input-radio']")
    public List<WebElement> itemSizeList;

    @FindBy (css = "ul[id*='group_'] li span[class='radio-label']")
    public List<WebElement> itemSizeTextList;

    @FindBy (css = "input[id='quantity_wanted']")
    public WebElement quantity;

    @FindBy (css = "button[class*='bootstrap-touchspin-down']")
    public WebElement decreaseQuantity;

    @FindBy (css = "button[class*='bootstrap-touchspin-down']")
    public List<WebElement> decreaseQuantityList;

    @FindBy (css = "button[class*='bootstrap-touchspin-up']")
    public WebElement increaseQuantity;

    @FindBy (css = "button[class*='bootstrap-touchspin-up']")
    public List<WebElement> increaseQuantityList;

    @FindBy (css = "ul[class='cart-items base_list_line mb-3 m-t-1'] li input[name='product-quantity-spin']")
    public List<WebElement> quantityInCartList;

    @FindBy (css = "ul[class='cart-items base_list_line mb-3 m-t-1'] li span[class='price']")
    public List<WebElement> priceInCartList;

    @FindBy (css = "ul[class='cart-items base_list_line mb-3 m-t-1'] li span[class='product-price price']")
    public List<WebElement> sumPriceTotalInCartList;

    @FindBy (css = "div[id='product-availability']")
    public WebElement productAvailability;

    @FindBy (css = "div[class='flex_box'] i[class='fto-heart-4 icon_btn']")
    public WebElement saveProduct;

    @FindBy (css = "div[class='flex_box'] a[class*='add_to_love']")
    public WebElement saveProductSaved;

    @FindBy (css = "div[id='loved_go_login']")
    public WebElement loginToStoreBox;

    @FindBy (css = "div[id='loved_go_login'] a[class='go']")
    public WebElement loginToStoreButton;

    @FindBy (css = "div[id='header_right_top'] a[class='dropdown_tri dropdown_tri_in header_item']")
    public WebElement loginToStoreFromTopMenu;

    @FindBy (css = "form[id='login-form'] input[name='email']")
    public WebElement loginFromStore_email;

    @FindBy (css = "form[id='login-form'] input[name='password']")
    public WebElement loginFromStore_password;

    @FindBy (css = "form[id='login-form'] button[id='SubmitLogin']")
    public WebElement loginButton;

    @FindBy (css = "div[class='row myacount_dashbord_list'] div[class='list-group-item'] a[class='love-link']")
    public WebElement usersSavedItems;

    @FindBy (css = "section[id='content'] div:nth-of-type(2)")
    public WebElement savedItemsPageContent;

    @FindBy (xpath = "//*[text()='עדיין לא שמרת מוצרים לרשימת המוצרים השמורים']")
    public WebElement notificationNoSavedItems;

    @FindBy (css = "div[class='userinfo_mod_top dropdown_wrap top_bar_item']")
    public WebElement userMenuInStore;

    @FindBy (css = "ul[class='dropdown_list_ul dropdown_box custom_links_list'] li a")
    public List<WebElement> userMenuInStoreOptions;

    @FindBy (css = "ul[class='com_grid_view row']")
    public WebElement userSavedItemsRow;

    @FindBy (css = "a[title='מחק']")
    public WebElement deleteSavedItem;

    @FindBy (xpath = "//a[@id='medproductwarehouses-show-list']")
    public WebElement itemAvailabilityInBranchesDropDown;

    @FindBy (xpath = "//div[@id='medproductwarehouses']/div/span/ul/li/a")
    public List<WebElement> itemAvailabilityInBranchesList;

    @FindBy (css = "div[class='hidden-md-down'] a[class='pro_extra_info_brand']")
    public WebElement itemBrand;

    @FindBy (css = "section[id='main'] h1[class*='page_heading mb']")
    public WebElement brandPageTitle;

    @FindBy(css = "div[class*='product_list_item'] div[class*='pro_list_manufacturer']")
    public List<WebElement> resultBrandList;

    @FindBy (css = "div[class='gotorev hidden-md-down'] span span span:nth-child(1) i")
    public List<WebElement> reviewStarsOnTopList;

    @FindBy (css = "div[class='gotorev hidden-md-down'] span[class='stamped-badge']")
    public WebElement reviewLineTop;

    @FindBy (css = "div[class='gotorev hidden-md-down'] span[class='stamped-badge'] span:nth-child(2)")
    public WebElement numberOfReviewsSubmittedTop;

    @FindBy (css = "div[class='summary-overview'] span:nth-child(3) span")
    public WebElement numberOfReviewsSubmittedBottom;

    @FindBy (css = "div[class='summary-overview'] span:nth-child(1) span[class*='stamped-summary-text']")
    public WebElement exactReviewStarsBottom;

    @FindBy (css = "div[class='stamped-summary-ratings'] div[class='summary-rating']")
    public List<WebElement> ratingList;

    @FindBy (css = "div[class='stamped-summary-ratings'] div[class='summary-rating'] div:nth-child(2)")
    public List<WebElement> ratingStarAmountList;

    @FindBy (css = "span[class='stamped-summary-actions'] span[class='stamped-summary-actions-newreview']")
    public WebElement addReview;

    @FindBy (css = "div[class='stamped-content'] form[id*='new-review-form_']")
    public WebElement newReviewForm;


    @FindBy (css = "form[id*='new-review-form_'] fieldset[class='stamped-form-review']")
    public WebElement newReviewMainBox;

    @FindBy (css = "a[class='shop_logo'] img[class='logo']")
    public WebElement lametayelShopLogo;

    @FindBy (css = "section[id='main'] div[class*='cart-grid-right'] span[class='label js-subtotal']")
    public WebElement shoppingCartPaymentTotalItems;

    @FindBy (css = "section[id='main'] div[class*='cart-grid-right'] div[class='value price']")
    public WebElement shoppingCartPaymentTotalPriceForItems;

    @FindBy (css = "section[id='main'] div[class*='cart-grid-right'] div[id='cart-subtotal-shipping'] div[class='value price']")
    public WebElement deliveryFee;

    @FindBy (css = "section[id='main'] div[class*='cart-grid-right'] div[class='cart-summary-line clearfix cart-total'] span:nth-child(2)")
    public WebElement totalPriceWithDelivery;

    @FindBy (css = "section[id='main'] div[class*='cart-grid-right'] a[class*='btn_to_checkout']")
    public WebElement continueToPaymentButton;


    @FindBy (css = "div[id='delivery-address']")
    public WebElement addressForm;

    @FindBy (css = "form[id='login-form'] button[name='continue']")
    public WebElement continueWithPaymentProcess;

    @FindBy (css = "div[id='delivery-address'] input[name='firstname']")
    public WebElement addressFormFirstName;

    @FindBy (css = "div[id='delivery-address'] input[name='lastname']")
    public WebElement addressFormLastName;

    @FindBy (css = "div[id='delivery-address'] input[name='phone_mobile']")
    public WebElement addressFormMobilePhone;

    @FindBy (css = "div[id='delivery-address'] input[name='city']")
    public WebElement addressFormCity;

    @FindBy (css = "div[id='delivery-address'] input[name='address1']")
    public WebElement addressFormAddress;

    @FindBy (css = "div[id='delivery-address'] input[name='use_same_address']")
    public WebElement addressFormSameAddressCheckbox;

    @FindBy (css = "div[class='card-block'] div[class='address']")
    public WebElement addressBox;

    @FindBy (css = "p[id*='id-failure-address-']")
    public WebElement addressFailureAlert;

    @FindBy (css = "a[class*='edit-address']")
    public WebElement editAddress;

    @FindBy (css = "button[name='confirm-addresses']")
    public WebElement continueAfterAddress;

    @FindBy (css = "div[class*='delivery-option']")
    public WebElement deliveryOptionDiv;


    @FindBy (css = "button[name='confirmDeliveryOption']")
    public WebElement continueAfterDelivery;


    @FindBy (xpath = "//*[text()='תשלום באמצעות Buyme']")
    public WebElement payWithBuyme;


    @FindBy (xpath = "//*[text()='תשלום בכרטיס אשראי מאובטח']")
    public WebElement payWithCreditCard;

    @FindBy (xpath = "//*[text()='שלם עם PayPal ']")
    public WebElement payWithPayPal;

    @FindBy (css = "input[id*='payment-option-']")
    public List<WebElement> paymentOptionRadio;

    @FindBy (css = "input[id='buy-me-card-number']")
    public WebElement buymeCardNumberInput;

    @FindBy (css = "input[id='conditions_to_approve[terms-and-conditions]']")
    public WebElement agreeToTermsCheckbox;

    @FindBy (css = "div[id='payment-confirmation'] button")
    public WebElement orderConfirmation;

    @FindBy (css = "a[class='st_shopping_cart dropdown_tri header_item ']")
    public WebElement shoppingCartButton;


    public static Logger log = LogManager.getLogger(OnlineStorePage.class.getName());

    //constructor
    public OnlineStorePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void scroll(WebElement waitForVisibilityOf) {
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         log.debug("Scrolled to element");
    }

    //works for 2 or MORE windows
    public void moveToNextTab() {

        String parentId = driver.getWindowHandle();
        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String childWindow= "";

        while (it.hasNext()){
                childWindow = it.next();
            }
        driver.switchTo().window(childWindow);
        log.info("Switched to next window handle");
    }


    public void skipAd() {
        try {
            skipToPageButton.click();
            log.debug("Skipped ad page");
        } catch (Exception e) {
            log.error("No ad page was skipped");
        }
    }


    public void addItemToCart(int itemIndex) {

        WebElement mainSectionProducts = productSectionItem.get(0);  // ** first section of products
        scroll(mainSectionProducts);

        String itemName = productitemsh3.get(itemIndex).getText();
        log.debug("Item chosen: " + itemName);
        productitemsh3.get(itemIndex).click();
        log.debug("Clicked on item");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(itemTitle));

        Assert.assertEquals(itemName, itemTitle.getText());
        log.debug("Item opened in a new window");

        String mainWindow = driver.getWindowHandle();

        addItemToCart.click();
        log.debug("Clicked on 'add to cart'");
//
//        Wait fluentwait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(9))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoAlertPresentException.class);

        try {
            driver.switchTo().alert();
            log.error(driver.switchTo().alert().getText());
        } catch (NoAlertPresentException e) {
            log.debug("No immediate alert after adding to cart");

            try {
                wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
                Assert.assertTrue(itemAddedToCartMessageHeadline.getText().contains("המוצר נוסף לסל הקניות!"));
                log.debug("Message - item was added to cart");

                goToCart.click();
                log.debug("Clicked on 'go to cart'");

                checkItemAddedToCart(itemName);

            } catch (UnhandledAlertException exception) {
//            fluentwait.until(ExpectedConditions.alertIsPresent());
                log.error("Item is out of stock");
                driver.switchTo().alert();
                log.error(driver.switchTo().alert().getText());

//            driver.switchTo().window(mainWindow);
//            shoppingCartButton.click();

            }
        }


    }


    public void checkItemAddedToCart(String itemTitle) {

        boolean itemAdded = false;

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cartHeader));
        Assert.assertTrue(cartItems.isDisplayed());
        log.debug("Cart is shown");

        for (int i = 0; i < cartItemTitleList.size(); i++) {

            if (cartItemTitleList.get(i).getText().contains(itemTitle)) {
                log.info("Item was successfully added to cart.");
                itemAdded = true;
            }

        }       Assert.assertTrue(itemAdded);

    }


    public void searchItem(String searchFor) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.clear();

        //general ENTER
        searchBar.sendKeys(searchFor, Keys.ENTER);
        log.debug("Inserted search term, clicked ENTER");
        wait.until(ExpectedConditions.visibilityOf(searchResultsDiv));
        log.debug("Results are shown");

        String itemsCount = itemsCountString.getText();
        String[] itemsCountSplitArray = itemsCount.split(" ");
        int numOfItems = Integer.parseInt(itemsCountSplitArray[0]);

        //there are more pages to show items
        if (numOfItems > 95) {       // 95 = max results per page
            Assert.assertTrue(nextPage.size() > 1);
            log.debug("More results in the next page. Each page holds up to 95 results");
        }

    }


    public void suggestedItems() throws InterruptedException {
        scroll(bottomSuggestionsWidget);
        Thread.sleep(5000);
        Assert.assertTrue(bottomSuggestionsList.size() == 6);
        log.debug("There are default " + bottomSuggestionsList.size() + " suggested items at the bottom of item search results");
    }


    public void searchItemChooseFromAutocompleteList(String searchFor, int itemIndex) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.clear();

        searchBar.sendKeys(searchFor);
        log.debug("Inserted partial search term");
        Thread.sleep(3000);
        Assert.assertTrue(suggestedAutocompleteItemSearch.isDisplayed());
        log.debug("Auto complete items are displayed");

        Actions actions = new Actions(driver);
        actions.moveToElement(searchSuggestionsList.get(itemIndex)).build().perform();
        Assert.assertTrue(searchSuggestionsList.get(itemIndex).getAttribute("class").contains("autocomplete-selected"));
        log.debug("Hoovered to auto complete suggestion");
        String itemName = searchSuggestionsList.get(itemIndex).getText();
        searchSuggestionsList.get(itemIndex).click();
        log.debug("Clicked on auto complete suggestion");
        wait.until(ExpectedConditions.visibilityOf(itemTitle));
        Assert.assertTrue(itemName.contains(itemTitle.getText()));
        log.info("Item was chosen from autocomplete search suggestion: " + itemName);
    }


    public void sortResults() throws InterruptedException {

        Assert.assertTrue(sortingBeforeHoover.isDisplayed());
        log.debug("Sorting option is shown");
        Actions actions = new Actions(driver);
        actions.moveToElement(sortingBeforeHoover).build().perform();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(sortingAfterHoover.get(1).isDisplayed());
        log.debug("Sorting filter is hoovered on and is open");
        sortingAfterHoover.get(3).click();
        log.debug("Chosen sorting by price ascending");
        Thread.sleep(8000);  //sometimes it still goes to another item. why??
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(resultPriceList));//sometimes it still goes to another item. why??

        try {
            if ((resultPriceList.size() > 1)) {

                double price = 0.0;
                log.debug("Going through top 2 rows of items prices");

                // trying only 2 rows for visibility issues
                for (int i = 0; i <= 5; i++) {
                    String[] priceTextArray = resultPriceList.get(i).getText().split("₪");
                    double itemPrice = Double.parseDouble(priceTextArray[1]);
                    Assert.assertTrue(itemPrice >= price);
                    log.debug("price- " + price + " itemprice- " + itemPrice);
                    double a = itemPrice;
                    price = a;
                }
            } else if (resultPriceList.size() == 1) {
                log.info("There is only 1 item in results");
            }

            log.info("Results are ordered as asked - lowest price to highest");

        } catch (Exception e) {
            log.error("There are no results");
        }
    }


    public void pickAnItemFromTopBarCategories(int mainCategoryIndex, int categoryHeadlineIndex, int categoryIndex) {

        Actions actions = new Actions(driver);

        try {
            actions.moveToElement(shopTopBarList.get(mainCategoryIndex)).build().perform();   //1=גברים
            log.debug("Hoovered on item's first category");
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

            try {
                actions.moveToElement(shopTopBarChoiceRowColumnHeadlineList.get(categoryHeadlineIndex)).build().perform(); //2=סנדלים לגברים
                log.debug("Hoovered on category headline- " + shopTopBarChoiceRowColumnHeadlineList.get(categoryHeadlineIndex).getText());

                // ** MINI SCOPE for categories column (mini driver)
                WebElement column = shopTopBarChoiceRowColumnList.get(categoryHeadlineIndex);
                List<WebElement> itemCategory = column.findElements(By.cssSelector("ul[class*='p_granditem'] a"));
                log.debug("Entered mini scope for sub category");

                try {
                    String category = itemCategory.get(categoryIndex).getText();
                    actions.moveToElement(itemCategory.get(categoryIndex)).click().build().perform();
                    log.debug("Clicked on next item's category");

                    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
                    Assert.assertEquals(categoryTitle.getText(), category);
                    log.info("Items category was chosen from top bar (" + categoryTitle.getText() + ")");

                } catch (Exception e) {
                    log.error("Index is out of bound for this item category scope. Please run the test again with small index.");
                }

            } catch (Exception e) {
                log.error("Index is out of bound for this category scope. Please run the test again with small index.");
            }

        } catch (Exception e) {
            log.error("Main category index is too big and out of scope. Please run the test again with a smaller index.");
        }
    }



    public void changeItemColor() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String newColor ="";

        try {

            wait.until(ExpectedConditions.visibilityOf(colorSizeRows.get(0)));
            // ** MINI DRIVER **
            WebElement colors = colorSizeRows.get(0);
            List<WebElement> itemColorList = colors.findElements(By.cssSelector("ul[id*='group_'] li input[class='input-radio']"));
            List<WebElement> itemColorTextList = colors.findElements(By.cssSelector("ul[id*='group_'] li span[class='radio-label']"));
            log.debug("Entered mini scope for item colors");

            log.debug("Number of colors: " + itemColorList.size());

            if (itemColorList.size() > 1) {

                log.debug("Going through color list");
                for (int i = 0; i < itemColorList.size(); i++) {

                    if (itemColorList.get(i).isSelected()) {

                        try {
                            log.debug("Color selected now- " + itemColorTextList.get(i).getText());
                            itemColorList.get(i + 1).click();
                            Assert.assertTrue(itemColorList.get(i + 1).isSelected());
                            log.debug("Now the next color is selected- " + itemColorTextList.get(i + 1).getText());
                            newColor = itemColorTextList.get(i + 1).getText();
                            break;
                        } catch (Exception e) {       //if there are no more colors forward only backwards
                            log.debug("No more colors on the left side, going right");
                            log.debug("Color selected now- " + itemColorTextList.get(i).getText());
                            itemColorList.get(i - 1).click();
                            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
                            Assert.assertTrue(itemColorList.get(i - 1).isSelected());
                            log.debug("Now the previous color is selected- " + itemColorTextList.get(i - 1).getText());
                            newColor = itemColorTextList.get(i - 1).getText();
                            break;
                        }


                    } else {
                        log.error("Color not selected: " + itemColorTextList.get(i).getText());
                    }
                }
                Thread.sleep(5000);
                addItemToCart.click();
                log.debug("Clicked on 'add to cart'");
                wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
                Assert.assertTrue(colorSizeAmountLine.get(0).getText().contains(newColor));
                log.info("Item color in cart message is correct");

            } else {
                Assert.assertTrue(itemColorList.get(0).isSelected());
                log.info("There is only one color available");
            }
        } catch (Exception e) {
            log.error("Item probably not in stock, and there is no color to choose.");
        }
    }


    public void changeItemSize(){

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(colorSizeRows.get(1)));
            // ** MINI DRIVER **
            WebElement sizes = colorSizeRows.get(1);
            List<WebElement> itemSizeList = sizes.findElements(By.cssSelector("ul[id*='group_'] li input[class='input-radio']"));
            List<WebElement> itemSizeTextList = sizes.findElements(By.cssSelector("ul[id*='group_'] li span[class='radio-label']"));
            log.debug("Entered mini scope for item's sizes");

                log.debug("Number of size options: " + itemSizeList.size());

                if (itemSizeList.size() > 1) {

                    String newSize="";
                    log.debug("Going through items size list");
                    for (int i = 0; i < itemSizeList.size(); i++) {

                        if (itemSizeList.get(i).isSelected()) {

                            try {
                                log.debug("Size selected now- " + itemSizeTextList.get(i).getText());
                                itemSizeList.get(i+1).click();
                                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
                                Assert.assertTrue(itemSizeList.get(i+1).isSelected());
                                log.debug("Now the next size is selected- " + itemSizeTextList.get(i+1).getText());
                                newSize = itemSizeTextList.get(i+1).getText();
                                break;

                            } catch (Exception e) {     //if there are no more sizes forward only backwards
                                log.debug("No more sizes on the left side, going right");
                                log.debug("Size selected now- " + itemSizeTextList.get(i).getText());
                                itemSizeList.get(i - 1).click();
                                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
                                Assert.assertTrue(itemSizeList.get(i - 1).isSelected());
                                log.debug("Now the previous size is selected- " + itemSizeTextList.get(i - 1).getText());
                                newSize = itemSizeTextList.get(i - 1).getText();
                                break;

                            }
                        } else {
                            log.error("Size not selected: " + itemSizeTextList.get(i).getText());
                        }
                    }
                        Thread.sleep(5000);
                        addItemToCart.click();
                        log.debug("Clicked on'add to cart'");
                        wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
                        Assert.assertTrue(colorSizeAmountLine.get(1).getText().contains(newSize));
                        log.info("Item size in cart message is correct");
                } else {
                    Assert.assertTrue(itemSizeList.get(0).isSelected());
                    log.info("There is only one size available");

                }
        } catch (Exception e) {
            log.error("There are no size options to this items");
        }
    }




    public void changeQuantityOfItem(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(quantity));

        //There is an error in the website -- the input tag isn't updated in any attribute, and quantity getText doesn't work either
        //Can not check if quantity is updated on this screen, only on next screen
        log.error("Error in website- the input tag isn't updated in any attribute, and quantity getText doesn't work either");

        try {
            increaseQuantity.click();
//            Assert.assertEquals(quantity.getAttribute("value"), "1");
            log.debug("Quantity has increased");
            decreaseQuantity.click();
//            Assert.assertEquals(quantity.getAttribute("value"), "1");
            log.debug("Quantity has decreased");

            //Check if there is size selection for this item, to know index number
            if (colorSizeRows.size()==2){   //there IS a size row
                log.info("There is size and color selection to this item");
                addItemToCart.click();
                Thread.sleep(3000);
                Assert.assertTrue(colorSizeAmountLine.get(2).getText().contains("1"));
                log.debug("Added to cart with chosen quantity- 1");

            } else if (colorSizeRows.size()==1){   //there isn't a size row
                log.info("There isn't size selection to this item");
                addItemToCart.click();
                Thread.sleep(3000);
                Assert.assertTrue(colorSizeAmountLine.get(1).getText().contains("1"));
                log.debug("Added to cart with chosen quantity- 1");
            }

        } catch (Exception e) {   //can not change quantity to this item

            Assert.assertTrue(productAvailability.getAttribute("class").contains("product-unavailable") || productAvailability.getAttribute("class").contains("product-last-items"));
            log.error("Product is not available or limited. Can't change quantity");
        }
    }



    public void tryToSaveProductUserNotLoggedIn() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveProduct));

        saveProduct.click();
        log.debug("Clicked on 'save item'");

        //log in to save item to favorites
        log.debug("User needs to log into store");
        wait.until(ExpectedConditions.visibilityOf(loginToStoreBox));
        loginToStoreButton.click();
        signInToStoreForm();

        log.debug("User is inside store account");
        //user's store-account
        wait.until(ExpectedConditions.visibilityOf(usersSavedItems));
        usersSavedItems.click();
        log.debug("Clicked on user's saved items");
        wait.until(ExpectedConditions.visibilityOf(savedItemsPageContent));
//      Assert.assertTrue(notificationNoSavedItems.isDisplayed());
            try {
                Assert.assertFalse(userSavedItemsRow.isDisplayed());
                log.error("There are saved items in user's store account");
            } catch (Exception e) {
                log.debug("Item was not added to 'Saved items' because user was not signed in to store");
            }
        }


         // goes to user's store account
//       public void signInToStoreFromTopMenu() throws InterruptedException {
//
//          WebDriverWait wait = new WebDriverWait(driver, 10);
//          wait.until(ExpectedConditions.visibilityOf(loginToStoreFromTopMenu));
//          loginToStoreFromTopMenu.click();
//          signInToStoreForm();
//      }


     public void signInToStoreForm() throws InterruptedException {

         WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.visibilityOf(loginFromStore_email));
         loginFromStore_email.sendKeys(GeneralProperties.LoginEmail);
         log.debug("Inserted email in store sign in form");
         Thread.sleep(3000);
         loginFromStore_password.sendKeys(GeneralProperties.LoginPassword);
         log.debug("Inserted password in store sign in form");
         Thread.sleep(3000);
         loginButton.click();
         log.debug("Submitted store sign in form");

     }


    public void saveItemAsLoggedInUserInStore() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(saveProduct));

        String productTitle = itemTitle.getText();

        saveProduct.click();
        log.debug("Clicked on 'save item'");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//      wait.until(ExpectedConditions.attributeContains(saveProduct, "class","st_added"));
        Assert.assertTrue(saveProductSaved.getAttribute("class").contains("st_added"));
        log.debug("It seems item was added to 'saved items'");
        Actions a = new Actions(driver);
        a.moveToElement(userMenuInStore).build().perform();
        log.debug("Hoovered on user's store menu");
        a.moveToElement(userMenuInStoreOptions.get(1)).click().build().perform();
        log.debug("Clicked on user's saved items category");
//      Assert.assertTrue(savedItemsPageContent.getText().contains("המוצרים ששמרתי"));
        Assert.assertTrue(userSavedItemsRow.getText().contains(productTitle));
        log.info("Logged in user- Item was successfully added to Saved Items");

        //delete
        deleteSavedItem.click();
        log.debug("Clicked on 'delete saved item'");
        Thread.sleep(3000);

        try {
            Assert.assertFalse(userSavedItemsRow.getText().contains(productTitle));
            log.info("Item was successfully deleted from Saved Items");

        } catch (Exception f) {  // element userSavedItemsRow does not exist in dom anymore
            log.info("Logged in user- Item was successfully deleted from Saved Items");
        }
    }


    public void availabilityInBranches(int branchIndex){

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(itemAvailabilityInBranchesDropDown));
        itemAvailabilityInBranchesDropDown.click();
        log.debug("Clicked on 'availability in branches' dropdown");
        String branch="";

        try {
            wait.until(ExpectedConditions.visibilityOf(itemAvailabilityInBranchesList.get(0)));
            log.debug("Item is available in " + itemAvailabilityInBranchesList.size() + " branches");

            try {
                String[] branchName = itemAvailabilityInBranchesList.get(branchIndex).getText().split("עודפים - ");
                branch = branchName[1];
                log.info("Branch name had עודפים in it");
            } catch (Exception e) {    // branch name does not have "עודפים" in it
                branch = itemAvailabilityInBranchesList.get(branchIndex).getText();
                log.info("Branch name does not have עודפים in it");
            }

            itemAvailabilityInBranchesList.get(branchIndex).click();
            log.debug("Clicked on a branch");

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            moveToNextTab();

            skipAd();

            wait.until(ExpectedConditions.visibilityOf(orderWidget.firstBranchMoreInfoPageHeadline));
            Assert.assertTrue(orderWidget.firstBranchMoreInfoPageHeadline.getText().contains(branch));
            log.info("Branch info page open");

        } catch (Exception e) {
            log.error("Item is unavailable in all branches");
        }

    }


    public void moreProductsFromBrand(){

        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(itemBrand));
        String itemsBrand = itemBrand.getText();
        itemBrand.click();
        log.debug("Clicked on brand name");
        w.until(ExpectedConditions.visibilityOf(brandPageTitle));
        Assert.assertEquals(brandPageTitle.getText(),  "רשימת מוצרים לפי מותג "+ itemsBrand);
        log.debug("Relevant brand page loaded");

        w.until(ExpectedConditions.visibilityOfAllElements(resultBrandList));//sometimes it still goes to another item. why??

            if ((resultBrandList.size() > 0)) {

                String brand = "";

                log.debug("Going through top 2 rows of items");
                // trying only 2 rows for visibility&load time issues
                for (int i = 0; i <= 5; i++) {
                    String itemBrandFromList = resultBrandList.get(i).getText();
                    Assert.assertEquals(itemBrandFromList, itemsBrand);
                    log.debug("itemBrandFromList- " +itemBrandFromList + " and itemsBrand- " + itemsBrand);
                }

            log.info("Items have the same brand- " + itemsBrand);

        } else  {
            log.error("There are no results");
        }

    }



    public double numberOfStarsTopRating(){

        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(reviewLineTop));

        //number of stars
        boolean starIsChecked;
        double amountOfStarsChecked=0.0;
        double halfStar = 0.0;

        log.debug("Going through top stars to see how 'full' they are");
        for (int i=0; i<reviewStarsOnTopList.size(); i++) {
            if (reviewStarsOnTopList.get(i).getAttribute("class").equals("stamped-fa stamped-fa-star")){
                starIsChecked = true;
                amountOfStarsChecked = amountOfStarsChecked+1.0;
                log.debug("Star is fully checked");
            } else if (reviewStarsOnTopList.get(i).getAttribute("class").equals("stamped-fa stamped-fa-star-o")) {
                starIsChecked = false;
                log.debug("Star is not checked");
            } else if (reviewStarsOnTopList.get(i).getAttribute("class").equals("stamped-fa stamped-fa-star-half-o")){
                halfStar = 0.5;
                log.debug("Star is half checked");
            }
        }

        amountOfStarsChecked = amountOfStarsChecked + halfStar;
        log.info("Review to this item (round) is: " + amountOfStarsChecked + " stars");

        return amountOfStarsChecked;
    }


    public void exactAverage0fStarsRating(){

        //rounded visible stars on top
        double amountOfStarsChecked = numberOfStarsTopRating();

        WebDriverWait w = new WebDriverWait(driver, 10);

        //number of reviews submitted
        if (amountOfStarsChecked > 0.0) {
            String[] numOfReviewsArray = numberOfReviewsSubmittedTop.getText().split(" חוות דעת");
            String numOfReviews = numOfReviewsArray[0];
            log.debug(numOfReviews + " people reviewed this item");

            reviewLineTop.click();
            log.debug("Clicked on review stars on top, and now scrolling down");
            w.until(ExpectedConditions.visibilityOf(exactReviewStarsBottom));
            Assert.assertEquals(numberOfReviewsSubmittedBottom.getAttribute("data-count"), numOfReviews);
            log.debug("Number of reviews on top matches number at the bottom");
            double numOfReviewsDouble = Double.parseDouble(numOfReviews);

            //actual stars - average of reviews
            double exactStarReview = Double.parseDouble(exactReviewStarsBottom.getText());

            double sumOfStars = 0.0;

            log.debug("Going through rows of stars review (5,4,3,2,1)");
            for (int i = 0; i < ratingList.size(); i++) {
                double numberOfReviews = Double.parseDouble(ratingList.get(i).getAttribute("data-count"));
                double ratingStars = Double.parseDouble(ratingStarAmountList.get(i).getAttribute("data-rating"));
                sumOfStars = sumOfStars + (numberOfReviews * ratingStars);
                log.info("Row's sum of stars is " + sumOfStars);
            }

            double calculatedAverageStarsRounded = (double) Math.round( sumOfStars/numOfReviewsDouble * 10.0) /10.0;
            log.debug("Performed average calculation");

            Assert.assertTrue(exactStarReview == calculatedAverageStarsRounded);
            log.info("Exact review Stars are accurately calculated- " + calculatedAverageStarsRounded);

        } else {
            log.error("There are no reviews to this item, no review average count exists.");
        }
    }



    public void addReviewToItem(){

        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(reviewLineTop));
        scroll(addReview);
        addReview.click();
        log.debug("Clicked on 'add review'");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        w.until(ExpectedConditions.visibilityOf(newReviewForm));
        Assert.assertTrue(newReviewMainBox.isDisplayed());
        log.debug("Review form opened");
        scroll(addReview);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        addReview.click();
        log.debug("Clicked on 'add review' again");
        Assert.assertTrue(!newReviewForm.isDisplayed());
        log.info("'Add Review' form was opened and closed (test does not include actual submitting)");

    }



    public void changeCartItemsQuantity() throws InterruptedException {

        try {
            for (int i = 0; i < quantityInCartList.size(); i++) {
                decreaseCartQuantity(i);
//            Thread.sleep(3000);
                increaseCartItemQuantityToMax(i);
            }
        } catch (Exception e) {
            log.error("There are no items in cart or cart is not visible");
        }
      }



        public void increaseCartItemQuantityToMax(int quantityIndex) throws InterruptedException {

            String maxQuantity = quantityInCartList.get(quantityIndex).getAttribute("data-quantity");
            int maxQuantityInt = Integer.parseInt(maxQuantity);

            int valueQuantity = Integer.parseInt(quantityInCartList.get(quantityIndex).getAttribute("value")); //1

            log.debug("Going through quantity and trying to increase");
            while (!(maxQuantityInt == valueQuantity)) {
                increaseQuantityList.get(quantityIndex).click();
                log.debug("Able to increase quantity");
//          driver.navigate().refresh();
                Thread.sleep(3000);
                valueQuantity = Integer.parseInt(quantityInCartList.get(quantityIndex).getAttribute("value"));
            }

            increaseQuantityList.get(quantityIndex).click();
            log.debug("Clicked on increase one more time");
//          driver.navigate().refresh();
            Assert.assertTrue(valueQuantity == maxQuantityInt);
            log.info("Item (" + cartItemTitleList.get(quantityIndex).getText() + ") quantity reached its maximum- " + maxQuantityInt + " and wasn't increased again");
        }



        public void decreaseCartQuantity(int quantityIndex) throws InterruptedException {

            if (quantityInCartList.get(quantityIndex).getAttribute("value").contains("1")) {
                log.info("Default quantity of second item- 1");
                decreaseQuantityList.get(quantityIndex).click();
                log.debug("Tried to decrease quantity");
                Thread.sleep(3000);
                Assert.assertEquals(quantityInCartList.get(quantityIndex).getAttribute("value"), "1");
                log.debug("Can not decrease from quantity:1");
                increaseQuantityList.get(quantityIndex).click();
                log.debug("Increased quantity by 1");
                decreaseQuantityList.get(quantityIndex).click();
                log.debug("Decreased quantity by 1");
                Thread.sleep(3000);
                Assert.assertEquals(quantityInCartList.get(quantityIndex).getAttribute("value"), "1");
                log.info("Decrease works for quantity > 1");
            }
        }




        public void shoppingCartItemTotalPrice(){

         for (int i=0; i<quantityInCartList.size(); i++ ) {

             String[] priceArray = priceInCartList.get(i).getText().split("₪");
             String[] totalPriceArray = sumPriceTotalInCartList.get(i).getText().split("₪");
             int quantity = Integer.parseInt(quantityInCartList.get(i).getAttribute("value"));
             int price = Integer.parseInt(priceArray[1]);
             int totalPrice = Integer.parseInt(totalPriceArray[1]);
             Assert.assertTrue(totalPrice == quantity * price);

             log.debug("Total item price is "+ totalPrice + " (equals price*quantity: " + price + "*" + quantity + ")");
         }
        }



        public void shoppingCartPaymentSummary() {

            //total items
            String[] totalItems = shoppingCartPaymentTotalItems.getText().split(" פריטים");
            int totalItemsInt = Integer.parseInt(totalItems[0]);
            int sumItemsQuantity =0;

            log.debug("Counting item quantity in cart before payment summary");
            for (int i=0; i<quantityInCartList.size(); i++) {
                int quantity = Integer.parseInt(quantityInCartList.get(i).getAttribute("value"));
                sumItemsQuantity = sumItemsQuantity + quantity;
                log.debug("Current quantity- " + sumItemsQuantity);
            }

            Assert.assertTrue(sumItemsQuantity == totalItemsInt);
            log.debug("Total of items quantity is calculated correctly: "+ sumItemsQuantity );

            //total price for order , without delivery
            String[] totalPriceForItems = shoppingCartPaymentTotalPriceForItems.getText().split("₪");
            int totalPriceForItemsInt = Integer.parseInt(totalPriceForItems[1]);
            int sumItemsPrices =0;

            log.debug("Counting item price in cart before payment summary");
            for (int i=0; i<quantityInCartList.size(); i++) {
                String[] totalPriceArray = sumPriceTotalInCartList.get(i).getText().split("₪");
                int totalPrice = Integer.parseInt(totalPriceArray[1]);
                sumItemsPrices = sumItemsPrices + totalPrice;
                log.debug("Current price- " + sumItemsPrices);
            }

            Assert.assertTrue(sumItemsPrices == totalPriceForItemsInt);
            log.debug("Total of prices without delivery is calculated correctly: "+ sumItemsPrices );

            //total price with delivery
            String[] deliveryFeeArray = deliveryFee.getText().split("₪");
            int deliveryFee = Integer.parseInt(deliveryFeeArray[1]);
            log.debug("Delivery fee is- " + deliveryFee);

            String[] totalWithDeliveryArray = totalPriceWithDelivery.getText().split("₪");
            int totalWithDelivery = Integer.parseInt(totalWithDeliveryArray[1]);

            Assert.assertTrue(totalWithDelivery == deliveryFee + sumItemsPrices );
            log.debug("Total of prices WITH delivery is calculated correctly: "+ totalWithDelivery );

        }




        public void paymentWithoutPayment(String paymentMethod) throws InterruptedException {

            //login
            WebDriverWait w = new WebDriverWait(driver, 10);
            w.until(ExpectedConditions.visibilityOf(loginFromStore_email));
            loginFromStore_email.clear();
            Thread.sleep(3000);
            loginFromStore_email.sendKeys(GeneralProperties.LoginEmail);
            Thread.sleep(3000);
            log.debug("Insert email in payment login");
            loginFromStore_password.clear();
            Thread.sleep(3000);
            loginFromStore_password.sendKeys(GeneralProperties.LoginPassword);
            Thread.sleep(3000);
            log.debug("Insert password in payment login");
            continueWithPaymentProcess.click();
            log.debug("Submitted payment login");

            //address confirmation
            try {
                w.until(ExpectedConditions.visibilityOf(addressBox));
                log.info("User has details saved in account (address) ");

                String[] details = {GeneralProperties.userFirstName,
                        GeneralProperties.userLastName,
                        GeneralProperties.userMobilePhone,
                        GeneralProperties.userCity,
                        GeneralProperties.userAddress
                };

                try {
                    if (addressFailureAlert.isDisplayed()) {
                        log.debug("There is something wrong with saved address");
                        editAddress.click();
                        log.debug("Clicked on 'edit address'");
                        paymentEditAddressForm();    //  goes to delivery section
                    }

                } catch (Exception exception) {
                    Assert.assertTrue(addressBox.getText().contains(details[0 - 4]));
                    log.debug("All address details exist and are valid");
                    continueAfterAddress.click();    //  goes to delivery section
                    log.debug("Clicked on continue (after addresses) and is moving to delivery");
                }


            } catch (Exception p) {
                log.info("User doesn't have details saved in account (address) ");
                paymentEditAddressForm();  //  goes to delivery section
            }

            //delivery
            w.until(ExpectedConditions.visibilityOf(deliveryOptionDiv));
            Assert.assertTrue(deliveryOptionDiv.getText().contains("שליח עד הבית"));
            log.debug("There is currently only 1 delivery method");
            continueAfterDelivery.click();
            log.debug("Clicked on 'continue' after delivery");

            //payment
            paymentOptions(paymentMethod);

        }



    //paying methods: Buyme, Credit Card , PayPal
        public void paymentOptions(String paymentMethod) throws InterruptedException {

            WebDriverWait w = new WebDriverWait(driver, 10);

            if (paymentMethod.equals("Buyme")){
                log.debug("Entered payment option -- Buyme");
                WebElement parentOfWebElement_payWithBuyme = payWithBuyme.findElement(By.xpath(".."));

                String buymeOptionNumber = parentOfWebElement_payWithBuyme.getAttribute("for");

                for (int i = 0; i< paymentOptionRadio.size(); i++){
                    log.debug("Going through radio buttons to find the Buyme radio");
                    if (paymentOptionRadio.get(i).getAttribute("id").equals(buymeOptionNumber)) {
                        paymentOptionRadio.get(i).click();
                        log.debug("Clicked on radio button");
                        Thread.sleep(2000);
                        Assert.assertTrue(buymeCardNumberInput.isDisplayed());
                        log.info("Buyme card input box is displayed, but site has a bug when continuing without input -- order is CONFIRMED.. end of test");
                        break;
                    }
                }

            } else if (paymentMethod.equals("Credit Card")) {
                log.debug("Entered payment option -- Credit Card");
                WebElement parentOfWebElement_payWithCreditCard = payWithCreditCard.findElement(By.xpath(".."));

                String creditCardOptionNumber = parentOfWebElement_payWithCreditCard.getAttribute("for");

                for (int i = 0; i< paymentOptionRadio.size(); i++){
                    log.debug("Going through radio buttons to find the Credit Card radio");
                    if (paymentOptionRadio.get(i).getAttribute("id").equals(creditCardOptionNumber)) {
                        paymentOptionRadio.get(i).click();
                        log.debug("Clicked on radio button");
                        Thread.sleep(2000);

                        Actions actions = new Actions(driver);
                        actions.moveToElement(orderConfirmation);
                        log.debug("Hoovering over 'order confirmation' button");
                        Assert.assertFalse(orderConfirmation.isEnabled());
                        log.debug("Can not confirm order without checking 'agree to terms...'");
                        agreeToTermsCheckbox.click();
                        log.debug("Clicked on 'agree to terms'");
                        orderConfirmation.click();
                        log.debug("Clicked on 'order confirmation'");
                        Thread.sleep(3000);
                        Assert.assertTrue(driver.getCurrentUrl().contains("icom.yaad.net"));
                        log.info("Credit Card secured payment url opened");
                        break;
                    }
                }

            } else if (paymentMethod.equals("PayPal")) {
                log.debug("Entered payment option -- PayPal");
                WebElement parentOfWebElement_payWithPayPal = payWithPayPal.findElement(By.xpath(".."));
                String paypalOptionNumber = parentOfWebElement_payWithPayPal.getAttribute("for");

                for (int i = 0; i< paymentOptionRadio.size(); i++){
                    log.debug("Going through radio buttons to find the PayPal radio");
                    if (paymentOptionRadio.get(i).getAttribute("id").equals(paypalOptionNumber)) {
                        paymentOptionRadio.get(i).click();
                        log.debug("Clicked on radio button");
                        Thread.sleep(2000);

                        Actions actions = new Actions(driver);
                        actions.moveToElement(orderConfirmation);
                        log.debug("Hoovering over 'order confirmation'");
                        Assert.assertFalse(orderConfirmation.isEnabled());
                        log.debug("Can not confirm order without checking 'agree to terms...'");
                        agreeToTermsCheckbox.click();
                        log.debug("Clicked on 'agree to terms'");
                        orderConfirmation.click();
                        log.debug("Clicked on 'order confirmation'");
                        w.until(ExpectedConditions.numberOfWindowsToBe(2));
                        moveToNextTab();
                        Assert.assertTrue(driver.getTitle().contains("PayPal"));
                        log.info("A new window was opened for PayPal payment");
                        break;
                    }
                }
            } else {
                log.error("Payment method does not exist yet");
            }

    }




        public void paymentEditAddressForm(){     //logged in user

            WebDriverWait w = new WebDriverWait(driver, 10);
            w.until(ExpectedConditions.visibilityOf(addressForm));
            log.debug("User doesn't have FULL address details in account and must insert them");
            Assert.assertEquals(addressFormFirstName.getAttribute("value"), GeneralProperties.userFirstName);
            log.debug("First name is automatically filled up");
            Assert.assertEquals(addressFormLastName.getAttribute("value"), GeneralProperties.userLastName);
            log.debug("Last name is automatically filled up");
            if (addressFormMobilePhone.getAttribute("value").isEmpty()) {
                addressFormMobilePhone.sendKeys(GeneralProperties.userMobilePhone);
                log.debug("Added mobile phone number");
            }
            addressFormCity.clear();
            addressFormCity.sendKeys("תל אביב");
            log.debug("Inserted city");
            addressFormAddress.clear();
            addressFormAddress.sendKeys("דיזינגוף 100");
            log.debug("Inserted street");
            if (!addressFormSameAddressCheckbox.isSelected()){
                addressFormSameAddressCheckbox.click();
                log.debug("Address is checked as the same for delivery and payment");
            }

            continueAfterAddress.click();
            log.debug("Clicked on continue after addresses");
            continueAfterAddress.click();
            log.debug("Clicked on 'continue' again- moving to delivery");
        }

}
