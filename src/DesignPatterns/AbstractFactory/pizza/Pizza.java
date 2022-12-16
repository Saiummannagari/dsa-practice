package DesignPatterns.AbstractFactory.pizza;

import DesignPatterns.AbstractFactory.ingredients.Cheese;
import DesignPatterns.AbstractFactory.ingredients.Clams;
import DesignPatterns.AbstractFactory.ingredients.Dough;
import DesignPatterns.AbstractFactory.ingredients.Sauce;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;

    Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("place pizza in official pizzastore box");
    }

    public String getName() {
        return name;
    }
}
