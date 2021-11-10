import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;


        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        // start coding here

        int charAsNumber = reader.read();
        while (charAsNumber != -1) {
            int character = charAsNumber;
            System.out.print(character);
            charAsNumber = reader.read();
        }
        reader.close();
    }
}