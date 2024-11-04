package co.com.sofka.srp.main;

import co.com.sofka.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {
    @FindBy(name = "q")
    private WebElement searchBar;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBar.clear();
        for (char ch : keyword.toCharArray()){
            this.searchBar.sendKeys(ch + "");
        }

    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> searchBar.isDisplayed());
    }
}
