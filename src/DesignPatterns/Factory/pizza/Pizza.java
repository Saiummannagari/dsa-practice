package DesignPatterns.Factory.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings =new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparing "+name);
        System.out.println("tossing dough...");
        System.out.println("adding sauce...");
        System.out.println("adding toppings");
        for(String topping: toppings) {
            System.out.println(" "+topping);
        }
    }

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
