package co.com.sofka.command.validator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DismissalAlertValidator extends ElementValidator {
    private final WebElement dismissalAlert;
    private final WebDriver driver;

    public DismissalAlertValidator(WebElement dismissalAlert, WebDriver driver) {
        this.driver = driver;
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean result = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean disappeared = wait.until(ExpectedConditions.invisibilityOf(this.dismissalAlert));

        return result && disappeared;
    }
}
