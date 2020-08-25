package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AttractionsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(), 'דלג לאתר')]")
    public WebElement skipToPageButton;

    @FindBy (css="svg[id='Layer_1']")
    public WebElement closePopUp;


    @FindBy (css = "button[class='close-popover']")
    public WebElement closePopUp2;

    @FindBy (css = "input[id='citySearch_search']")
    public WebElement searchAttractionDestination;

    @FindBy (css = "ul[class='cityList'] li")
    public List<WebElement> attractionsDestinationsList;

    @FindBy (css = "div[id='vendor_usp'] h2")
    public WebElement attractionCityHeadline;





    public static Logger log = LogManager.getLogger(AttractionsPage.class.getName());


    //constructor
    public AttractionsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void scroll(WebElement waitForVisibilityOf) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", waitForVisibilityOf);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log.debug("Scrolled to element");
    }

    //works for 2 or MORE windows
    public void moveToNextTab() {

        String parentId = driver.getWindowHandle();
        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String childWindow= "";

        while (it.hasNext()){
            childWindow = it.next();
        }
        driver.switchTo().window(childWindow);
        log.info("Switched to next window handle");
    }


    public void skipAd() {
        try {
            skipToPageButton.click();
            log.debug("Skipped ad page");
        } catch (Exception e) {
            log.error("No ad page was skipped");
        }
    }


    public void searchAttractionDestinationCity(String destinationCity) {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        try{

            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            closePopUp.click();
            closePopUp2.click();

        } catch (Exception a) {
            log.debug("There is no pop-up");
        }


        wait.until(ExpectedConditions.visibilityOf(searchAttractionDestination));

        int destinationSize = attractionsDestinationsList.size();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //get index of searched city
        int index = 0;
        for (WebElement destination : attractionsDestinationsList) {
            if (destination.getAttribute("data-city").equals(destinationCity)){
                index = attractionsDestinationsList.indexOf(destination);
            }
        }
        log.debug("Saved index of searched city: " + index);

        searchAttractionDestination.sendKeys(destinationCity);
        log.debug("Inserted city destination");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        try {

                Assert.assertTrue(attractionsDestinationsList.get(index).isDisplayed());
                Assert.assertEquals(attractionsDestinationsList.get(index).getAttribute("data-city"), destinationCity);
                Assert.assertEquals(attractionsDestinationsList.get(index).getText(), destinationCity);

                log.debug("Requested city appears in search results without submitting search term (only inserting in search bar)");

                searchAttractionDestination.sendKeys(Keys.ENTER);
                log.debug("Submitted search");
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

                int newResultsSize= attractionsDestinationsList.size();
                Assert.assertTrue(newResultsSize == destinationSize);
                log.debug("After search, search results are as default - ALL DESTINATIONS, and not according to search. Bug in Lametayel website...");

        } catch(Exception e){
                log.error("Destination city does not exist");
            }

    }




    public void searchAttractionDestinationCountry(String destinationCountry){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchAttractionDestination));

        searchAttractionDestination.sendKeys(destinationCountry);
        log.debug("Inserted country destination");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        try {
            int index=-1;
            for (WebElement destination : attractionsDestinationsList) {
                if (destination.getAttribute("data-city").equals(destinationCountry)) {
                    index = attractionsDestinationsList.indexOf(destination);
                }
            }

            Assert.assertTrue(index==-1);   //index did not change because previous condition wasn't applied
            log.debug("Destination COUNTRY does not appear in search results, search for attractions is by CITY");
        } catch (Exception e) {
            log.error("Destination COUNTRY does appear in search results?");
        }

    }


    public void pickAttractionCity (String destinationCity) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchAttractionDestination));

        List<String> destinations = new ArrayList<String>();
        WebElement clickThisCity = null;
        for (WebElement destination : attractionsDestinationsList) {
                String destinationText = destination.getText();
                if (!destinationText.isEmpty()){
                    destinations.add(destinationText);
                    if (destinationText.equals(destinationCity)){
                        clickThisCity = destination;
                    }
                }
        }

        System.out.println("destinations: "+ destinations);
        String message = "Visible Destinations for attractions: ";
        for (String string : destinations ) {
            message = message + " ," + string;
           
        }
        log.info(message);

        clickThisCity.click();
        log.debug("Clicked city: " + destinationCity);

        wait.until(ExpectedConditions.visibilityOf(attractionCityHeadline));
        Assert.assertTrue(attractionCityHeadline.getText().contains(destinationCity));
        log.info("Entered page for attractions in selected city");

    }






}


