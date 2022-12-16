package DesignPatterns.Singleton;

public class Client {


    public static void main(String[] args) {


        //getting instance of singleton object
        ChocolateBoiler chocoBoiler = ChocolateBoiler.getChocolateBoiler();
        ChocolateBoiler chocoBoiler2 = ChocolateBoiler.getChocolateBoiler();
        System.out.println(chocoBoiler == chocoBoiler2);
        chocoBoiler.fill();
        chocoBoiler.boil();
        chocoBoiler.drain();
    }

}
