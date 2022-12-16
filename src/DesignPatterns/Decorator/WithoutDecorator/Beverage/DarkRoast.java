package DesignPatterns.Decorator.WithoutDecorator.Beverage;

public class DarkRoast extends Beverage{

    public DarkRoast() {
        description = "Most Excellent Dark Roast";
    }

    @Override
    public double cost() {
        return super.cost() + 2.99;
    }
}

