package DesignPatterns.Factory.pizza;

public class ChicagoStyleVeggiePizza extends Pizza{

    public ChicagoStyleVeggiePizza() {
        name = "Chicago style deep dish veggie pizza";
        dough="extra thick crust dough";
        sauce="plum tomato sauce";
        toppings.add("veggies");
    }

    public void cut() {
        System.out.println("cutting the pizza into square slices");
    }
}
