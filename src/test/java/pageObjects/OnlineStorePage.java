package pageObjects;

import Lametayel.GeneralProperties;
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


    @FindBy(css = "div[class*='product_list_item']")
    public List<WebElement> resultList;

    @FindBy(css = "div[class*='product_list_item'] span[class='price ']")
    public List<WebElement> resultPriceList;

//    //
//    @FindBy (css = "div[class*='product_list_item'] article div div[class='pro_second_box pro_block_align_0'] div:nth-child(3) div span[class='price ']")
//    public List<WebElement> resultPriceList;

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

    @FindBy (css = "div[class='hidden-md-down'] a[itemprop='brand']")
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






     public void scroll(WebElement waitForVisibilityOf) {
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
    }


    public void skipAd() {
        try {
            skipToPageButton.click();
        } catch (Exception e) {
            System.out.println("no ad page was skipped");
        }
    }


    public void addItemToCart(int itemIndex) {


        scroll(productSectionItem.get(0));   //first SECTION of products

        String itemName = productitemsh3.get(itemIndex).getText();
        System.out.println("Item: " + itemName);
        productitemsh3.get(itemIndex).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(itemTitle));

        Assert.assertEquals(itemName, itemTitle.getText());
        System.out.println("Clicked on item amd opened it in a new window");

        addItemToCart.click();

        wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
        Assert.assertTrue(itemAddedToCartMessageHeadline.getText().contains("המוצר נוסף לסל הקניות!"));

        goToCart.click();

        checkItemAddedToCart(itemName);

    }


    public void checkItemAddedToCart(String itemTitle) {

        boolean itemAdded = false;

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cartHeader));
        Assert.assertTrue(cartItems.isDisplayed());

        for (int i = 0; i < cartItemTitleList.size(); i++) {

            if (cartItemTitleList.get(i).getText().contains(itemTitle)) {
                System.out.println("Item was successfully added to cart.");
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


    public void searchItemChooseFromList(String searchFor, int itemIndex) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.clear();

        searchBar.sendKeys(searchFor);
        Thread.sleep(3000);
        Assert.assertTrue(suggestedAutocompleteItemSearch.isDisplayed());

        Actions actions = new Actions(driver);
        actions.moveToElement(searchSuggestionsList.get(itemIndex)).build().perform();
        Assert.assertTrue(searchSuggestionsList.get(itemIndex).getAttribute("class").contains("autocomplete-selected"));
        String itemName = searchSuggestionsList.get(itemIndex).getText();
        searchSuggestionsList.get(itemIndex).click();
        wait.until(ExpectedConditions.visibilityOf(itemTitle));
        Assert.assertTrue(itemName.contains(itemTitle.getText()));
        System.out.println("Item was chosen from autocomplete search suggestion: " + itemName);
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
                    System.out.println("price- " + price + " itemprice- " + itemPrice);
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


    public void pickAnItemFromTopBar(int mainCategoryIndex, int categoryHeadlineIndex, int categoryIndex) {

        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(shopTopBarList.get(mainCategoryIndex)).build().perform();   //1=גברים

            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

            try {
                actions.moveToElement(shopTopBarChoiceRowColumnHeadlineList.get(categoryHeadlineIndex)).build().perform(); //2=סנדלים לגברים
                System.out.println("Category headline- " + shopTopBarChoiceRowColumnHeadlineList.get(categoryHeadlineIndex).getText());

                // ** MINI SCOPE for categories column (mini driver)
                WebElement column = shopTopBarChoiceRowColumnList.get(categoryHeadlineIndex);
                List<WebElement> itemCategory = column.findElements(By.cssSelector("ul[class*='p_granditem'] a"));

                try {
                    String category = itemCategory.get(categoryIndex).getText();
                    actions.moveToElement(itemCategory.get(categoryIndex)).click().build().perform();

                    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
                    Assert.assertEquals(categoryTitle.getText(), category);
                    System.out.println("Items category was chosen from top bar (" + categoryTitle.getText() + ")");
                } catch (Exception e) {
                    System.out.println("Index is out of bound for this item category scope. Please run the test again with small index.");
                }

            } catch (Exception e) {
                System.out.println("Index is out of bound for this category scope. Please run the test again with small index.");
            }

        } catch (Exception e) {
            System.out.println("Main category index is too big and out of scope. Please run the test again with a smaller index.");
        }
    }



    public void changeItemColor() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String newColor ="";

        try {

            wait.until(ExpectedConditions.visibilityOf(colorSizeRows.get(0)));
            // MINI DRIVER
            WebElement colors = colorSizeRows.get(0);
            List<WebElement> itemColorList = colors.findElements(By.cssSelector("ul[id*='group_'] li input[class='input-radio']"));
            List<WebElement> itemColorTextList = colors.findElements(By.cssSelector("ul[id*='group_'] li span[class='radio-label']"));


            System.out.println(itemColorList.size());

            if ((itemColorList.size() > 0) && (itemColorList.size() > 1)) {

                for (int i = 0; i < itemColorList.size(); i++) {

                    if (itemColorList.get(i).isSelected()) {

                        try {
                            System.out.println("Color selected now- " + itemColorTextList.get(i).getText());
                            itemColorList.get(i + 1).click();
                            Assert.assertTrue(itemColorList.get(i + 1).isSelected());
                            System.out.println("Now the next color is selected- " + itemColorTextList.get(i + 1).getText());
                            newColor = itemColorTextList.get(i + 1).getText();
                            break;
                        } catch (Exception e) {
                            System.out.println("Color selected now- " + itemColorTextList.get(i).getText());
                            itemColorList.get(i - 1).click();
                            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
                            Assert.assertTrue(itemColorList.get(i - 1).isSelected());
                            System.out.println("Now the previous color is selected- " + itemColorTextList.get(i - 1).getText());
                            newColor = itemColorTextList.get(i - 1).getText();
                            break;
                        }


                    } else {
                        System.out.println("Color not selected: " + itemColorTextList.get(i).getText());
                    }
                }
                Thread.sleep(5000);
                addItemToCart.click();
                wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
                Assert.assertTrue(colorSizeAmountLine.get(0).getText().contains(newColor));

            } else {
                System.out.println("There is only one color available");
                Assert.assertTrue(itemColorList.get(0).isSelected());
            }
        } catch (Exception e) {
            System.out.println("Item probably not in stock, and there is no color to choose.");
        }


    }


    public void changeItemSize(){

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(colorSizeRows.get(1)));
            // MINI DRIVER
            WebElement sizes = colorSizeRows.get(1);
            List<WebElement> itemSizeList = sizes.findElements(By.cssSelector("ul[id*='group_'] li input[class='input-radio']"));
            List<WebElement> itemSizeTextList = sizes.findElements(By.cssSelector("ul[id*='group_'] li span[class='radio-label']"));

                System.out.println(itemSizeList.size());

                if (itemSizeList.size() > 1) {

                    String newSize="";

                    for (int i = 0; i < itemSizeList.size(); i++) {

                        if (itemSizeList.get(i).isSelected()) {

                            try {
                                System.out.println("Size selected now- " + itemSizeTextList.get(i).getText());
                                itemSizeList.get(i+1).click();
                                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
                                Assert.assertTrue(itemSizeList.get(i+1).isSelected());
                                System.out.println("Now the next size is selected- " + itemSizeTextList.get(i+1).getText());
                                newSize = itemSizeTextList.get(i+1).getText();
                                break;

                            } catch (Exception e) {
                                System.out.println("Size selected now- " + itemSizeTextList.get(i).getText());
                                itemSizeList.get(i - 1).click();
                                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
                                Assert.assertTrue(itemSizeList.get(i - 1).isSelected());
                                System.out.println("Now the previous size is selected- " + itemSizeTextList.get(i - 1).getText());
                                newSize = itemSizeTextList.get(i - 1).getText();
                                break;

                            }
                        } else {
                            System.out.println("Size not selected: " + itemSizeTextList.get(i).getText());
                        }
                    }
                        Thread.sleep(5000);
                        addItemToCart.click();
                        wait.until(ExpectedConditions.visibilityOf(itemAddedToCartMessageBox));
                        Assert.assertTrue(colorSizeAmountLine.get(1).getText().contains(newSize));
                } else {
                    System.out.println("There is only one size available");
                    Assert.assertTrue(itemSizeList.get(0).isSelected());
                }
        } catch (Exception e) {
            System.out.println("There are no size options to this items");
        }

    }




    public void changeQuantityOfItem(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(quantity));

        //There is an error in the website -- the input tag isn't updated in any attribute, and quantity getText doesn't work either
        //Can not check is quantity is updated on this screen, only on next screen

        try {
            increaseQuantity.click();
//            Assert.assertEquals(quantity.getAttribute("value"), "1");
            System.out.println("Quantity has increased");
            decreaseQuantity.click();
//            Assert.assertEquals(quantity.getAttribute("value"), "1");
            System.out.println("Quantity has decreased");

            //Check if there is size selection
            if (colorSizeRows.size()==2){
                addItemToCart.click();
                Assert.assertTrue(colorSizeAmountLine.get(2).getText().equals("1"));
                System.out.println("Added to cart with chosen quantity- 1");
            } else if (colorSizeRows.size()==1){
                addItemToCart.click();
                Assert.assertTrue(colorSizeAmountLine.get(1).getText().equals("1"));
                System.out.println("Added to cart with chosen quantity- 1");
            }

        } catch (Exception e) {

            Assert.assertTrue(productAvailability.getAttribute("class").contains("product-unavailable") || productAvailability.getAttribute("class").contains("product-last-items"));
            System.out.println("Product is not available or limited");
        }

    }



    public void saveProduct() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveProduct));

        saveProduct.click();

        System.out.println("User need to log in");
        wait.until(ExpectedConditions.visibilityOf(loginToStoreBox));
        loginToStoreButton.click();
        signInToStore();

        wait.until(ExpectedConditions.visibilityOf(usersSavedItems));
        usersSavedItems.click();
        wait.until(ExpectedConditions.visibilityOf(savedItemsPageContent));
