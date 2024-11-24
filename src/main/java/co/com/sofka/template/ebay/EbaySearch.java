package co.com.sofka.template.ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbaySearch {
    @FindBy(css = "input[type=text]")
    protected WebElement searchInput;

    @FindBy(css = "input[type=submit]")
    protected WebElement searchBtn;

    public void searchItem(String item) {
        this.searchInput.sendKeys(item);
        this.searchBtn.click();
    }
}
