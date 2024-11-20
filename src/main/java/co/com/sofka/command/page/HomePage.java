package co.com.sofka.command.page;

import co.com.sofka.command.component.DismissalAlerts;
import co.com.sofka.command.component.SimpleAlerts;
import co.com.sofka.command.validator.DismissalAlertValidator;
import co.com.sofka.command.validator.ElementValidator;
import co.com.sofka.command.validator.NotificationValidator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final SimpleAlerts simpleAlerts;
    private final DismissalAlerts dismissalAlerts;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.simpleAlerts = PageFactory.initElements(driver, SimpleAlerts.class);
        this.dismissalAlerts = PageFactory.initElements(driver, DismissalAlerts.class);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return List.of(
                new NotificationValidator(simpleAlerts.getInfoBtn(), simpleAlerts.getInfoAlert()),
                new NotificationValidator(simpleAlerts.getWarningBtn(), simpleAlerts.getWarningAlert()),
                new NotificationValidator(simpleAlerts.getDangerBtn(), simpleAlerts.getErrorAlert()),
                new NotificationValidator(simpleAlerts.getSuccessBtn(), simpleAlerts.getSuccessAlert()),
                new DismissalAlertValidator(dismissalAlerts.getDismissalDangerAlert(), driver),
                new DismissalAlertValidator(dismissalAlerts.getDismissalInfoAlert(), driver),
                new DismissalAlertValidator(dismissalAlerts.getDismissalSuccessAlert(), driver),
                new DismissalAlertValidator(dismissalAlerts.getDismissalWarningAlert(), driver)
        );
    }
}
