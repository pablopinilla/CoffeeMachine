package machine;

public class CoffeeMachine {
    private int availableWater;
    private int availableMilk;
    private int availableCoffee;
    private int availableCups;
    private int availableMoney;

    public CoffeeMachine(int availableWater, int availableMilk, int availableCoffee,
                         int availableCups, int availableMoney) {
        this.availableWater = availableWater;
        this.availableMilk = availableMilk;
        this.availableCoffee = availableCoffee;
        this.availableCups = availableCups;
        this.availableMoney = availableMoney;
    }

    public void sell(CoffeeType coffeeType) {
        if(processRequest(coffeeType)) {
            this.availableWater = this.availableWater - coffeeType.getNeededWater();
            this.availableMilk = this.availableMilk - coffeeType.getNeededMilk();
            this.availableCoffee = this.availableCoffee - coffeeType.getNeededCoffee();
            this.availableMoney = this.availableMoney + coffeeType.getPrice();
            this.availableCups = this.availableCups - coffeeType.getNeededCups();
            System.out.println();
        }
    }

    public void fill(int addedWater, int addedMilk, int addedCoffee, int addedCups) {
        this.availableWater = this.availableWater + addedWater;
        this.availableMilk = this.availableMilk + addedMilk;
        this.availableCoffee = this.availableCoffee + addedCoffee;
        this.availableCups = this.availableCups + addedCups;
        System.out.println();
    }

    public void remaining() {
        System.out.println("The coffee machine has:\n" +
                availableWater + " ml of water\n" +
                availableMilk + " ml of milk\n" +
                availableCoffee + " g of coffee beans\n" +
                availableCups + " disposable cups\n" +
                "$" + availableMoney + " of money");
        System.out.println();
    }

    public void take() {
        System.out.println("I give you $" + availableMoney);
        this.availableMoney = 0;
        System.out.println();
    }

    public boolean processRequest(CoffeeType coffeeType) {
        if (availableWater < coffeeType.getNeededWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (availableCoffee < coffeeType.getNeededCoffee()) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (availableMilk < coffeeType.getNeededMilk()) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (availableCups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
        return true;
    }
}
