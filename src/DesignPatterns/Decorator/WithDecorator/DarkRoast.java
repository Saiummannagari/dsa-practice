package DesignPatterns.Decorator.WithDecorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Most Excellent Dark Roast";
    }

    @Override
    public double cost() {
        return 2.99;
    }
}

