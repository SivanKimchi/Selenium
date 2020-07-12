package myTests;

import Lametayel.GeneralProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BlogsPage;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

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

//    @After
//    public void closeTest(){
//        driver.close();
//    }


    @Test
    public void searchBlog() throws InterruptedException {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.searchBlogPost("נורווגיה");

    }

    @Test
    public void blogSuggestions() {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.suggestedBlogs();
    }



    @Test
    public void checkForMandatoryBlogAttributes(){


    }



    @Test
    public void createABlogPost(){
          //with logged-in user






        //with user that is not logged in




    }



}
