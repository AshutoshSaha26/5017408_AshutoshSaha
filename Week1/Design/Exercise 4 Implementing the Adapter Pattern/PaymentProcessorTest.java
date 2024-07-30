public class PaymentProcessorTest {
    public static void main(String[] args) {
        // Using PayPal through the adapter
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        payPalProcessor.processPayment(100.00);

        // Using Stripe through the adapter
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(200.00);
    }
}
