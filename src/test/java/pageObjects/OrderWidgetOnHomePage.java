package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OrderWidgetOnHomePage {


    //members
    private WebDriver driver;

    @FindBy (css = "section[class='market-widget relative homepage-widget shadow-lg']")
    public WebElement orderWidget;

    @FindBy (id = "swiper-1594065332666")
    public WebElement orderWidgetBar;

    @FindBy (css = "div[id='swiper-1594065332666'] ul li:nth-child(1)")
    public WebElement orderWidgetFlights;

    @FindBy (css = "div[id='swiper-1594065332666'] ul li:nth-child(2)")
    public WebElement orderWidgetHotels;

    @FindBy (css = "div[id='swiper-1594065332666'] ul li:nth-child(3)")
    public WebElement orderWidgetInsurance;

    @FindBy (css = "div[id='swiper-1594065332666'] ul li:nth-child(4)")
    public WebElement orderWidgetCar;

    @FindBy (css = "div[id='swiper-1594065332666'] ul li:nth-child(5)")
    public WebElement orderWidgetStores;

    @FindBy (css = "div[class='mdc-menu-surface--anchor inline-flex'] button")
    public WebElement flightsDirection;


    @FindBy (css = "iframe[class='w-full mx-auto bg-transparent h-full absolute pin overflow-hidden z-10 iframe-with-loader']")
    public WebElement flightsiframe;

    @FindBy (css = "div[id='fly-app']")
    public WebElement orderWidgetFlightsApp;

    @FindBy (css = "ul[class='mdc-list']")
    public WebElement flightsDirectionChoices;

    @FindBy (css = "ul[class='mdc-list'] li:nth-child(1)")
    public WebElement flightsDirectionFirstChoice;

    @FindBy (css = "ul[class='mdc-list'] li:nth-child(2)")
    public WebElement flightsDirectionSecondChoice;

    @FindBy (xpath = "//*[@id=\"fly-app\"]/div/article/div/div/div[1]/button/div")
    public WebElement flightsNumberOfPassengers;

    @FindBy (css = "div[id='my-dialog-content']")
    public WebElement flightsNumberOfPassengersBox;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(1) span[class='icon icon-add']")
    public WebElement flightsAddAdult;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(1) span[class='icon icon-remove']")
    public WebElement flightsRemoveAdult;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(1) div:nth-child(2)")
    public WebElement flightsSelectedNumOfAdultS;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(2) div:nth-child(2) span[class='icon icon-add']")
    public WebElement flightsAddPensioner;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(2) div:nth-child(2) span[class='icon icon-remove']")
    public WebElement flightsRemovePensioner;


    @FindBy (xpath = "//*[@id='my-dialog-content']/div/div[2]/div[2]/span")
    public WebElement flightsSelectedNumOfPensioners;


    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(3) div:nth-child(2) span[class='icon icon-add']")
    public WebElement flightsAddChild;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(3) div:nth-child(2) span[class='icon icon-remove']")
    public WebElement flightsRemoveChild;

    @FindBy (xpath = "//*[@id='my-dialog-content']/div/div[3]/div[2]/span")
    public WebElement flightsSelectedNumOfChildren;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(4) div:nth-child(2) span[class='icon icon-add']")
    public WebElement flightsAddInfant;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(4) div:nth-child(2) span[class='icon icon-remove']")
    public WebElement flightsRemoveInfant;

    @FindBy (xpath = "//*[@id='my-dialog-content']/div/div[4]/div[2]/span")
    public WebElement flightsSelectedNumOfInfants;

    @FindBy (css = "footer[class='mdc-dialog__actions'] button[class='btn btn-primary']")
    public WebElement flightsApprovePassengers;

    @FindBy (css = "footer[class='mdc-dialog__actions'] button[class='btn text-grey-dark font-semibold']")
    public WebElement flightsCancelChangesInPassengers;

    @FindBy (css = "div[class='passengers etField flight-pax js__pax_display-container']")
    public WebElement flightsPageNumOfPassengers;



    @FindBy (css = "input[id='direct-only']")
    public WebElement flightsDirectIfChecked;

    @FindBy (css = "div[class='stops-buttons'] div:nth-child(1)")
    public WebElement directFlightSelected;

    @FindBy (css = "div[class='stops-buttons'] div:nth-child(3)")
    public WebElement nondirectFlightSelected;

    @FindBy (css = "div[class='filters-title float-left']")
    public WebElement flightsPageFilterBar;

    @FindBy (css = "div[class='flex md:flex-no-grow h-full md:ml-px'] div:nth-of-type(1)")
    public WebElement flightsFrom;

    @FindBy (xpath = "//*[@id=\"fly-app\"]/div/article/div/div/div[2]/div[1]/div[1]/div[1]/div[2]/ul/div/li/input")
    public WebElement flightsFrom_InputBox;

    @FindBy (css = "div[class='flex md:flex-no-grow h-full md:ml-px']")
    public WebElement flightsTo;

    @FindBy (xpath = "//*[@id=\"fly-app\"]/div/article/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/ul/div[1]/li/input")
    public WebElement flightsTo_InputBox;


    @FindBy (css = "div[id='datepicker-trigger'] div div:nth-child(1)")
    public WebElement flightsDatesOneWay;

    @FindBy (css = "div[id='datepicker-trigger'] div div:nth-child(2)")
    public WebElement flightsDatesReturn;


    @FindBy (css = "td[class='asd__day asd__day--enabled asd__day--selected asd__selected-date-one']")
    public WebElement flightsCalenderPickedDate;    //if class="asd__day asd__day--enabled asd__day--selected asd__selected-date-one"  it is the selected date


    @FindBy (css = "td[class='asd__day asd__day--enabled asd__day--selected asd__selected-date-two']")
    public WebElement flightsCalenderPickedReturnDate;    //if class="asd__day asd__day--enabled asd__day--selected asd__selected-date-two"  it is the selected RETURN date

    @FindBy (css = "td[class='asd__day asd__day--enabled asd__day--in-range']")
    public WebElement flightsCalenderPickedRange;  //range of return vacation

    @FindBy (css = "td[class='asd__day asd__day--enabled asd__day--disabled']")
    public List<WebElement> flightsCalenderDisabledDate;

    @FindBy (css = "div[class='asd__inner-wrapper'] div:nth-of-type(2) div")
    public WebElement flightsCalendarMonth;

    @FindBy (id="search_engine_search_engine_flight_outbound_date")
    public WebElement flightsPageOutboundDate;

    @FindBy (id="search_engine_search_engine_flight_inbound_date")
    public WebElement flightsPageInboundDate;

    @FindBy (id="search_engine_search_engine_flight_outbound_airport")
    public WebElement flightsPageOutboundCity;

    @FindBy (id="search_engine_search_engine_flight_inbound_airport")
    public WebElement flightsPageInboundCity;


    @FindBy (css = "div[class='asd__change-month-button asd__change-month-button--previous']")
    public WebElement flightsCalenderMoveToPreviousMonth;

    @FindBy (css = "div[class='asd__change-month-button asd__change-month-button--next']")
    public WebElement flightsCalenderMoveToNextMonth;

    @FindBy (css = "button[class='asd__mobile-close'] div:")
    public WebElement flightsCalenderClose;

    @FindBy (css = "table[class='asd__month-table'] button[class='asd__day-button']")
    public List<WebElement> dates;

    @FindBy (css = "button[id='flights-search-button']")
    public WebElement flightsSearchButton;



    //choose destination
    public void pickDestination (String destination) throws InterruptedException {
        flightsTo.click();
        flightsTo_InputBox.clear();
        Thread.sleep(3000);
        flightsTo_InputBox.sendKeys(destination);
        Thread.sleep(3000);
        flightsTo_InputBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }


    public void pickOutboundCity (String city) throws InterruptedException {
        flightsFrom.click();
        flightsFrom_InputBox.clear();
        Thread.sleep(3000);
        flightsFrom_InputBox.sendKeys(city);
        Thread.sleep(3000);
        flightsFrom_InputBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }


    //pick specific flight date
    public void pickADateToFly (String month, String day) {

        String visibleMonth = flightsCalendarMonth.getText();

        while (!visibleMonth.contains(month)){
                flightsCalenderMoveToNextMonth.click();

                WebDriverWait wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.visibilityOf(flightsCalendarMonth));

                visibleMonth = flightsCalendarMonth.getText();
        }



        for (int i=0; i<dates.size(); i++) {
            String text = dates.get(i).getText();
            if (text.equals(day)){
                dates.get(i).click();
                break;
            }
        }
    }


    // *** same method as the next method - pastDateIsInvalid() - using Calendar ***
    public void dontAllowPastDates(String month, int day) throws ParseException {

        String visibleMonth = flightsCalendarMonth.getText();

        if (visibleMonth.contains(month)) {

            Date pdate = new Date();
            Calendar lCal = Calendar.getInstance();
            lCal.setTime(pdate);
            int today = lCal.get(Calendar.DATE);

            String dayString = String.valueOf(day);

            for (int i = 0; i < dates.size(); i++) {
                String text = dates.get(i).getText();
                if (text.equals(dayString) && today > day) {  // day is smaller or before today's day){
                    System.out.println("invalid date");
                    Assert.assertFalse(dates.get(i).getAttribute("class").contains("--selected"));
                } else if (text.equals(dayString)) {
                    System.out.println("valid date");
                }

            }
        }
    }




        public void pastDateIsInvalid(String month, int day) {

            String visibleMonth = flightsCalendarMonth.getText();

            if (visibleMonth.contains(month)){

                String dayString = String.valueOf(day);

                SimpleDateFormat viewedDateSDF = new SimpleDateFormat("yyyy-MM-dd");
                Date todayDate = new Date();
                String todayDateString = viewedDateSDF.format(todayDate);
                Date todayDateFormatted = null;

                try {
                    todayDateFormatted = viewedDateSDF.parse(todayDateString);    // Today's date in DATE type, formatted
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < dates.size(); i++) {

                    String viewedDate = dates.get(i).getAttribute("date");

                    try {

                        Date viewedDateDateType = viewedDateSDF.parse(viewedDate);   // Date picked on website, DATE type, formatted

                        if ((dates.get(i).getText().equals(dayString)) && todayDateFormatted.after(viewedDateDateType)) {
                            System.out.println("invalid date- " + viewedDateDateType);
                            Assert.assertFalse(dates.get(i).getAttribute("class").contains("--selected"));
                        } else if (dates.get(i).getText().equals(dayString)) {
                            dates.get(i).click();
                            System.out.println("valid date");
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }
        }  else {
                System.out.println("This is probably a future month, so it is irrelevant to the test.");
            }
    }





    public void dateInPastMonthInvalid (String pastMonthYear) {

        String visibleMonth = flightsCalendarMonth.getText();

        while (!visibleMonth.equals(pastMonthYear)){
            flightsCalenderMoveToPreviousMonth.click();

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(flightsCalendarMonth));

            visibleMonth = flightsCalendarMonth.getText();
        }

            for (int i = 0; i < dates.size(); i++) {

                Assert.assertFalse(dates.get(i).getAttribute("class").contains("--selected"));

            }
        }



    public void flightsMultiplePassengers() throws InterruptedException {
        flightsNumberOfPassengers.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(flightsNumberOfPassengersBox));

        Assert.assertTrue(flightsSelectedNumOfAdultS.getText().equals("1"));
        flightsAddAdult.click();
        Thread.sleep(3000);
        flightsRemoveAdult.click();   //num of adults = 1
        Assert.assertTrue(flightsSelectedNumOfPensioners.getText().equals("0"));
        flightsAddPensioner.click();
        flightsAddPensioner.click();
        flightsAddPensioner.click();
        flightsRemovePensioner.click();   //num of pensioners = 2
        Assert.assertTrue(flightsSelectedNumOfChildren.getText().equals("0"));
        flightsAddChild.click();
        flightsAddChild.click();
        flightsRemoveChild.click();   //num of children = 1
        Assert.assertTrue(flightsSelectedNumOfInfants.getText().equals("0"));
        flightsAddInfant.click();
        flightsAddInfant.click();
        flightsAddInfant.click();
        flightsRemoveInfant.click();   //num of infants = 2
        flightsApprovePassengers.click();
        Assert.assertTrue(flightsNumberOfPassengers.getText().contains("6"));


    }




    public void moveToNextTab(){

        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

    }




    //constructor
    public OrderWidgetOnHomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
