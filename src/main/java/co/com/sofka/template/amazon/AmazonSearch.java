package co.com.sofka.template.amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearch {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    public void searchItem(String item) {
        searchInput.sendKeys(item, Keys.ENTER);
    }
}
