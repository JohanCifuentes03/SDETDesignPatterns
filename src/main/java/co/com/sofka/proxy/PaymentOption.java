package co.com.sofka.proxy;

import java.util.Map;

public interface PaymentOption {
    void enterPaymentInfo(Map<String, String> paymentDetails);
}
