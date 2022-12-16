package DesignPatterns.Singleton;

public class ChocolateBoilerDoubleCheckedLocking {

    /*https://www.geeksforgeeks.org/volatile-keyword-in-java/*/
    private volatile static ChocolateBoilerDoubleCheckedLocking chocolateBoiler;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerDoubleCheckedLocking() {
        empty = true;
        boiled = false;
    }

    /*
    With double-checked locking, we first check to see if an instance is created, and if not, THEN we synchronize.
    This way, we only synchronize the first time through, just what we want.
    If performance is an issue in your use of the getInstance() method,
    then this method of implementing the Singleton can drastically reduce the overhead.
    */
    public static synchronized ChocolateBoilerDoubleCheckedLocking getChocolateBoilerDoubleCheckedLocking() {
        if(chocolateBoiler == null) {
            synchronized (ChocolateBoilerDoubleCheckedLocking.class) {
                if(chocolateBoiler == null) {
                    chocolateBoiler = new ChocolateBoilerDoubleCheckedLocking();
                }
            }
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

