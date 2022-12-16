package DesignPatterns.AbstractFactory;

import DesignPatterns.AbstractFactory.ingredients.Cheese;
import DesignPatterns.AbstractFactory.ingredients.Clams;
import DesignPatterns.AbstractFactory.ingredients.Dough;
import DesignPatterns.AbstractFactory.ingredients.Sauce;

public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();

    public Clams createClams();
}
