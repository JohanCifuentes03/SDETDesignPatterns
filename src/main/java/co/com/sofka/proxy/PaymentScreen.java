package co.com.sofka.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {
    private final WebDriver driver;
    private final UserInformation userInformation;
    private final OrderComponent orderComponent;
    private PaymentOption paymentOption;

    public PaymentScreen(WebDriver driver) {
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.orderComponent = new OrderComponenProxy(driver);
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public OrderComponent getOrder() {
        return this.orderComponent;
    }

    public void pay(Map<String, String> paymentDetails) {
        paymentOption.enterPaymentInfo(paymentDetails);
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }
}
