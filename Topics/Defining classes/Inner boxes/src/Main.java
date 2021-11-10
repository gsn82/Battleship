//import java.util.Scanner;

class Main extends Box {
    public static void main(String[] args) {
        // put your code here

        Box box = new Box();
        Box innerBox = new Box();
        box.innerBox = innerBox;/**/
/*
        Scanner scanner = new Scanner(System.in);

        box.length = scanner.nextDouble();

        box.height = scanner.nextDouble();

        box.width = scanner.nextDouble();
        box.innerBox.length = scanner.nextDouble();

        box.innerBox.height = scanner.nextDouble();
        box.innerBox.width = scanner.nextDouble();
        box.innerBox.innerBox = null;/**/


        box.length =6;

        box.height = 7;

        box.width = 3;
        box.innerBox.length = 2;

        box.innerBox.height = 3;
        box.innerBox.width = 5;
        box.innerBox.innerBox = null;

        System.out.println(box.length + " " + box.height + " " + box.width + " " + box.innerBox.length + " " + box.innerBox.height + " " + box.innerBox.width);
/**/
      //  scanner.close();
    }
}

class Box {
    double length ;
    double height;
    double width ;
    Box innerBox;
}
