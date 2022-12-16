package DesignPatterns.AbstractFactory.ingredients;

public class TomatoSauce implements Sauce{

    @Override
    public void createSauce() {
        System.out.println("adding tomato sauce");
    }
}

