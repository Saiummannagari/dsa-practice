package DesignPatterns.Decorator.WithDecorator;

public abstract class Beverage {

    String description;
    String getDescription() {
        return description;
    }

    public abstract double cost();
}

