package machine;

public class CoffeeType {
    private int neededWater;
    private int neededMilk;
    private int neededCoffee;
    private int neededCups;
    private int price;

    public CoffeeType(int neededWater, int neededMilk, int neededCoffee, int price) {
        this.neededWater = neededWater;
        this.neededMilk = neededMilk;
        this.neededCoffee = neededCoffee;
        this.price = price;
        this.neededCups = 1;
    }

    public int getNeededWater() {
        return neededWater;
    }

    public int getNeededMilk() {
        return neededMilk;
    }

    public int getNeededCoffee() {
        return neededCoffee;
    }

    public int getPrice() {
        return price;
    }

    public int getNeededCups() {
        return neededCups;
    }
}
