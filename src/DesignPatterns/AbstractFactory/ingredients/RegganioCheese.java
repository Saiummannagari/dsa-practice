package DesignPatterns.AbstractFactory.ingredients;

public class RegganioCheese implements Cheese{

    @Override
    public void createCheese() {
        System.out.println("adding regganio cheese");
    }
}
