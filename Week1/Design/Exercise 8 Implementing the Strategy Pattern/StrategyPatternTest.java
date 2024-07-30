public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create the PaymentContext
        PaymentContext paymentContext = new PaymentContext();

        // Set and use CreditCardPayment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(150.00);

        // Set and use PayPalPayment strategy
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}
