package patterns.decorator;

/**
 * Decorator Pattern Example
 * 
 * The Decorator pattern attaches additional responsibilities to an object
 * dynamically.
 * Decorators provide a flexible alternative to subclassing for extending
 * functionality.
 */

// Component Interface
interface Coffee {
    String getDescription();

    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.00;
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorator 1
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.50;
    }
}

// Concrete Decorator 2
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.25;
    }
}

// Concrete Decorator 3
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.75;
    }
}

// Concrete Decorator 4
class VanillaDecorator extends CoffeeDecorator {
    public VanillaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Vanilla";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.60;
    }
}

// Demo class
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        // Coffee with milk
        Coffee coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffeeWithMilk.getDescription() + " = $" + coffeeWithMilk.getCost());

        // Coffee with milk and sugar
        Coffee coffeeWithMilkAndSugar = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffeeWithMilkAndSugar.getDescription() + " = $" + coffeeWithMilkAndSugar.getCost());

        // Fancy coffee with everything
        Coffee fancyCoffee = new VanillaDecorator(
                new WhippedCreamDecorator(
                        new SugarDecorator(
                                new MilkDecorator(
                                        new SimpleCoffee()))));
        System.out.println(fancyCoffee.getDescription() + " = $" + fancyCoffee.getCost());
    }
}
