package co.com.sofka.template.amazon;

import co.com.sofka.template.ShoppingTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonShopping extends ShoppingTemplate {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final AmazonSearch search;
    private final AmazonResults result;

    public AmazonShopping(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.search = PageFactory.initElements(driver, AmazonSearch.class);
        this.result = PageFactory.initElements(driver, AmazonResults.class);
    }


    @Override
    public void launchSite() {
        this.driver.get("https://www.amazon.com/");
    }

    @Override
    public void searchProduct(String product) {
        this.search.searchItem(product);
    }

    @Override
    public void selectProduct() {
        wait.until(d -> !result.results.isEmpty());
        result.selectResult(0);
    }

    @Override
    public void buy() {
    }
}
