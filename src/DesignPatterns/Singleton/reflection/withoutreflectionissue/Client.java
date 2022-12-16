package DesignPatterns.Singleton.reflection.withoutreflectionissue;


import java.io.*;

public class Client {

    /*
   To overcome issue raised by reflection, enums are used because java ensures internally
   that enum value is instantiated only once.
   Since java Enums are globally accessible, they can be used for singletons.
   Its only drawback is that it is not flexible i.e it does not allow lazy initialization.
     */
    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.chocolateBoiler;

        System.out.println("instance1 hashCode:- "
                + boiler.hashCode());
        boiler.setEmpty(true);
        boiler.setBoiled(false);
        boiler.fill();
        boiler.boil();
        boiler.drain();
    }
}