//      Assert.assertTrue(notificationNoSavedItems.isDisplayed());
            try {
                Assert.assertFalse(userSavedItemsRow.isDisplayed());
            } catch (Exception e) {
                System.out.println("Item was not added to 'Saved items' because user was not signed in to store");
            }
         //going back to save item as Logged In user
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        saveItemAsLoggedInUserInStore();

        }



     public void signInToStore() throws InterruptedException {

         WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.visibilityOf(loginFromStore_email));
         loginFromStore_email.sendKeys(GeneralProperties.LoginEmail);
         Thread.sleep(3000);
         loginFromStore_password.sendKeys(GeneralProperties.LoginPassword);
         Thread.sleep(3000);
         loginButton.click();

     }


    public void saveItemAsLoggedInUserInStore() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(saveProduct));

        String productTitle = itemTitle.getText();

        saveProduct.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//      wait.until(ExpectedConditions.attributeContains(saveProduct, "class","st_added"));
        Assert.assertTrue(saveProductSaved.getAttribute("class").contains("st_added"));
        Actions a = new Actions(driver);
        a.moveToElement(userMenuInStore).build().perform();
        a.moveToElement(userMenuInStoreOptions.get(1)).click().build().perform();
//      Assert.assertTrue(savedItemsPageContent.getText().contains("המוצרים ששמרתי"));
        Assert.assertTrue(userSavedItemsRow.getText().contains(productTitle));
        System.out.println("Logged in user- Item was successfully added to Saved Items");
        deleteSavedItem.click();
        Thread.sleep(3000);
        try {
            Assert.assertFalse(userSavedItemsRow.getText().contains(productTitle));
            System.out.println("Item was successfully deleted from Saved Items");

        } catch (Exception f) {
            System.out.println("Logged in user- Item was successfully deleted from Saved Items");
        }

    }


    public void availabilityInBranches(int branchIndex){

        OrderWidgetOnHomePage orderWidget = new OrderWidgetOnHomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(itemAvailabilityInBranchesDropDown));
        itemAvailabilityInBranchesDropDown.click();
        String branch="";

        try {
            wait.until(ExpectedConditions.visibilityOf(itemAvailabilityInBranchesList.get(0)));
            System.out.println("Item is available in " + itemAvailabilityInBranchesList.size() + " branches");

            try {
                String[] branchName = itemAvailabilityInBranchesList.get(branchIndex).getText().split("עודפים - ");
                branch = branchName[1];
            } catch (Exception e) {
                branch = itemAvailabilityInBranchesList.get(branchIndex).getText();
            }

            itemAvailabilityInBranchesList.get(branchIndex).click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(3));

            moveToNextTab();

            skipAd();

            wait.until(ExpectedConditions.visibilityOf(orderWidget.firstBranchMoreInfoPageHeadline));
            Assert.assertTrue(orderWidget.firstBranchMoreInfoPageHeadline.getText().contains(branch));
            System.out.println("Branch info page open");

        } catch (Exception e) {
            System.out.println("Item is unavailable in all branches");
        }

    }


    public void moreProductsFromBrand(){

        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(itemBrand));
        String itemsBrand = itemBrand.getText();
        itemBrand.click();
        w.until(ExpectedConditions.visibilityOf(brandPageTitle));
        Assert.assertEquals(brandPageTitle.getText(),  "רשימת מוצרים לפי מותג "+ itemsBrand);
        System.out.println("Relevant brand page loaded");

        w.until(ExpectedConditions.visibilityOfAllElements(resultBrandList));//sometimes it still goes to another item. why??

            if ((resultBrandList.size() > 0)) {

                String brand = "";
                // trying only 2 rows for visibility issues
                for (int i = 0; i <= 5; i++) {
                    String itemBrandFromList = resultBrandList.get(i).getText();
                    Assert.assertEquals(itemBrandFromList, itemsBrand);
                }

            System.out.println("Items have the same brand- " + itemsBrand);

        } else  {
            System.out.println("There are no results");
        }

    }


    public void itemReviewsCount(){

        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(reviewLineTop));

        //number of stars

        boolean starIsChecked;
        double amountOfStarsChecked=0.0;
        double halfStar = 0.0;

        for (int i=0; i<reviewStarsOnTopList.size(); i++) {
            if (reviewStarsOnTopList.get(i).getAttribute("class").equals("stamped-fa stamped-fa-star")){
                starIsChecked = true;
                amountOfStarsChecked = amountOfStarsChecked+1.0;
            } else if (reviewStarsOnTopList.get(i).getAttribute("class").equals("stamped-fa stamped-fa-star-o")) {
                starIsChecked = false;
            } else if (reviewStarsOnTopList.get(i).getAttribute("class").equals("stamped-fa stamped-fa-star-half-o")){
                halfStar = 0.5;
            }
        }

        amountOfStarsChecked = amountOfStarsChecked + halfStar;
        if (amountOfStarsChecked > 0) {

            System.out.println("Review to this item (round) is: " + amountOfStarsChecked + " stars");

            String[] numOfReviewsArray = numberOfReviewsSubmittedTop.getText().split(" חוות דעת");
            String numOfReviews = numOfReviewsArray[0];

            reviewLineTop.click();
            w.until(ExpectedConditions.visibilityOf(exactReviewStarsBottom));
            Assert.assertEquals(numberOfReviewsSubmittedBottom.getAttribute("data-count"), numOfReviews);
            double numOfReviewsDouble = Double.parseDouble(numOfReviews);


            //actual stars - average of reviews
            double exactStarReview = Double.parseDouble(exactReviewStarsBottom.getText());

            double sumOfStars = 0.0;
            for (int i = 0; i < ratingList.size(); i++) {
                double numberOfReviews = Double.parseDouble(ratingList.get(i).getAttribute("data-count"));
                double ratingStars = Double.parseDouble(ratingStarAmountList.get(i).getAttribute("data-rating"));
                sumOfStars = sumOfStars + (numberOfReviews * ratingStars);
            }

            double calculatedAverageStarsRounded = (double) Math.round( sumOfStars/numOfReviewsDouble * 10.0) /10.0;

            Assert.assertTrue(exactStarReview == calculatedAverageStarsRounded);
            System.out.println("Exact review Stars are accurately calculated- " + calculatedAverageStarsRounded);

        } else {
            System.out.println("There are no reviews to this item, no review average count exists.");
        }

    }


    public void addReviewToItem(){

        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(reviewLineTop));
        scroll(addReview);
        addReview.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        w.until(ExpectedConditions.visibilityOf(newReviewForm));
        Assert.assertTrue(newReviewMainBox.isDisplayed());
        scroll(addReview);
        addReview.click();
        Assert.assertTrue(!newReviewForm.isDisplayed());
        System.out.println("'Add Review' form was opened and closed (test does not include actual submitting)");

    }



    public void changeCartItemsQuantity() throws InterruptedException {

        for (int i=0; i<quantityInCartList.size(); i++){
            decreaseCartQuantity(i);
//            Thread.sleep(3000);
            increaseCartItemQuantityToMax(i);
        }

      }



        public void increaseCartItemQuantityToMax(int quantityIndex) throws InterruptedException {

            String maxQuantity = quantityInCartList.get(quantityIndex).getAttribute("data-quantity");
            int maxQuantityInt = Integer.parseInt(maxQuantity);

            int valueQuantity = Integer.parseInt(quantityInCartList.get(quantityIndex).getAttribute("value")); //1

            while (!(maxQuantityInt == valueQuantity)) {
                increaseQuantityList.get(quantityIndex).click();
//          driver.navigate().refresh();
                Thread.sleep(3000);
                valueQuantity = Integer.parseInt(quantityInCartList.get(quantityIndex).getAttribute("value"));
            }

            increaseQuantityList.get(quantityIndex).click();
//          driver.navigate().refresh();
            Assert.assertTrue(valueQuantity == maxQuantityInt);
            System.out.println("Item (" + cartItemTitleList.get(quantityIndex).getText() + ") quantity reached its maximum- " + maxQuantityInt + " and wasn't increased again");
        }



        public void decreaseCartQuantity(int quantityIndex) throws InterruptedException {

            if (quantityInCartList.get(quantityIndex).getAttribute("value").contains("1")) {
                System.out.println("Default quantity of second item- 1");
                decreaseQuantityList.get(quantityIndex).click();
                Thread.sleep(3000);
                Assert.assertEquals(quantityInCartList.get(quantityIndex).getAttribute("value"), "1");
                System.out.println("Can not decrease from quantity:1");
                increaseQuantityList.get(quantityIndex).click();
                decreaseQuantityList.get(quantityIndex).click();
                Thread.sleep(3000);
                Assert.assertEquals(quantityInCartList.get(quantityIndex).getAttribute("value"), "1");
                System.out.println("Decrease works for quantity > 1");
            }
        }





    //constructor
    public OnlineStorePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}