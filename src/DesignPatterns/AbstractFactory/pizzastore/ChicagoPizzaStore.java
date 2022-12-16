package DesignPatterns.AbstractFactory.pizzastore;


import DesignPatterns.AbstractFactory.ChicagoPizzaIngredientFactory;
import DesignPatterns.AbstractFactory.PizzaIngredientFactory;
import DesignPatterns.AbstractFactory.pizza.CheesePizza;
import DesignPatterns.AbstractFactory.pizza.ClamPizza;
import DesignPatterns.AbstractFactory.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        if(type.equals("cheese")) {
            return new CheesePizza(pizzaIngredientFactory);
        } else if(type.equals("clam")) {
            return new ClamPizza(pizzaIngredientFactory);
        } else {
            return null;
        }
    }
}
