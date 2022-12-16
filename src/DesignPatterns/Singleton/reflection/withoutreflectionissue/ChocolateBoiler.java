package DesignPatterns.Singleton.reflection.withoutreflectionissue;

public enum ChocolateBoiler {
    chocolateBoiler;
    private boolean empty;
    private boolean boiled;

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setBoiled(boolean boiled) {
        this.boiled = boiled;
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
            System.out.println("filling");
        }
    }

    public void drain() {
        if(!isEmpty() && isBoiled()) {
            empty = true;
            System.out.println("draining");
        }
    }

    public void boil() {
        if(!isEmpty() && !isBoiled()) {
            boiled = true;
            System.out.println("boiling");
        }
    }
}

