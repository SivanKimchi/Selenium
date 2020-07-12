package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @FindBy (xpath = "//*[text()='המלצות המערכת']")
    public WebElement systemSuggestions;

    @FindBy (css = "div[id='app'] div main article:nth-child(6) div div article")
    public List<WebElement> suggestedBlogPosts;

    @FindBy (xpath = "//*[text()='פוסטים מתוך הבלוגים של למטייל']")
    public WebElement postsFromBlogs;


    //REGULAR EXPRRESSION
    @FindBy (css = "div[id='app'] div main article:nth-child(7) article[class*='post-card']")   //should be 30
    public List<WebElement> recentBlogPosts;

    @FindBy (css = "div[id='results-container'] article[class*='post-card']")
    public List<WebElement> nextPageBlogPosts;

    @FindBy (css = "li[class='page-item'] a")
    public WebElement nextSectionOfBlogPostsButton;

    @FindBy (css = "div:nth-of-type(1) main section:nth-of-type(1) div:nth-of-type(2) h2")
    public WebElement blogPostsHeader;

    @FindBy (css = "section[class='mb-10'] div:nth-of-type(2) label input")
    public  WebElement searchBlogFreeText;

    @FindBy (css = "div[id='results-container'] article")   //size:2
    public List<WebElement> myBlogIcelandPosts;

    @FindBy (css = "[id='app'] section div h1")
    public WebElement myBlog;

    @FindBy (xpath = "//button[contains(text(), 'דלג לאתר')]")
    public WebElement skipToPageButton;

    @FindBy (id="blog_permissions")
    public WebElement blogPermissions;

    @FindBy (xpath = "//*[@id='blog_permissions']/label[2]/div/ins")
    public WebElement makeBlogPostPrivate;

    @FindBy (xpath = "//*[@id='blog_permissions']/label[2]/div")
    public WebElement blogPermissionsPrivateDiv;




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


    public void scrollDown(WebElement waitForVisibilityOf){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



    }


    public void suggestedBlogs(){
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.centralBar));
        homePage.mainMenuBlogs.click();
        wait.until(ExpectedConditions.visibilityOf(systemSuggestions));
        scrollDown(systemSuggestions);
        Assert.assertEquals(suggestedBlogPosts.size(), 9);
        System.out.println("There are default " + suggestedBlogPosts.size() + " suggested blog posts");

        scrollDown(postsFromBlogs);
        Assert.assertEquals(recentBlogPosts.size(), 30);      //should be 30
        System.out.println("There are default " + recentBlogPosts.size() + " recent posts from blogs");

        scrollDown(nextSectionOfBlogPostsButton);
        nextSectionOfBlogPostsButton.click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(nextPageBlogPosts.size(), 30);      //should be 30
        System.out.println("The number of blog posts in the next page is also " + nextPageBlogPosts.size());

    }


    //constructor
    public BlogsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
