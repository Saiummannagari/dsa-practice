package DesignPatterns.Singleton.cloneable.withoutcloneableissue;


public class ChocolateBoiler implements Cloneable {
    private static ChocolateBoiler chocolateBoiler;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }
   /*

   */
    protected Object clone() throws CloneNotSupportedException {
       throw new CloneNotSupportedException();
    }

    protected Object clone2() throws CloneNotSupportedException {
        return chocolateBoiler;
    }


    //lazy initialization
    public static ChocolateBoiler getChocolateBoiler() {
        if(chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler();
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

