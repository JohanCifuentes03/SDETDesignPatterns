package co.com.sofka.strategy.emiratesexercise.pages;

import co.com.sofka.strategy.emiratesexercise.components.Cookies;
import co.com.sofka.strategy.emiratesexercise.components.SearchFlight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmiratesPage {
    private WebDriver driver;
    private SearchFlight searchFlight;
    private Cookies cookies;

    public EmiratesPage(WebDriver driver) {
        this.driver = driver;
        this.searchFlight = PageFactory.initElements(driver, SearchFlight.class);
        this.cookies = PageFactory.initElements(driver, Cookies.class);
    }

    public void goTo(){
        this.driver.get("https://www.emirates.com/english/");
    }

    public SearchFlight getSearchFlight() {
        return searchFlight;
    }

    public Cookies getCookies() {
        return cookies;
    }
}
