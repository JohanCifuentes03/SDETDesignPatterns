package co.com.sofka.strategy.emiratesexercise.pages;

import co.com.sofka.strategy.emiratesexercise.components.Calendar;
import co.com.sofka.strategy.emiratesexercise.components.Cookies;
import co.com.sofka.strategy.emiratesexercise.components.SearchFlight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmiratesPage {
    private WebDriver driver;
    private SearchFlight searchFlight;
    private Cookies cookies;
    private Calendar calendar;

    public EmiratesPage(WebDriver driver) {
        this.driver = driver;
        this.searchFlight = PageFactory.initElements(driver, SearchFlight.class);
        this.cookies = PageFactory.initElements(driver, Cookies.class);
        this.calendar = PageFactory.initElements(driver, Calendar.class);
    }

    public void goTo() {
        this.driver.get("https://www.emirates.com/english/");
    }


    public void acceptCookies() {
        this.cookies.acceptCookies();
    }

    public void searchDepartureAirportByIndex(int index) {
        this.searchFlight.openDepartureAirportOptions();
        searchFlight.isDisplayed();
        this.searchFlight.selectDepartureAirportByIndex(index);

    }

    public void searchArrivalAirportByIndex(int index) {
        this.searchFlight.openArrivalAirportOptions();
        searchFlight.isDisplayed();
        this.searchFlight.selectArrivalAirportByIndex(index);
        calendar.isDisplayed();
    }

    public void submit() {
        this.searchFlight.submit();
    }

    public void searchDate(String month, int day) {
        calendar.selectDate(month, day);
    }
}
