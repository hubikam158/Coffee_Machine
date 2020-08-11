//package machine;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        final Scanner scanner = new Scanner(System.in);
//
//        CoffeeMachine coffeeMachine = new CoffeeMachine();
//
//        while (coffeeMachine.getCurrentState() != State.EXITING) {
//            if (coffeeMachine.getCurrentState() == State.CHOOSING_AN_ACTION) {
//                System.out.println("\nWrite action (buy, fill, take, remaining, exit) :");
//            }
//            String argument = scanner.nextLine();
//            coffeeMachine.action(argument);
//        }
//    }
//}
