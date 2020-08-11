import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isOrdered = true;

        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].compareTo(words[i+1]) > 0) {
                isOrdered = false;
                break;
            }
        }

        System.out.println(isOrdered);
    }
}