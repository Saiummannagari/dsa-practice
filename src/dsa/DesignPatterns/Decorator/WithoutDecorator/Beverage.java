package dsa.DesignPatterns.Decorator.WithoutDecorator;

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





//creating beverages
class HouseBlend extends Beverage{

    HouseBlend() {
        description = "Most Excellent House Blend";
    }

    @Override
    public double cost() {
        return super.cost() + 1.99;
    }
}
class DarkRoast extends Beverage{

    DarkRoast() {
        description = "Most Excellent Dark Roast";
    }

    @Override
    public double cost() {
        return super.cost() + 2.99;
    }
}

class Main {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage.setMilk(true);
        System.out.println("cost of dark roast with milk :: " + beverage.getDescription() + " "+ beverage.cost());
        Beverage beverage2 = new DarkRoast();
        beverage2.setMilk(true);
        beverage2.setMocha(true);
        beverage2.setSoy(true);
        beverage2.setWhip(true);
        System.out.println("cost of dark roast with milk :: " + beverage2.getDescription() + " "+ beverage2.cost());

    }
}



