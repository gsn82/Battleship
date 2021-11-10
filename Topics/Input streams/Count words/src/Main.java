import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here

        String str = reader.readLine();
        reader.close();

        str = str.trim();

        if ("".equals(str)) {
            System.out.println(0);
        } else {
            String[] arr = str.split("\\s+");
            System.out.println(arr.length);
        }
    }
}