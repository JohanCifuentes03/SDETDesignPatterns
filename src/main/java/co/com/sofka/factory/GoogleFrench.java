package co.com.sofka.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish{
    @FindBy(css = "div#SlvCob a:nth(1)")
    private WebElement language;

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr");
        this.wait.until(d -> language.isDisplayed());
        this.language.click();
    }
}
