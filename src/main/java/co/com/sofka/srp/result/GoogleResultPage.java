package co.com.sofka.srp.result;

import co.com.sofka.srp.common.SearchSuggestion;
import co.com.sofka.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {
    private final SearchSuggestion searchSuggestion;
    private final NavigationBar navigationBar;
    private final SearchWidget searchWidget;

    public GoogleResultPage(WebDriver driver) {
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
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
