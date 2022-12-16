package DesignPatterns.AbstractFactory.ingredients;

public class MarinaraSauce implements Sauce{

    @Override
    public void createSauce() {
        System.out.println("adding marinara sauce");
    }
}
