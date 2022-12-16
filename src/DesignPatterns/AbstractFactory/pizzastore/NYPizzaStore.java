package DesignPatterns.AbstractFactory.pizzastore;


import DesignPatterns.AbstractFactory.NYPizzaIngredientFactory;
import DesignPatterns.AbstractFactory.PizzaIngredientFactory;
import DesignPatterns.AbstractFactory.pizza.CheesePizza;
import DesignPatterns.AbstractFactory.pizza.ClamPizza;
import DesignPatterns.AbstractFactory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if(type.equals("cheese")) {
            return new CheesePizza(ingredientFactory);
        } else if(type.equals("clam")) {
            return new ClamPizza(ingredientFactory);
        } else {
            return null;
        }
    }
}
