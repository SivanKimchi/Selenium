package myTests;

import Lametayel.GeneralProperties;
import Lametayel.ScreenshotTaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AttractionsPage;
import pageObjects.BlogsPage;

public class AttractionsTest {


    //members
    private static WebDriver driver;

    public static Logger log = LogManager.getLogger(AttractionsTest.class.getName());



    @Before
    public void setUp(){

        System.setProperty(GeneralProperties.driverName, GeneralProperties.driverLocation);
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(GeneralProperties.SiteURLAttractions);   //goes straight to attractions page, otherwise scroll down to footer
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
//            if (driver != null)
//                driver.quit();
        }
    };


//    @After
//    public void closeTest(){
//        driver.quit();
//    }




    @Test
    public void searchDestinationForAttractions(){
        AttractionsPage attractions = new AttractionsPage(driver);

        driver.switchTo().frame(0);
        log.info("Switched to attractions iframe");

        attractions.searchAttractionDestinationCity("רומא");
        attractions.searchAttractionDestinationCountry("איטליה");

        log.info("Finished test- search for attractions by city or country");

    }



    @Test
    public void pickAttractionsDestinationFromList(){
        AttractionsPage attractions = new AttractionsPage(driver);
        driver.switchTo().frame(0);
        log.info("Switched to attractions iframe");

        attractions.pickAttractionCity("ליסבון");
        log.info("Finished test- pick destination for attractions from list");

    }


    @Test
    public void pickAttractionType(){

        AttractionsPage attractions = new AttractionsPage(driver);
        driver.switchTo().frame(0);
        log.info("Switched to attractions iframe");

        attractions.pickAttractionType("פורטו", "סיורים");
    }


}
