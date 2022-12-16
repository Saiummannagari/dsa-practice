package DesignPatterns.Decorator.WithDecorator;

public class MilkDecorator extends CondimentDecorator{

    public MilkDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" , milk";
    }
}
