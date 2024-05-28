package machine;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;
    private CoffeeMachine coffeeMachine;

    public Ui() {
        this.scanner = new Scanner(System.in);
        this.coffeeMachine = new CoffeeMachine(400, 540, 120,
                9, 550);
    }

    public CoffeeType sell(String input) {
        if (Integer.parseInt(input) == 1) {
            return new CoffeeType(250, 0, 16, 4);
        } else if (Integer.parseInt(input) == 2) {
            return new CoffeeType(350, 75, 20, 7);
        } else if (Integer.parseInt(input) == 3) {
            return new CoffeeType(200, 100, 12, 6);
        }
        return new CoffeeType(0,0,0,0);
    }

    public void start() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String command = scanner.nextLine();
            System.out.println();

            if (command.equals("buy")) {
                while (true) {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - " +
                            "cappuccino, back - to main menu:");
                    String input = scanner.nextLine();
                    try {
                        if(input.equals("back")){
                            System.out.println();
                            break;
                        } else if (Integer.parseInt(input) == 1 || Integer.parseInt(input) == 2 || Integer.parseInt(input) == 3) {
                            CoffeeType requestedCoffee = sell(input);
                            coffeeMachine.sell(requestedCoffee);
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong command, please try again");
                    }

                }

            } else if (command.equals("remaining")) {
                coffeeMachine.remaining();
            } else if (command.equals("fill")) {
                System.out.println("Write how many ml of water you want to add:");
                int addedWater = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                int addedMilk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                int addedCoffee = scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                int addedCups = scanner.nextInt();
                coffeeMachine.fill(addedWater, addedMilk, addedCoffee, addedCups);
            } else if (command.equals("take")) {
                coffeeMachine.take();
            } else if (command.equals("exit")) {
                break;
            }
        }
    }
}
