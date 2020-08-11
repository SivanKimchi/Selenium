package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import Lametayel.GeneralProperties;   //uses JsonValues.json -- gitignore (template available)

public class HomePage {


    //members
    private WebDriver driver;

    @FindBy(id="login_form_wrapper")
    public WebElement logInForm;

    //regular expression    //button has different id in other pages
    @FindBy (xpath = "//span[contains(@class, 'icon-user')]")
    public WebElement logInButton;

    @FindBy(id="edit-name")
    public WebElement logInInputEmail;

    @FindBy(id="edit-pass")
    public WebElement logInInputPassword;

    @FindBy(id="login_widget_submit_btn")
    public WebElement logInSubmit;

    @FindBy (css = "div[class='login_errors_container error mt-1']")
    public WebElement invalidLoginErrorContainer;

    @FindBy(xpath="//*[@id=\"hd_user_img\"]/img")
    public WebElement loggedUserImg;

    @FindBy(id="hd_user_img")
    public WebElement userMenu;

    @FindBy(id="authenticated_user_menu")
    public WebElement userMenuOpened;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(1)")
    public WebElement userMenuName;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(2)")
    public WebElement userMenuLametayelSheliClub;


    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(3)")
    public WebElement userMenuEditProfile;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(4)")
    public WebElement userMenuViewProfile;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(5)")
    public WebElement userMenuNewsletterManagement;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(6)")
    public WebElement userMenuAddNewContent;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(7)")
    public WebElement userMenuAddNewTip;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(8)")
    public WebElement userMenuAddNewBlogPost;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(9)")
    public WebElement userMenuAddNewPartnersAd;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(10)")
    public WebElement userMenuMyContents;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(11)")
    public WebElement userMenuMyBlog;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(12)")
    public WebElement userMenuMyMessages;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(13)")
    public WebElement userMenuMyFavorites;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(14)")
    public WebElement userMenuMyPublishedContents;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(15)")
    public WebElement userMenuMyContentsComments;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(16)")
    public WebElement userMenuDisconnect;

    //members - centralBarLinks

    @FindBy(css = "div[class='market-buttons max-w-full -mt-12 absolute pin-t bg-white rounded-lg shadow-lg']")
    public WebElement centralBar;

    @FindBy(css = "span[class='icon icon-plane text-3xl md:text-4xl mt-2']")
    public WebElement flights;

    @FindBy(css = "span[class='icon icon-lodging text-3xl md:text-4xl mt-2']")
    public WebElement hotels;

    @FindBy(css = "span[class='icon icon-award text-3xl md:text-4xl mt-2']")
    public WebElement insurance;

    @FindBy(css = "span[class='icon icon-gift text-3xl md:text-4xl mt-2']")
    public WebElement benefits;

    @FindBy(css = "span[class='icon icon-dots-three-vertical text-3xl md:text-4xl mt-2']")
    public WebElement moreOptions;
    //

    @FindBy(css = "section[class='section-market flex flex-col lg:flex-row items-center lg:items-start justify-center py-8 lg:py-16 mt-10 lg:mt-20 -mx-2 lg:mx-0']")
    public WebElement bottomWidget;

    @FindBy(css = "input[class='menu_search appearance-none outline-none text-base md:text-xl border-none flex-1 py-3 md:py-4 pr-12 ui-autocomplete-input']")
    public WebElement searchBar;

    @FindBy (id="ui-id-2")
    public WebElement searchAutocomplete;

    @FindBy(css = "button[class='appearance-none btn-lam border-none font-bold select-none px-6 md:px-12 py-3 md:py-4 text-base md:text-xl']")
    public WebElement searchButton;

    @FindBy (id="node_title")
    public WebElement searchResultsPageH1;


    //members- main menu
    @FindBy (id= "m-dests-li")
    public WebElement mainMenuDestinations;

    @FindBy (id= "m-sites-li")
    public WebElement mainMenuTripTypes;

    @FindBy (css= "span[class='icon-tips main_menu_item_icon']")
    public WebElement mainMenuTips;

    @FindBy (xpath= "//*[@id='main-menu']/li[6]/a")
    public WebElement mainMenuBlogs;

    @FindBy (css= "span[class='icon-partners main_menu_item_icon']")
    public WebElement mainMenuPartners;

    @FindBy (id = "m-forum-li")
    public WebElement mainMenuForums;

    @FindBy (id = "m-info-li")
    public WebElement mainMenuInspiration;

    @FindBy (id = "m-shops-li")
    public WebElement mainMenuLametayelBranches;

    @FindBy (css = "li[id='m-internet-shop-li'] a")
    public WebElement mainMenuLametayelOnlineShop;

    @FindBy(id="m-dests")
    public WebElement mainMenuDestinationsMenu;

    @FindBy(css = "ul[id='m-dests'] li[class='dropdown_menu_dests']")
    public List<WebElement> mainMenuDestinationList;


    @FindBy(css = "div[class='dropdown_content_menu_dests m_dest_ul is_submenu'] span:nth-child(3) li a")
    public List<WebElement> mainMenuDestinationPopularCountriesList;

    @FindBy (css = "h1 span[class='relative text-shadow pr-3 md:pr-6']")
    public WebElement destinationPageh1;


    @FindBy (xpath = "//button[contains(text(), 'דלג לאתר')]")
    public WebElement skipToPageButton;


    //members- "like" box at the scroll down
    @FindBy (css = "div[id='hp_like_box'] h2[class='heading heading-sm']")
    public WebElement facebookLikeBox;



    private static Logger log = LogManager.getLogger(HomePage.class.getName());


