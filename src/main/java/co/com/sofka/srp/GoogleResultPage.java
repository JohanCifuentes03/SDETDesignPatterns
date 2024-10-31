package co.com.sofka.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
