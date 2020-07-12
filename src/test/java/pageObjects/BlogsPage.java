package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BlogsPage {


    //members
    private WebDriver driver;

    @FindBy (xpath = "//*[@id='index-main-page-search']/div[2]/div/div[1]/span[2]")
    public WebElement searchBlogsBar;

    @FindBy (xpath = "//*[@id='index-main-page-search']/div[2]/div/div[2]/ul/div/li/input")
    public WebElement searchBlogsInput;


    @FindBy (css = "div[class='mdc-menu-surface--anchor h-full cursor-pointer'] div div")
    public WebElement searchBlogsButton;

    @FindBy (css = "div[class='mt-10 md:mt-20'] article div:nth-of-type(2) a span")
    public WebElement writeABlog;

    @FindBy (css = "article[class='mt-10 md:mt-20'] div div")   //should be 9
    public List<WebElement> suggestedBlogPosts;

    //REGULAR EXPRRESSION
    @FindBy (css = "article[class='mt-10 md:mt-20'] article[class*='post-card']")   //should be 30
    public List<WebElement> recentBlogPosts;

    @FindBy (css = "li[class='page-item'] a")
    public WebElement nextSectionOfBlogPosts;

    @FindBy (css = "div:nth-of-type(1) main section:nth-of-type(1) div:nth-of-type(2) h2")
    public WebElement blogPostsHeader;

    @FindBy (css = "section[class='mb-10'] div:nth-of-type(2) label input")
    public  WebElement searchBlogFreeText;

    @FindBy (css = "div[id='results-container'] article")   //size:2
    public List<WebElement> myBlogIcelandPosts;

    @FindBy (css = "[id='app'] section div h1")
    public WebElement myBlog;






    public void searchBlogPost(String searchPostAbout) throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.mainMenuBlogs.click();

        wait.until(ExpectedConditions.visibilityOf(searchBlogsBar));
        searchBlogsBar.click();

        searchBlogsInput.clear();
        searchBlogsInput.sendKeys(searchPostAbout);
        Thread.sleep(3000);
        searchBlogsInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(blogPostsHeader));
        Assert.assertTrue(blogPostsHeader.getText().contains(searchPostAbout));

        if (searchPostAbout.equals("איסלנד")) {
            //  ** search for MY Iceland blog posts **
            searchBlogFreeText.sendKeys("איסלנד - ספטמבר 2017", Keys.ENTER);
            driver.navigate().refresh();
            Assert.assertEquals(myBlogIcelandPosts.size(), 2);
            System.out.println("I have two posts about Iceland :)");

        } else if (searchPostAbout.equals("נורווגיה")) {
            //  ** search for MY Norway blog posts **
            searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
            driver.navigate().refresh();
            Assert.assertEquals(myBlogIcelandPosts.size(), 2);
            System.out.println("I have two posts about Norway :)");

        } else if (searchPostAbout.equals("ארה\"ב") || searchPostAbout.equals("סקוטלנד") || searchPostAbout.equals("פראג") || searchPostAbout.equals("גרמניה")) {
            //  ** search for MY blog posts **

            driver.navigate().to("https://www.lametayel.co.il/blogs/176606");
            System.out.println("Yay! I've also been to this destination. Check out my blog :) " + myBlog.getText());
            Assert.assertEquals(myBlog.getText(),  "הבלוג של sivanki");


        }
    }

    //constructor
    public BlogsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
