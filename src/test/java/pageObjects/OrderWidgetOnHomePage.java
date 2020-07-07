package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy (css = "button[class='mdc-button h-6 text-base font-semibold tracking-normal font-normal mdc-button__white'] div[class='flex items-center text-black']")
    public WebElement flightsNumberOfPassengers;

    @FindBy (css = "div[id='my-dialog-content']")
    public WebElement flightsNumberOfPassengersBox;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(1) span[class='icon icon-add']")
    public WebElement flightsAddAdult;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(1) span[class='icon icon-remove']")
    public WebElement flightsRemoveAdult;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(1) div:nth-child(2) span")
    public WebElement flightsSelectedNumOfAdultS;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(2) span[class='icon icon-add']")
    public WebElement flightsAddPensioner;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(2) span[class='icon icon-remove']")
    public WebElement flightsRemovePensioner;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(2) div:nth-child(2) span")
    public WebElement flightsSelectedNumOfPensioners;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(3) span[class='icon icon-add']")
    public WebElement flightsAddChild;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(3) span[class='icon icon-remove']")
    public WebElement flightsRemoveChild;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(3) div:nth-child(2) span")
    public WebElement flightsSelectedNumOfChildren;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(4) span[class='icon icon-add']")
    public WebElement flightsAddInfant;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(4) span[class='icon icon-remove']")
    public WebElement flightsRemoveInfant;

    @FindBy (css = "div[id='my-dialog-content'] div div:nth-child(4) div:nth-child(2) span")
    public WebElement flightsSelectedNumOfInfants;

    @FindBy (css = "footer[class='mdc-dialog__actions'] button[class='btn btn-primary']")
    public WebElement flightsApprovePassengers;

    @FindBy (css = "footer[class='mdc-dialog__actions'] button[class='btn text-grey-dark font-semibold']")
    public WebElement flightsCancelChangesInPassengers;

    @FindBy (css = "input[id='direct-only']")
    public WebElement flightsDirectIfChecked;

    @FindBy (css = "div[class='flex md:flex-no-grow h-full md:ml-px'] div:nth-of-type(1)")
    public WebElement flightsFrom;

    @FindBy (css = "div[class='mdc-list-group']")
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
    public WebElement flightsCalenderDisabledDate;

    @FindBy (css = "div[class='asd__month-name']")
    public WebElement flightsCalendarMonth;

    @FindBy (css = "div[class='asd__change-month-button asd__change-month-button--previous']")
    public WebElement flightsCalenderMoveToPreviousMonth;

    @FindBy (css = "div[class='asd__change-month-button asd__change-month-button--next']")
    public WebElement flightsCalenderMoveToNextMonth;

    @FindBy (css = "button[class='asd__mobile-close']")
    public WebElement flightsCalenderClose;

    @FindBy (className = "asd__day-button")
    public List<WebElement> dates;

    @FindBy (css = "button[id='flights-search-button']")
    public WebElement flightsSearchButton;



    //pick specific flight date
    public void pickAMonthToFly (String month, String day){
        while (!flightsCalendarMonth.getText().contains(month)){
                flightsCalenderMoveToNextMonth.click();
        }
        for (int i=0; i<dates.size(); i++) {
            String text = dates.get(i).getText();
            if (text.equals(day)){
                dates.get(i).click();
                break;
            }
        }
    }




    //constructor
    public OrderWidgetOnHomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
