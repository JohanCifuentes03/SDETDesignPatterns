package co.com.sofka.strategy;

import java.util.Map;

public interface PaymentOption {
    void enterPaymentInfo(Map<String, String> paymentDetails);
}
