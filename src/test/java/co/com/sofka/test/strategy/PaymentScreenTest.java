package co.com.sofka.test.strategy;

import co.com.sofka.strategy.*;
import co.com.sofka.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails) {
        paymentScreen.goTo();
        paymentScreen.getUserInformation().enterDetails(
                "Johan",
                "Cifuentes",
                "johan@gmail.com");
        paymentScreen.setPaymentOption(paymentOption);
        paymentScreen.pay(paymentDetails);
        String orderNumber = paymentScreen.getOrder().placeOrder();

        Assert.assertTrue(Integer.parseInt(paymentScreen.getOrder().placeOrder()) > 0);

        System.out.println(
                "Order number: " + orderNumber
        );
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Map.of(
                "cc", "1012111541",
                "year", "2024",
                "cvv", "123"
        );

        Map<String, String> nb = Map.of(
                "bank", "WELLS FARGO",
                "account", "account1012154",
                "pin", "1449"
        );

        Map<String, String> pp = Map.of(
                "username", "JohanSmith",
                "password", "secretPassword123"
        );

        return new Object[][]{
                {new CreditCard(), cc},
                {new NetBanking(), nb},
                {new Paypal(), pp}
        };
    }
}
