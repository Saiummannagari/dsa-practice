package DesignPatterns.Singleton;

public class ChocolateBoilerMultiThreading {

    private static ChocolateBoilerMultiThreading chocolateBoiler;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerMultiThreading() {
        empty = true;
        boiled = false;
    }

    //using sysnchronization for multiple threads.
    /* Since synchronization is costly we can use early initialization if we are sure
     our application always creates and uses instance of singleton*/
    public static synchronized ChocolateBoilerMultiThreading getChocolateBoilerMultiThreading() {
        if(chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoilerMultiThreading();
        }
        return chocolateBoiler;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    public void fill() {
        if(isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if(!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if(!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }
}

