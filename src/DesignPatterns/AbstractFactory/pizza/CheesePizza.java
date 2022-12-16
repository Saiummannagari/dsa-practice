package DesignPatterns.AbstractFactory.pizza;

import DesignPatterns.AbstractFactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza{

    PizzaIngredientFactory ingredientFactory;
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare() {
        System.out.println("preparing");
        dough = ingredientFactory.createDough();
        dough.createDough();
        sauce = ingredientFactory.createSauce();
        sauce.createSauce();
        cheese = ingredientFactory.createCheese();
        cheese.createCheese();
        name = "cheese pizza";
    }
}
