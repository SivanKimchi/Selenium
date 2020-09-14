package myTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BlogsPage;


import java.io.IOException;


public class testForJenkinsTest {


    private static WebDriver driver;

    public static Logger log = LogManager.getLogger(SanityTest.class.getName());


    @Before
    public void setUp() throws IOException, ParseException {


        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("www.lametayel.co.il");
        log.info("Opened driver");
    }


    @After
    public void quitTest() {
        driver.quit();
    }


    @Test
    public void searchBlog() throws InterruptedException {
        BlogsPage blogs = new BlogsPage(driver);
        blogs.searchBlogPost("איסלנד");
        log.info("Finished blog search successfully");

    }
}
