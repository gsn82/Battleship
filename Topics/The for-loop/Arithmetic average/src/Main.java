import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();

            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();
                int count = 0;
                double sum = 0;

                int t = a;

                if (t % 3 != 0) {
                    int k = t / 3;
                    t = 3 * k;
                }

                while (t <= b) {
                    if (t % 3 == 0) {
                        count++;
                        sum += t;

                        //  System.out.println(t);
                    }

                    t += 3;
                }

                System.out.println(1.0 * sum / count);
            }

        }
    }
}