package DesignPatterns.Singleton.reflection.withreflectionissue;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        ChocolateBoiler boiler = ChocolateBoiler.getChocolateBoiler();
        ChocolateBoiler boiler2 = null;


            Constructor[] constructors =
                    ChocolateBoiler.class.getDeclaredConstructors();
            for (Constructor constructor : constructors)
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                boiler2 = (ChocolateBoiler) constructor.newInstance();
                break;
            }


        System.out.println("instance1 hashCode:- "
                + boiler.hashCode());
        System.out.println("instance2 hashCode:- "
                + boiler2.hashCode());
    }
}
