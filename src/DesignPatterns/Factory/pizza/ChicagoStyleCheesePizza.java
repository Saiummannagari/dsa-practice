package DesignPatterns.Factory.pizza;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago style deep dish cheese pizza";
        dough="extra thick crust dough";
        sauce="plum tomato sauce";
        toppings.add("shredded mozzarella cheese");
    }

    public void cut() {
        System.out.println("cutting the pizza into square slices");
    }
}
