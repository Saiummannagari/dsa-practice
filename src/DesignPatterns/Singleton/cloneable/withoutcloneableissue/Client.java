package DesignPatterns.Singleton.cloneable.withoutcloneableissue;


public class Client {

    /*
    To overcome cloning issue, override clone() method and throw an exception
    from clone method that is CloneNotSupportedException.
    Now whenever user will try to create clone of singleton object,
    it will throw exception and hence our class remains singleton.
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        ChocolateBoiler boiler = ChocolateBoiler.getChocolateBoiler();
        ChocolateBoiler boiler3 = (ChocolateBoiler) boiler.clone2();
        System.out.println("instance1 hashCode:- "
                + boiler.hashCode());
        System.out.println("instance3 hashCode:- "
                + boiler3.hashCode());

       //throwing exception in clone
        ChocolateBoiler boiler2 = (ChocolateBoiler) boiler.clone();
        System.out.println("instance1 hashCode:- "
                + boiler.hashCode());
        System.out.println("instance2 hashCode:- "
                + boiler2.hashCode());


    }
}
