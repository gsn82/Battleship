import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int s = 0;
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            if (p % 6 == 0) {
                s += p;
            }
        }
        System.out.println(s);
    }
}