package DesignPatterns.Decorator.WithoutDecorator.Beverage;

public abstract class Beverage {

    String description;
    String getDescription() {
        return description;
    }
    //adding condiments cost
    double milkCost = 1.00;
    double soyCost = 2.00;
    double mochaCost = 3.00;
    double whipCost = 4.00;

    //adding condiments
    boolean milk;
    void setMilk(boolean milk) {
        this.milk = milk;
    }
    public boolean hasMilk() {
        return milk;
    }

    boolean mocha;
    void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
    public boolean hasMocha() {
        return mocha;
    }

    boolean soy;
    void setSoy(boolean soy) {
        this.soy = soy;
    }
    public boolean hasSoy() {
        return soy;
    }

    boolean whip;
    void setWhip(boolean whip) {
        this.whip = whip;
    }
    public boolean hasWhip() {
        return whip;
    }

    public double cost() {
        double condimentCost = 0.0;
        if (hasMilk()) {
            condimentCost += milkCost;
        }
        if (hasSoy()) {
            condimentCost += soyCost;
        }
        if (hasMocha()) {
            condimentCost += mochaCost;
        }
        if (hasWhip()) {
            condimentCost += whipCost;
        }
        return condimentCost;
    }
}

