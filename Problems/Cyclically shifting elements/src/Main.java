import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[(i + 1) % len] = array[i];
        }

        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}