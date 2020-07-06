package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    //members
    private WebDriver driver;

    @FindBy(id="hp_user_details")
    public WebElement logInButton;

    @FindBy(id="edit-name")
    public WebElement logInInputEmail;

    @FindBy(id="edit-pass")
    public WebElement logInInputPassword;

    @FindBy(id="login_widget_submit_btn")
    public WebElement logInSubmit;

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




    //constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
