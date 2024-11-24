package co.com.sofka.proxy;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Objects;

public class OrderComponenProxy implements OrderComponent {
    private static final List<String> EXCLUDED = List.of(
            "PROD", "STAGING"
    );
    private OrderComponent orderComponent;

    public OrderComponenProxy(WebDriver driver) {
        String currentEnv = System.getProperty("env"); // DEV / QA / PROD / STAGING
        if (!EXCLUDED.contains(currentEnv)) {
            this.orderComponent = new OrderComponentReal(driver);
        }
    }

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        }
        return "SKIPPED";
    }
}
