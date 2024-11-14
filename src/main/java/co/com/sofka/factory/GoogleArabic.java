package co.com.sofka.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish{
    @FindBy(css = "div#SlvCob a:nth(1)")
    private WebElement language;

    @FindBy(css = "ly0Ckb")
    private WebElement keyboardBtn;

    @FindBy(id = "kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.wait.until(d -> language.isDisplayed());
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until(d -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until(d -> this.keyboard.isDisplayed());
        super.search(keyword);
    }
}
