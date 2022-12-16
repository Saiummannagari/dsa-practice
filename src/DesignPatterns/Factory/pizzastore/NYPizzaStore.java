package DesignPatterns.Factory.pizzastore;

import DesignPatterns.Factory.pizza.NYStyleCheesePizza;
import DesignPatterns.Factory.pizza.NYStyleVeggiePizza;
import DesignPatterns.Factory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if(type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else {
            return null;
        }
    }
}
