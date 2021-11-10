import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int count = 3;
        int[] arr1 = new int[count];
        int[] arr2 = new int[count];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < count; i++) {
            arr2[i] = scanner.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (arr1[0] < arr2[0] && arr1[1] < arr2[1] && arr1[2] < arr2[2]) {
            System.out.println("Box 1 < Box 2");
        } else {
            if (arr1[0] > arr2[0] && arr1[1] > arr2[1] && arr1[2] > arr2[2]) {
                System.out.println("Box 1 > Box 2");
            } else {
                System.out.println("Incompatible");
            }
        }

    }
}