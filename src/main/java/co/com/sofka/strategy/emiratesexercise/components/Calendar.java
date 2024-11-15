package co.com.sofka.strategy.emiratesexercise.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calendar extends AbstractComponent{
    @FindBy(css = "eol-calendar div.ek-datepicker")
    private WebElement calendar;

    public Calendar(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> calendar.isDisplayed());
    }
}
