package machine;

import java.util.Scanner;

enum State {
    CHOOSING_AN_ACTION,
    CHOOSING_A_VARIANT_OF_COFFEE,
    FILLING_WATER,
    FILLING_MILK,
    FILLING_BEANS,
    FILLING_CUPS,
    EXITING;
}

public class CoffeeMachine {

    private int cash = 550;
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private State currentState = State.CHOOSING_AN_ACTION;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (coffeeMachine.getCurrentState() != State.EXITING) {
            if (coffeeMachine.getCurrentState() == State.CHOOSING_AN_ACTION) {
                System.out.println("\nWrite action (buy, fill, take, remaining, exit) :");
            }
            String argument = scanner.nextLine();
            coffeeMachine.action(argument);
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    private void printState() {
        System.out.println("\nThe coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n$" +
                cash + " of money");
    }

    public void action(String argument) {

            if (currentState == State.CHOOSING_AN_ACTION) {
                switch (argument) {
                    case "buy":
                        if (cups > 0) {
                            currentState = State.CHOOSING_A_VARIANT_OF_COFFEE;
                            System.out.println("\nWhat do you want to buy?\n" +
                                    "1 - espresso\n2 - latte\n3 - cappuccino\nback - to main menu:");
                        } else {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                        break;
                    case "fill":
                        currentState = State.FILLING_WATER;
                        System.out.println("\nWrite how many ml of water do you want to add:");
                        break;
                    case "take":
                        System.out.println("\nI gave you $" + cash);
                        cash = 0;
                        break;
                    case "remaining":
                        printState();
                        break;
                    case "exit":
                        currentState = State.EXITING;
                        break;
                    default:
                        System.out.println("Unknown action!");
                        break;
                }
            } else if (currentState == State.CHOOSING_A_VARIANT_OF_COFFEE) {
                makeCoffee(argument);
            } else if (currentState == State.FILLING_WATER) {
                water += Integer.parseInt(argument);
                currentState = State.FILLING_MILK;
                System.out.println("Write how many ml of milk do you want to add:");
            } else if (currentState == State.FILLING_MILK) {
                milk += Integer.parseInt(argument);
                currentState = State.FILLING_BEANS;
                System.out.println("Write how many grams of coffee beans do you want to add:");
            } else if (currentState == State.FILLING_BEANS) {
                beans += Integer.parseInt(argument);
                currentState = State.FILLING_CUPS;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
            } else if (currentState == State.FILLING_CUPS) {
                cups += Integer.parseInt(argument);
                currentState = State.CHOOSING_AN_ACTION;
            }

    }

    private void makeCoffee(String choice) {
        switch (choice) {
            case "1":
                if (water >= 250 && beans >=16) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    beans -= 16;
                    cups--;
                    cash += 4;
                } else if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && beans >= 20) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    cash += 7;
                } else if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && beans >= 12) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    cash += 6;
                } else if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Error, wrong choice!");
                break;
        }
        currentState = State.CHOOSING_AN_ACTION;
    }
}
