import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

       // System.out.println(str);

        if ("one".equals(str)) {
            System.out.println(1);
        } else if ("two".equals(str)) {
            System.out.println(2);
        } else if ("three".equals(str)) {
            System.out.println(3);
        } else if ("four".equals(str)) {
            System.out.println(4);
        } else if ("five".equals(str)) {
            System.out.println(5);
        } else if ("six".equals(str)) {
            System.out.println(6);
        } else if ("seven".equals(str)) {
            System.out.println(7);
        } else if ("eight".equals(str)) {
            System.out.println(8);
        } else if ("nine".equals(str)) {
            System.out.println(9);
        } else {
            throw new IllegalStateException("Unexpected value: " + str);
        }

    }
}