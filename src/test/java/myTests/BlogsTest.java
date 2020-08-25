package myTests;
import Lametayel.ScreenshotTaker;
import Lametayel.GeneralProperties;    //uses JsonValues.json -- gitignore (template available)
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BlogsPage;
import pageObjects.HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlogsTest {


    //members
    private static WebDriver driver;

    public static Logger log = LogManager.getLogger(BlogsTest.class.getName());


    @Before
    public void setUp(){

        System.setProperty(GeneralProperties.driverName, GeneralProperties.driverLocation);
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(GeneralProperties.SiteURL1);
        log.info("Opened driver");

    }



    @Rule      //screenshot taken when test fails
    public TestRule testWatcher = new TestWatcher() {

        @Override
        public void failed(Throwable e, Description test) {
            ScreenshotTaker screenshotTaker = new ScreenshotTaker(driver);
            screenshotTaker.failed(e, test);

        }

        @Override
        protected void finished(Description description) {
            System.out.println("Logged test data to testLogs.log using log4j");
            if (driver != null)
                driver.quit();
        }
    };


//    @After
//    public void closeTest(){
//        driver.quit();
//    }




    @Test
    public void searchBlog() throws InterruptedException {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.searchBlogPost("איסלנד");
        log.info("Finished blog search successfully");

    }

    @Test
    public void blogSuggestions() {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.suggestedBlogs();
        log.info("Finished validating suggested blogs successfully");
    }



    @Test
    public void createABlogPost() throws InterruptedException, IOException {
          //with logged-in user

        BlogsPage blogs = new BlogsPage(driver);
        blogs.createABlogPost("יומן מסע", "איזה כיף בחו\"ל", "אירלנד");
        log.info("Finished creating and deleting a blog successfully");
    }


    @Test
    public void exampleToBlogContentFromExcel() throws InterruptedException, IOException {

        BlogsPage blogs = new BlogsPage(driver);
        HomePage homePage = new HomePage(driver);
        //log in to write blog post
        homePage.logInButton.click();
        homePage.logIntoSite();
        blogs.skipAd();
        homePage.userMenu.click();
        homePage.userMenuAddNewBlogPost.click();
        blogs.skipAd();

        // make post private
        blogs.makePostPrivate();

        //post content from EXCEL
        blogs.scroll(blogs.postHeadline);

        ArrayList[] excelData = blogs.addContentFromExcel(GeneralProperties.blogExcelFilePath, "postContent.xlsx", "Sheet1");
        ArrayList<String> headers = excelData[0];
        ArrayList<String> contents = excelData[1];

        blogs.postHeadline.sendKeys(headers.get(4));   //change of index relevant to headlineNumber
        log.debug("Inserted header - " + headers.get(4));
        blogs.postContent.sendKeys(contents.get(4));   //change of index relevant to headlineNumber
        log.debug("Inserted content - " + contents.get(4));
        Thread.sleep(3000);

        //must publish (private) blog post to check input from excel
        blogs.scroll(blogs.addDestinationTag);
        blogs.insertOneDestinationTag("ספרד");
        blogs.scroll(blogs.saveBlogPostButton);
        Thread.sleep(5000);
        blogs.saveBlogPostButton.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        int headlineNumber = 4+1;   // (index+1  "Post number 5")

        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(blogs.blogCreatedAlert)));
        } catch (Exception e) {   //unkown error in submitting post
            blogs.lametayelLogo.click();
            homePage.userMenu.click();
            homePage.userMenuMyBlog.click();
            driver.findElement(By.xpath("//*[@id='app']/section[4]/main/div[3]/a")).click();
            blogs.myFirstDrafts.click();

        }

        Assert.assertTrue(blogs.postHeadline.getAttribute("value").contains(Integer.toString(headlineNumber)));
        Assert.assertTrue(blogs.postContent.getText().contains("It was so much fun in"));
        Thread.sleep(5000);
        blogs.deletePost();

        log.info("Inserted data from Excel Successfully");

    }


    @Test
    public void createABlogFromBlogsPage() throws InterruptedException {

        // if user is signed in

//        HomePage homePage = new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//        homePage.logInButton.click();
//        homePage.logIntoSite();
//        Thread.sleep(3000);

        BlogsPage blogs = new BlogsPage(driver);
        blogs.createANewBlogFromBlogsPage();
        log.info("Successfully entered blog creation from blogs page");
    }



    @Test
    public void invalidBlogPost() throws InterruptedException {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.createInvalidBlogPost("", "הבלוג שלי", "", "בא לי חו\"ל", "אירלנד");
        log.info("Successfully validated creating new blog post");
    }




    @Test
    public void checkForMandatoryBlogAttributes() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);
        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();
        log.debug("Navigated to blog post");

        blogs.checkForMandatoryBlogAttributes("הבלוג של sivanki");
        log.info("Successfully validated mandatory blog attributes");
    }



    @Test     // ** interaction: print doesn't work , views-there is no way to test number being changed , comments-I don't want to comment on my posts

    public void followBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();
        log.debug("Navigated to blog post");

        blogs.followBlog();
        log.info("Successfully validated 'follow' on blog posts");
    }


    @Test
    public void saveBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();
        log.debug("Navigated to blog post");

        blogs.savePost();
        log.info("Successfully validated 'save for later' on blog posts");
    }


    @Test
    public void shareBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();
        log.debug("Navigated to blog post");

        blogs.sharePost();
        log.info("Successfully validated 'share' on blog posts");
    }


    @Test
    public void likeBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();
        log.debug("Navigated to blog post");

        blogs.likePost();
        log.info("Successfully validated 'like' on blog posts");
    }



}
