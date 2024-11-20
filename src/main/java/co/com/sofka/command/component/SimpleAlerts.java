package co.com.sofka.command.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleAlerts {
    @FindBy(css = "div.button-box .btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box .btn-warning")
    private WebElement warningBtn;

    @FindBy(css = "div.button-box .btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box .btn-danger")
    private WebElement dangerBtn;

    @FindBy(css = ".jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = ".jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = ".jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = ".jq-icon-error")
    private WebElement errorAlert;

    public WebElement getInfoBtn() {
        return infoBtn;
    }

    public WebElement getWarningBtn() {
        return warningBtn;
    }

    public WebElement getSuccessBtn() {
        return successBtn;
    }

    public WebElement getDangerBtn() {
        return dangerBtn;
    }

    public WebElement getInfoAlert() {
        return infoAlert;
    }

    public WebElement getWarningAlert() {
        return warningAlert;
    }

    public WebElement getSuccessAlert() {
        return successAlert;
    }

    public WebElement getErrorAlert() {
        return errorAlert;
    }
}
