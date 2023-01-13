package coe.unosquare.benefits.exception;

public class PaymentMethodNotFoundException extends Exception{
    public PaymentMethodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
