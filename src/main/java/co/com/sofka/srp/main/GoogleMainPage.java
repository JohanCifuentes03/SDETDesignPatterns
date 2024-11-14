package co.com.sofka.srp.main;

import co.com.sofka.srp.common.SearchSuggestion;
import co.com.sofka.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    private final WebDriver driver;
    private final SearchWidget searchWidget;
    private final SearchSuggestion searchSuggestion;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo() {
        this.driver.get("https://google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
