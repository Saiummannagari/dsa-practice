package DesignPatterns.Singleton.cloneable.withcloneableissue;


public class Client {

    /*
     Cloning is a concept to create duplicate objects.
     Using clone we can create copy of object.
     Suppose, we create clone of a singleton object, then it will create a copy that
      is there are two instances of a singleton class, hence the class is no more singleton.
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        ChocolateBoiler boiler = ChocolateBoiler.getChocolateBoiler();
        ChocolateBoiler boiler2 = (ChocolateBoiler) boiler.clone();

        System.out.println("instance1 hashCode:- "
                + boiler.hashCode());
        System.out.println("instance2 hashCode:- "
                + boiler2.hashCode());
    }
}
