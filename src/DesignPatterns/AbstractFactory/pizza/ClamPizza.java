package DesignPatterns.AbstractFactory.pizza;
import DesignPatterns.AbstractFactory.PizzaIngredientFactory;

public class ClamPizza extends Pizza{

    PizzaIngredientFactory ingredientFactory;
    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
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
        clams = ingredientFactory.createClams();
        clams.createClam();
        name = "clam pizza";
    }
}

