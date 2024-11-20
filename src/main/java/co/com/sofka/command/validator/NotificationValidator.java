package co.com.sofka.command.validator;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class NotificationValidator extends ElementValidator {
    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(WebElement button, WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean appear = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(4));
        boolean disappear = this.notification.isDisplayed();
        return appear && (!disappear);
    }
}
