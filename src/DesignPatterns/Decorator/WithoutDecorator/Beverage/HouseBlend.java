package DesignPatterns.Decorator.WithoutDecorator.Beverage;

public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "Most Excellent House Blend";
    }

    @Override
    public double cost() {
        return super.cost() + 1.99;
    }
}