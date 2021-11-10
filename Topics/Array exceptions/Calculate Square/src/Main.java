class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here

        if (index >= array.length || index < 0 || array == null   ) {
            System.out.println("Exception!");
        } else System.out.println(array[index] * array[index]);

    }
}