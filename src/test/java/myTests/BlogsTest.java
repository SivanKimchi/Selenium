package myTests;

import Lametayel.ScreenshotTaker;
import Lametayel.GeneralProperties;   //gitignore
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BlogsPage;

public class BlogsTest {


    //members
    private static WebDriver driver;


    @Before
    public void setUp(){

        System.setProperty(GeneralProperties.driverName, GeneralProperties.driverLocation);
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(GeneralProperties.SiteURL1);

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

    }

    @Test
    public void blogSuggestions() {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.suggestedBlogs();
    }



    @Test
    public void createABlogPost() throws InterruptedException {
          //with logged-in user

        BlogsPage blogs = new BlogsPage(driver);
        blogs.createABlogPost("יומן מסע", "איזה כיף בחו\"ל", "אירלנד");

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

    }



    @Test
    public void invalidBlogPost() throws InterruptedException {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.createInvalidBlogPost("", "הבלוג שלי", "", "בא לי חו\"ל", "אירלנד");
    }




    @Test
    public void checkForMandatoryBlogAttributes() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);
        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();

        blogs.checkForMandatoryBlogAttributes("הבלוג של sivanki");
    }



    @Test     // ** interaction: print doesn't work , views-there is no way to test number being changed , comments-I don't want to comment on my posts

    public void followBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();

        blogs.followBlog();

    }


    @Test
    public void saveBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();

        blogs.savePost();

    }


    @Test
    public void shareBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();

        blogs.sharePost();

    }


    @Test
    public void likeBlogPost() throws InterruptedException {

        BlogsPage blogs = new BlogsPage(driver);

        blogs.searchBlog("נורווגיה");
        blogs.searchBlogFreeText.sendKeys("נורווגיה, ספטמבר 2018", Keys.ENTER);
        driver.navigate().refresh();
        blogs.myBlogPosts.get(1).click();

        blogs.likePost();

    }



}
