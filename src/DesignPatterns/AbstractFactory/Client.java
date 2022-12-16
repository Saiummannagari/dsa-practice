package DesignPatterns.AbstractFactory;


import DesignPatterns.AbstractFactory.pizza.Pizza;
import DesignPatterns.AbstractFactory.pizzastore.ChicagoPizzaStore;
import DesignPatterns.AbstractFactory.pizzastore.NYPizzaStore;
import DesignPatterns.AbstractFactory.pizzastore.PizzaStore;

public class Client {

    public static void main(String[] args) {
        //Ordereing NY style cheese and clam pizzas
        PizzaStore nyStore = new NYPizzaStore();
        Pizza nycheesePizza = nyStore.orderPizza("cheese");
        System.out.println("ordered pizza :: " + nycheesePizza.getName());
        System.out.println("*****************************************");

        Pizza nyclamPizza = nyStore.orderPizza("clam");
        System.out.println("ordered pizza :: " + nyclamPizza.getName());
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        //Ordereing Chicago style cheese and clam pizzas
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza chicagocheesePizza = chicagoStore.orderPizza("cheese");
        System.out.println("ordered pizza :: " + chicagocheesePizza.getName());
        System.out.println("*****************************************");

        Pizza chicagoclamPizza = chicagoStore.orderPizza("clam");
        System.out.println("ordered pizza :: " + chicagoclamPizza.getName());
        System.out.println("*****************************************");

    }
}
