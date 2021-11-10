package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String ALF = "ABCDEFGHIJ";
    public static Scanner scanner = new Scanner(System.in);
    public static int[] arrayShip = {5, 4, 3, 3, 2};
    public static String[] arrayShip_str = {
            "Enter the coordinates of the Aircraft Carrier (5 cells):",
            "Enter the coordinates of the Battleship (4 cells):",
            "Enter the coordinates of the Submarine (3 cells):",
            "Enter the coordinates of the Cruiser (3 cells):",
            "Enter the coordinates of the Destroyer (2 cells):"
    };

    public static void main(String[] args) {
        int count = 10;


        String[][] arrayBattleShip1 = new String[count][count];
        String[][] arrayFogBattleShip1 = new String[count][count];

        String[][] arrayBattleShip2 = new String[count][count];
        String[][] arrayFogBattleShip2 = new String[count][count];

        // поле делаем пустое
        init_arrayBattleShip(arrayBattleShip1);
        // поле делаем пустое - туман
        init_arrayBattleShip(arrayFogBattleShip1);

        // поле делаем пустое
        init_arrayBattleShip(arrayBattleShip2);
        // поле делаем пустое - туман
        init_arrayBattleShip(arrayFogBattleShip2);


        //  расставить свои корабли
        System.out.println("Player 1, place your ships on the game field");
        arrange_your_ships(arrayBattleShip1);

        //  расставить свои корабли
        System.out.println("Player 2, place your ships to the game field");
        arrange_your_ships(arrayBattleShip2);

        System.out.println("Press Enter and pass the move to another player");

         System.out.println("The game starts!");

        //print_arrayBattleShip(arrayFogBattleShip2);
         System.out.println("Take a shot!");

        //  System.out.println(countPoint_o(arrayBattleShip1));
      //  System.out.println ("\n" .repeat (99));
        boolean flag = true;

        do {



            int x;
            int y;
            do {
                String str;
                do {

                    if (flag) {
                        System.out.println();
                        print_arrayBattleShip(arrayFogBattleShip2);
                        System.out.println("---------------------");
                        print_arrayBattleShip(arrayBattleShip1);
                        System.out.println();

                        System.out.println("Player 1, it's your turn:");
                    } else {
                        System.out.println();
                        print_arrayBattleShip(arrayFogBattleShip1);
                        System.out.println("---------------------");
                        print_arrayBattleShip(arrayBattleShip2);
                        System.out.println();

                        System.out.println("Player 2, it's your turn:");
                    }



                    str = scanner.nextLine();
                    str.trim();
                } while (str == null || str.length() < 2);

                // код  65  A      -  74  J
                // отнимаем код А
                x = str.charAt(0) - 65;
                y = Str_int(str.substring(1)) - 1;
            }
            while (x < 0 || x > 9 || y < 0 || y > 9);

            if (flag) { // первый делает удар
                // отправляем массивы , что бы отметить
                take_shot(arrayBattleShip2, arrayFogBattleShip2, x, y);
                flag = false;
            } else {
                // второй делает удар
                // отправляем массивы , что бы отметить
                take_shot(arrayBattleShip1, arrayFogBattleShip1, x, y);
                flag = true;
            }
            // сколько о на карте осталось, у каждого игрока
        } while (countPoint_o(arrayBattleShip1) > 0 && countPoint_o(arrayBattleShip2) > 0); // сколько о на карте осталось
    }

    private static void take_shot(String[][] arrayBattleShip, String[][] arrayFogBattleShip, int x, int y) {
        if ("~ ".equals(arrayBattleShip[x][y])) {
            arrayBattleShip[x][y] = "M ";
            arrayFogBattleShip[x][y] = "M ";
        } else {
            arrayBattleShip[x][y] = "X ";
            arrayFogBattleShip[x][y] = "X ";
        }

        //  print_arrayBattleShip(arrayFogBattleShip);

        if (countPoint_o(arrayBattleShip) > 0) {
            if ("M ".equals(arrayBattleShip[x][y])) {
                System.out.println("You missed. Try again:");
            } else {

                if (!examinationPoint_o(arrayBattleShip, x, y)) {
                    System.out.println("You hit a ship! Try again:");
                    System.out.println("Press Enter and pass the move to another player");
                } else {
                    System.out.println("You sank a ship! Specify a new target:");
                    System.out.println("Press Enter and pass the move to another player");
                }
            }
        } else {
            System.out.println("You sank the last ship. You won. Congratulations!");
        }
    }

    private static void arrange_your_ships(String[][] arrayBattleShip) {
        for (int i = 0; i < arrayShip.length; i++) {

            print_arrayBattleShip(arrayBattleShip);
            System.out.println(arrayShip_str[i]);
            boolean f;
            do {
                f = false;
                String str;

                do {
                    str = scanner.nextLine();
                    str.trim();
                } while (str == null);


                String[] coordinates_str = str.split(" ");

                int[] coordinates_int = new int[4];

                // проверка координаты
                if (coordinates_str.length < 2 || !examination(coordinates_str, coordinates_int)) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    System.out.println(arrayShip_str[i]);
                    f = true;
                    continue;
                }
                // длина не равна текущему короблю
                if (length_coordinate(coordinates_int) != arrayShip[i]) {
                    System.out.println("Error! Wrong length of the Submarine! Try again:");
                    f = true;
                    continue;
                }
                // проверка можем ли поставить карабль
                if (!examinationNextStep(arrayBattleShip, coordinates_int)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    f = true;
                } else {/**/
                    // ставимь карабль
                    nextStep(arrayBattleShip, coordinates_int);
                    f = false;
                }
            } while (f);
        }
        print_arrayBattleShip(arrayBattleShip);
    }


    private static int Str_int(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            number = -1;
        }

        return number;
    }

    private static boolean examination(String[] coordinates_str, int[] coordinates_int) {
        //// если ввели вольше двух координат
        if (coordinates_str.length > 2) {
            return false;
        }

        // если первый сисмовл не входит в алфавит - ALF
        if (!(ALF.contains(Character.toString(coordinates_str[0].charAt(0))) && ALF.contains(Character.toString(coordinates_str[1].charAt(0))))) {
            return false;
        }
        // код  65  A      -  74  J
        // отнимаем код А
        coordinates_int[0] = coordinates_str[0].charAt(0) - 65;
        coordinates_int[2] = coordinates_str[1].charAt(0) - 65;
        //мы проверяем, что бы второй символ был числом
        // -1 - значит стоит не число
        if (Str_int(coordinates_str[0].substring(1)) == -1 || Str_int(coordinates_str[1].substring(1)) == -1) {
            return false;
        }
        //-1 это по правка т.к нумерация с нуля
        coordinates_int[1] = Str_int(coordinates_str[0].substring(1)) - 1;
        coordinates_int[3] = Str_int(coordinates_str[1].substring(1)) - 1;

        // если цифровая координата, большая
        if (coordinates_int[1] > 9 || coordinates_int[3] > 9) {
            return false;
        }

        // надо убедиться , что корабаль должен распологаться по горизонтали или по вертикали
        if (coordinates_int[0] != coordinates_int[2] && coordinates_int[1] != coordinates_int[3]) {
            return false;
        }

        return true;
    }

    private static void nextStep(String[][] arrayBattleShip, int[] coordinates_int) {
        // по вертикале
        if (coordinates_int[1] == coordinates_int[3]) {
            // сверху в них
            if (coordinates_int[0] < coordinates_int[2]) {
                for (int i = coordinates_int[0]; i <= coordinates_int[2]; i++) {
                    arrayBattleShip[i][coordinates_int[1]] = "O ";
                }
            } else {// с низу в верх
                for (int i = coordinates_int[2]; i <= coordinates_int[0]; i++) {
                    arrayBattleShip[i][coordinates_int[1]] = "O ";
                }
            }
        }

        // по горизонтали
        if (coordinates_int[0] == coordinates_int[2]) {
            // слева на право
            if (coordinates_int[1] < coordinates_int[3]) {
                for (int j = coordinates_int[1]; j <= coordinates_int[3]; j++) {
                    arrayBattleShip[coordinates_int[0]][j] = "O ";
                }
            } else {
                // с право на лево
                for (int j = coordinates_int[3]; j <= coordinates_int[1]; j++) {
                    arrayBattleShip[coordinates_int[0]][j] = "O ";
                }
            }
        }
    }

    private static boolean examinationNextStep(String[][] arrayBattleShip, int[] coordinates_int) {
        // по вертикале
        if (coordinates_int[1] == coordinates_int[3]) {
            // сверху в них
            if (coordinates_int[0] < coordinates_int[2]) {
                for (int i = coordinates_int[0]; i <= coordinates_int[2]; i++) {
                    if (!examinationPoint(arrayBattleShip, i, coordinates_int[1])) {
                        return false;
                    }
                }
            } else {// с низу в верх
                for (int i = coordinates_int[2]; i <= coordinates_int[0]; i++) {
                    if (!examinationPoint(arrayBattleShip, i, coordinates_int[1])) {
                        return false;
                    }
                }
            }
        }

        // по горизонтали
        if (coordinates_int[0] == coordinates_int[2]) {
            // слева на право
            if (coordinates_int[1] < coordinates_int[3]) {
                for (int j = coordinates_int[1]; j <= coordinates_int[3]; j++) {
                    if (!examinationPoint(arrayBattleShip, coordinates_int[0], j)) {
                        return false;
                    }
                }
            } else {
                // с право на лево
                for (int j = coordinates_int[3]; j <= coordinates_int[1]; j++) {
                    if (!examinationPoint(arrayBattleShip, coordinates_int[0], j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean examinationPoint(String[][] arrayBattleShip, int x, int y) {
        // с верху
        if (x > 0) {
            if ("O ".equals(arrayBattleShip[x - 1][y])) {
                return false;
            }
        }

        // с низу
        if (x < 9) {
            if ("O ".equals(arrayBattleShip[x + 1][y])) {
                return false;
            }
        }
        // с слева
        if (y > 0) {
            if ("O ".equals(arrayBattleShip[x][y - 1])) {
                return false;
            }
        }
        // с права
        if (y < 9) {
            if ("O ".equals(arrayBattleShip[x][y + 1])) {
                return false;
            }
        }

        // левый верхний
        if (x != 0 && y != 0) {
            if ("O ".equals(arrayBattleShip[x - 1][y - 1])) {
                return false;
            }
        }
        // нижний левый
        if (x != 9 && y != 0) {
            if ("O ".equals(arrayBattleShip[x + 1][y - 1])) {
                return false;
            }
        }
        // нижний правый
        if (x != 9 && y != 9) {
            if ("O ".equals(arrayBattleShip[x + 1][y + 1])) {
                return false;
            }
        }
        // верхний правый
        if (x != 0 && y != 9) {
            if ("O ".equals(arrayBattleShip[x - 1][y + 1])) {
                return false;
            }
        }

        return true;
    }


    // если false - то рядом с [x, y]  находиться часть коробля
    // если true - то рядом с [x, y]  нет коробля
    private static boolean examinationPoint_o(String[][] arrayBattleShip, int x, int y) {

        // с верху
        if (x > 0) {
            if ("O ".equals(arrayBattleShip[x - 1][y])) {
                return false;
            }
        }

        // с низу
        if (x < 9) {
            if ("O ".equals(arrayBattleShip[x + 1][y])) {
                return false;
            }
        }
        // с слева
        if (y > 0) {
            if ("O ".equals(arrayBattleShip[x][y - 1])) {
                return false;
            }
        }
        // с права
        if (y < 9) {
            if ("O ".equals(arrayBattleShip[x][y + 1])) {
                return false;
            }
        }
        return true;
    }

    // количество ч

    private static int countPoint_o(String[][] arrayBattleShip) {

        int count = 0;

        for (int i = 0; i < arrayBattleShip.length; i++) {
            for (int j = 0; j < arrayBattleShip[i].length; j++) {
                if ("O ".equals(arrayBattleShip[i][j])) {
                    count++;
                }
            }
        }
        return count;
    }


    private static int length_coordinate(int[] coordinates_int) {
        return 1 + Math.abs(coordinates_int[0] - coordinates_int[2]) + Math.abs(coordinates_int[1] - coordinates_int[3]);
    }

    // инициализация массива
    private static void init_arrayBattleShip(String[][] arrayBattleShip) {
        for (int i = 0; i < arrayBattleShip.length; i++) {
            Arrays.fill(arrayBattleShip[i], "~ ");
        }
    }

    private static void print_arrayBattleShip(String[][] arrayBattleShip) {

        System.out.print("  ");
        for (int i = 0; i < arrayBattleShip.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayBattleShip.length; i++) {
            System.out.print(ALF.charAt(i) + " ");
            for (int j = 0; j < arrayBattleShip[i].length; j++) {
                System.out.print(arrayBattleShip[i][j]);
            }
            System.out.println();
        }

    }
}
