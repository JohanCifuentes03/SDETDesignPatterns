package co.com.sofka.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Order {
    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public String placeOrder() {
        this.buyNow.click();
        return this.orderNumber.getText();
    }
}
