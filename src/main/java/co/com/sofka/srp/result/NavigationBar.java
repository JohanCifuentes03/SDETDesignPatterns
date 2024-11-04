package co.com.sofka.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {
    @FindBy(id = "bqHHPb")
    private WebElement bar;

    @FindBy(linkText = "Imágenes")
    private WebElement images;

    @FindBy(linkText = "Noticias")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages() {
        this.images.click();
    }

    public void goToNews() {
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(drive -> this.bar.isDisplayed());
    }
}
