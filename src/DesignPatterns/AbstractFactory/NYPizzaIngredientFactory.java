package DesignPatterns.AbstractFactory;

import DesignPatterns.AbstractFactory.ingredients.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new RegganioCheese();
    }

    @Override
    public Clams createClams() {
        return new FreshClam();
    }
}
