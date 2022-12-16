package DesignPatterns.Decorator.WithDecorator;

public class Client {

    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new MilkDecorator(beverage);
        System.out.println("cost of dark roast with milk :: " + beverage.getDescription() + " "+ beverage.cost());
        Beverage beverage2 = new HouseBlend();
        beverage2 = new MilkDecorator(beverage2);
        beverage2 = new MochaDecorator(beverage2);
        System.out.println("cost of house blend with milk and mocha:: " + beverage2.getDescription() + " "+ beverage2.cost());
    }
}
