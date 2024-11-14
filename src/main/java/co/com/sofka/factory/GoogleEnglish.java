package co.com.sofka.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "a h3")
    private List<WebElement> results;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        searchBox.clear();
        for (char c: keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(c + "");
        }
        this.wait.until(d -> searchBtn.isDisplayed());
        searchBtn.click();
    }

    @Override
    public int getResultsCount() {
        wait.until(d -> results.size() > 1);
        return results.size();
    }
}
