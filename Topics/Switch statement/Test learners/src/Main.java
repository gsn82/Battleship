import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nomer = scanner.nextInt();

        if (nomer == 1) {
            System.out.println("Yes!");
        } else {
            if (2 <= nomer && nomer <= 4) {
                System.out.println("No!");
            } else {
                System.out.println("Unknown number");
            }
        }
    }
}