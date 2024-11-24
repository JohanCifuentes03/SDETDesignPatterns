package co.com.sofka.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class Paypal implements PaymentOption {
    @FindBy(id = "paypal_username")
    private WebElement username;

    @FindBy(id = "paypal_password")
    private WebElement password;

    @Override
    public void enterPaymentInfo(Map<String, String> paymentDetails) {
        username.sendKeys(paymentDetails.get("username"));
        password.sendKeys(paymentDetails.get("password"));
    }
}
