package DesignPatterns.AbstractFactory;

import DesignPatterns.AbstractFactory.ingredients.*;


public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new TomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new BlueCheese();
    }

    @Override
    public Clams createClams() {
        return new FrozenClam();
    }
}
