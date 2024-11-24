package co.com.sofka.template.ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EbayResults {
    @FindBy(css = "li[id*=item] .s-item__title span")
    protected List<WebElement> results;

    @FindBy(css = ".x-price-primary span")
    protected WebElement price;

    public void selectResult(int index) {
        this.results.get(index).click();
    }

    public String getPrice() {
        return this.price.getText();
    }
}
