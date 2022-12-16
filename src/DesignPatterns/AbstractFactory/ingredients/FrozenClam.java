package DesignPatterns.AbstractFactory.ingredients;

public class FrozenClam implements Clams{


    @Override
    public void createClam() {
        System.out.println("adding frozen clams");
    }
}
