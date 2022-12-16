package DesignPatterns.Decorator.WithoutDecorator.Beverage;

public class Client {

    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage.setMilk(true);
        System.out.println("cost of dark roast with milk :: " + beverage.getDescription() + " "+ beverage.cost());
        Beverage beverage2 = new DarkRoast();
        beverage2.setMilk(true);
        beverage2.setMocha(true);
        beverage2.setSoy(true);
        beverage2.setWhip(true);
        System.out.println("cost of dark roast with milk :: " + beverage2.getDescription() + " "+ beverage2.cost());

    }
}
