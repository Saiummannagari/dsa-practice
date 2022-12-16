package DesignPatterns.Decorator.WithDecorator;

public class MochaDecorator extends CondimentDecorator{

    public MochaDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" mocha";
    }
}