    //constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void skipAd() {
        try {
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOf(skipToPageButton));
            skipToPageButton.click();
            log.debug("Skipped ad page");
        } catch (Exception e) {
            log.error("No ad page was skipped");
        }
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


    public void logIntoSite(){

        logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        log.debug("Inserted email to login form");
        logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        log.debug("Inserted password to login form");
        logInSubmit.click();
        log.info("Logged to website");

    }

    public void invalidLogIn() throws InterruptedException {

        logInButton.click();
        log.debug("Clicked on main login button");
        logInInputEmail.sendKeys("email");
        log.debug("Inserted invalid email");
        logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        log.debug("Inserted valid password");
        logInSubmit.click();
        Thread.sleep(5000);
        log.debug("Submitted login form");
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());
        log.info("Login is invalid as expected");

        logInInputEmail.clear();
        logInInputEmail.sendKeys("");
        log.debug("Inserted invalid email");
        logInInputPassword.clear();
        logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        log.debug("Inserted valid password");
        logInSubmit.click();
        Thread.sleep(3000);
        log.debug("Submitted login form");
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());
        log.info("Login is invalid as expected");

        logInInputEmail.clear();
        logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        log.debug("Inserted valid email");
        logInInputPassword.clear();
        logInInputPassword.sendKeys("123456");
        log.debug("Inserted invalid password");
        logInSubmit.click();
        Thread.sleep(5000);
        log.debug("Submitted login form");
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());
        log.info("Login is invalid as expected");

        logInInputEmail.clear();
        logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        log.debug("Inserted valid email");
        logInInputPassword.clear();
        logInInputPassword.sendKeys("");
        log.debug("Inserted invalid password");
        logInSubmit.click();
        Thread.sleep(3000);
        log.debug("Submitted login form");
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());
        log.info("Login is invalid as expected");

    }



    public void assertUserMenuValuesValid(){

        Assert.assertEquals(userMenuName.getText(), "היי earth_trekker");
        Assert.assertEquals(userMenuLametayelSheliClub.getText(), "מועדון למטייל שלי");
        Assert.assertEquals(userMenuEditProfile.getText(), "עריכת הפרופיל");
        Assert.assertEquals(userMenuViewProfile.getText(), "צפיה בפרופיל");
        Assert.assertEquals(userMenuNewsletterManagement.getText(), "ניהול הרשמות ודיוורים");
        Assert.assertEquals(userMenuAddNewContent.getText(), "הוספת תוכן חדש");
        Assert.assertEquals(userMenuAddNewTip.getText(), "טיפ");
        Assert.assertEquals(userMenuAddNewBlogPost.getText(), "פוסט לבלוג");
        Assert.assertEquals(userMenuAddNewPartnersAd.getText(), "מודעת מחפשים שותפים");
        Assert.assertEquals(userMenuMyContents.getText(), "התכנים שלי");
        Assert.assertEquals(userMenuMyMessages.getText(), "הודעות");
        Assert.assertEquals(userMenuMyFavorites.getText(), "המועדפים שלי");
        Assert.assertEquals(userMenuMyPublishedContents.getText(), "התכנים שפירסמתי");
        Assert.assertEquals(userMenuMyContentsComments.getText(), "תגובות לתכנים שפירסמתי");
        Assert.assertEquals(userMenuDisconnect.getText(), "יציאה מהמערכת");

        Assert.assertEquals(userMenuName.getAttribute("role"), "presentation");
        Assert.assertEquals(userMenuAddNewContent.getAttribute("role"), "presentation");
        Assert.assertEquals(userMenuMyContents.getAttribute("role"), "presentation");

    }



    public void searchBarAutoComplete(String search, String expectedResult){

        searchBar.sendKeys(search);
        log.debug("Inserted search value");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(searchAutocomplete));

        //autocomplete dropdown
        searchBar.sendKeys(Keys.ARROW_DOWN);
        log.debug("Navgiated one spot on drop down autocomplete");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        searchBar.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedResult));
        log.info("Search result shows in new page");
    }


    public void searchBarInstantEnter(String partialSearchString, String expectedResult){

        searchBar.sendKeys(partialSearchString);
        log.debug("Inserted search partial-value");
        searchBar.sendKeys(Keys.ENTER);
        log.debug("Clicked Enter");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        skipAd();
        Assert.assertEquals(searchResultsPageH1.getText(),expectedResult);
        log.info("Search query shows in general results page");

    }


    public void mainMenuDestinationDropDown(int continentIndex, int countryIndex){

        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);

        actions.moveToElement(mainMenuDestinations).build().perform();
        log.debug("Hoovered over destinations tab");
        wait.until(ExpectedConditions.visibilityOf(mainMenuDestinationList.get(1)));   //0 is not visible

        try {

            actions.moveToElement(mainMenuDestinationList.get(continentIndex)).build().perform();     //max 8
            log.debug("Hoovered specific continent");

            // * MINI SCOPE *
            WebElement miniScopeChosenContinent = mainMenuDestinationList.get(continentIndex);
            List<WebElement> popularCountries = miniScopeChosenContinent.findElements(By.cssSelector("span:nth-child(3) li a"));
            log.debug("Switched to mini scope of country list");

            try {
                actions.moveToElement(popularCountries.get(countryIndex)).build().perform();
                log.debug("Hoovered over a specific country");

                String country = popularCountries.get(countryIndex).getText();
                popularCountries.get(countryIndex).click();
                log.debug("Clicked on specific country");

                wait.until(ExpectedConditions.visibilityOf(destinationPageh1));

                Assert.assertTrue(destinationPageh1.getText().contains(country));
                log.info("Selected popular country from main drop down menu Destinations (" + country + ")");

            } catch (Exception a) {
                log.error("Country index is out of bound. Please run test again with a smaller index");
            }

        } catch (Exception e) {
            log.error("Continent index is out of bound. Please run test again with a smaller index");
        }

    }

}
