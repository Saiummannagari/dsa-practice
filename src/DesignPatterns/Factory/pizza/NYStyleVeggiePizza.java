package DesignPatterns.Factory.pizza;

public class NYStyleVeggiePizza extends Pizza{

    public NYStyleVeggiePizza() {
        name = "NY Style sauce and veggie pizza";
        dough = "thin crust dough";
        sauce = "marinara sauce";
        toppings.add("veggies");
    }
}