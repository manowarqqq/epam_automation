import java.util.Arrays;
import java.util.Scanner;

public class OptionalTaskOne {
    // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину. (Самое маленькое число является самим коротким)
    public static void findShorrtestNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int arraySize = scan.nextInt();
        int[] array = new int[arraySize];
        System.out.println("Введите числа массива");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(min);

// for max:
//        int max = array[0];
//        for (int i = 0; i < array.length; i++) {
//            if (max <
//                    array[i]) {
//                max = array[i];
//            }
//        }
//        System.out.println(max);
    }

    public static void findNumberWithMinDifferentDigit() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int[] array = new int[scan.nextInt()];
        System.out.println("Введите числа миссива");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        int[] numbers = Arrays.copyOf(array, array.length);
        int minIndexinArray = 0;
        int[] digitsCount = new int[10];
        int[] differentDigitsCount = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != 0) {
                digitsCount[Math.abs((numbers[i] % 10))]++;
                numbers[i] /= 10;
            }
            for (int j = 0; j < 10; j++) {
                if (digitsCount[j] > 0) differentDigitsCount[i]++;
            }
            digitsCount = new int[10];
        }
        int min = differentDigitsCount[0];
        for (int i = 0; i < differentDigitsCount.length; i++) {
            if (differentDigitsCount[i] < min) {
                min = differentDigitsCount[i];
                minIndexinArray = i;
            }
        }
        System.out.println("Число, в котором количество различных цифр минимально: " + array[minIndexinArray]);
    }

    public static void main(String[] args) {
        findShorrtestNumber();
        findNumberWithMinDifferentDigit();
    }
}