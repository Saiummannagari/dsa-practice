package DesignPatterns.Factory;

import DesignPatterns.Factory.pizza.Pizza;
import DesignPatterns.Factory.pizzastore.ChicagoPizzaStore;
import DesignPatterns.Factory.pizzastore.NYPizzaStore;
import DesignPatterns.Factory.pizzastore.PizzaStore;

public class Client {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza cheesePizza = nyStore.orderPizza("cheese");
        System.out.println("ordered pizza :: " + cheesePizza.getName());

        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza veggiePizza = chicagoStore.orderPizza("veggie");
        System.out.println("ordered pizza :: " + veggiePizza.getName());

    }
}
