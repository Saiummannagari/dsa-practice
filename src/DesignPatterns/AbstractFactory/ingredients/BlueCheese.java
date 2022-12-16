package DesignPatterns.AbstractFactory.ingredients;

public class BlueCheese implements Cheese{

    @Override
    public void createCheese() {
        System.out.println("adding blue cheese");
    }
}
