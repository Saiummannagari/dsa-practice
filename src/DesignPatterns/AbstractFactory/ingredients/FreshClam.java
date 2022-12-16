package DesignPatterns.AbstractFactory.ingredients;

public class FreshClam implements Clams{


    @Override
    public void createClam() {
        System.out.println("adding fresh clams");
    }
}
