package co.com.sofka.command.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DismissalAlerts {
    @FindBy(css = ".card-body .col-lg-4:nth-child(2) .alert-success")
    private WebElement dismissalSuccessAlert;

    @FindBy(css = ".card-body .col-lg-4:nth-child(2) .alert-danger")
    private WebElement dismissalDangerAlert;

    @FindBy(css = ".card-body .col-lg-4:nth-child(2) .alert-warning")
    private WebElement dismissalWarningAlert;

    @FindBy(css = ".card-body .col-lg-4:nth-child(2) .alert-info")
    private WebElement dismissalInfoAlert;

    public WebElement getDismissalSuccessAlert() {
        return dismissalSuccessAlert;
    }

    public WebElement getDismissalDangerAlert() {
        return dismissalDangerAlert;
    }

    public WebElement getDismissalWarningAlert() {
        return dismissalWarningAlert;
    }

    public WebElement getDismissalInfoAlert() {
        return dismissalInfoAlert;
    }
}
