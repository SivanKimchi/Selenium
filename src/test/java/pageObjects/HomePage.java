package pageObjects;

import Lametayel.GeneralProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

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
    public WebElement userMenuMyMessages;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(12)")
    public WebElement userMenuMyFavorites;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(13)")
    public WebElement userMenuMyPublishedContents;

    @FindBy(css = "ul[id='authenticated_user_menu'] li:nth-child(14)")
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

    @FindBy(id="m-dests-n_america")
    public WebElement mainMenuDestinationNorthAmerica;

    @FindBy(css = "div[id='m-n_america'] span:nth-child(3) li:nth-child(2)")
    public WebElement mainMenuDestinationCanada;


    //members- "like" box at the scroll down
    @FindBy (css = "div[id='hp_like_box'] h2[class='heading heading-sm']")
    public WebElement facebookLikeBox;


    public void logIntoSite(){
        logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        logInSubmit.click();
        System.out.println("Logged in as existing user");

    }

    public void invalidLogIn() throws InterruptedException {

        logInButton.click();
        logInInputEmail.sendKeys("email");
        logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        logInSubmit.click();
        Thread.sleep(3000);
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());

        logInInputEmail.clear();
        logInInputEmail.sendKeys("");
        logInInputPassword.clear();
        logInInputPassword.sendKeys(GeneralProperties.LoginPassword);
        logInSubmit.click();
        Thread.sleep(3000);
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());

        logInInputEmail.clear();
        logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        logInInputPassword.clear();
        logInInputPassword.sendKeys("123456");
        logInSubmit.click();
        Thread.sleep(3000);
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());

        logInInputEmail.clear();
        logInInputEmail.sendKeys(GeneralProperties.LoginEmail);
        logInInputPassword.clear();
        logInInputPassword.sendKeys("");
        logInSubmit.click();
        Thread.sleep(3000);
        Assert.assertTrue(invalidLoginErrorContainer.isDisplayed());

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


    public void moveToNextTab(){

        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

    }

    //constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
