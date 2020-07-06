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

    @FindBy(xpath = "//*[@id=\"authenticated_user_menu\"]/li[1]/span")
    public WebElement userMenuName;

//    @FindBy(css = "")
//    public WebElement userMenuNameCSS;


    //constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
