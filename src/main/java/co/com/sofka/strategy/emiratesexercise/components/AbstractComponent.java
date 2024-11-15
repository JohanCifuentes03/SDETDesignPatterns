package co.com.sofka.strategy.emiratesexercise.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    protected AbstractComponent(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
