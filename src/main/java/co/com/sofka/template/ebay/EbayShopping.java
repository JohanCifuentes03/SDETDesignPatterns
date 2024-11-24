package co.com.sofka.template.ebay;

import co.com.sofka.template.ShoppingTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EbayShopping extends ShoppingTemplate {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final EbaySearch search;
    private final EbayResults results;

    public EbayShopping(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.search = PageFactory.initElements(driver, EbaySearch.class);
        this.results = PageFactory.initElements(driver, EbayResults.class);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com/");
    }

    @Override
    public void searchProduct(String product) {
        this.search.searchItem(product);
    }

    @Override
    public void selectProduct() {
        wait.until(d -> !this.results.results.isEmpty());
        this.results.selectResult(0);
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
    }

    @Override
    public void buy() {
        wait.until(d -> results.price.isDisplayed());
        System.out.println(this.results.getPrice());
    }
}
