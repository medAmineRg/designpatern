package patterns.strategy;

/**
 * Strategy Pattern Example
 * 
 * The Strategy pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. Strategy lets the algorithm vary
 * independently
 * from clients that use it.
 */

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "$ paid with credit card: " + cardNumber);
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "$ paid using PayPal account: " + email);
    }
}

// Concrete Strategy 3
class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + "$ paid in cash");
    }
}

// Context class that uses the strategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Demo class
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100);

        // Pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("john.doe@email.com"));
        cart.checkout(250);

        // Pay with Cash
        cart.setPaymentStrategy(new CashPayment());
        cart.checkout(50);
    }
}
