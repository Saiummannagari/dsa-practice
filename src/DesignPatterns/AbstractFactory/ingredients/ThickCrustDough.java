package DesignPatterns.AbstractFactory.ingredients;

public class ThickCrustDough implements Dough{


    @Override
    public void createDough() {
        System.out.println("preparing with thick crust dough ::");
    }
}
