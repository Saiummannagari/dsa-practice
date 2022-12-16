package DesignPatterns.AbstractFactory.ingredients;

public class ThinCrustDough implements Dough{


    @Override
    public void createDough() {
        System.out.println("preparing with thin crust dough ::");
    }
}
