package co.com.sofka.strategy.emiratesexercise.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cookies extends AbstractComponent {
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptButton;

    @FindBy(id = "onetrust-banner-sdk")
    private WebElement cookiesBanner;

    public Cookies(WebDriver driver){
        super(driver);
    }

    public void acceptCookies(){
        wait.until(d -> this.acceptButton.isDisplayed());
        this.acceptButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> cookiesBanner.isDisplayed());
    }
}
