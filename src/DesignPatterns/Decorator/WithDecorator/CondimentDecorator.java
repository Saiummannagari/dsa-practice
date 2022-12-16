package DesignPatterns.Decorator.WithDecorator;

public abstract class CondimentDecorator extends Beverage{

    Beverage beverage;
    public abstract String getDescription();

}
