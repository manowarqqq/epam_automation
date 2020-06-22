import java.util.Arrays;
import java.util.Scanner;

public class OptionalTaskOne {
    // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
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

    //   2.     Вывести числа в порядке возрастания (убывания) значений их длины.
    private static void getSortedArrayByLength(int[] arr) {
        int temp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (Integer.toString(arr[i + 1]).length() > Integer.toString(arr[i]).length()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    // 3.     Вывести на консоль те числа, длина которых больше средней длины по всем числам, а также длину.

    public static void findNumbersWithLengthMoreThanAverage(int[] arr) {
        int averageLength = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            length += Integer.toString(arr[i]).length();
            if (i == arr.length - 1)
                averageLength = length/arr.length;
        }
        for(int i = 0; i < arr.length; i++) {
            if( Integer.toString(arr[i]).length()>averageLength)
                System.out.println(arr[i]+" length: "+Integer.toString(arr[i]).length());
        }
    }


    //4. Найти число, в котором количество различных цифр минимально
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



    //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    public static void findNumberWithIncreasedDigits() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int[] numbers = new int[scan.nextInt()];
        System.out.println("Введите числа массива");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }
        int[] tempNumber = Arrays.copyOf(numbers, numbers.length);

        for (int j = 0; j < tempNumber.length; j++) {
            String temp = String.valueOf(tempNumber[j]);
            boolean isDifferent = true;
            int[] tempArray = new int[temp.length()];
            for (int i = tempArray.length - 1; i >= 0; i--) {
                tempArray[i] = Math.abs(tempNumber[j]) % 10;
                tempNumber[j] /= 10;
            }

            for (int k = 0; k < tempArray.length - 1; k++) {

                if (tempArray[k] >= tempArray[k + 1]) {
                    isDifferent = false;
                    break;
                }
            }
            if (isDifferent && temp.length() > 1) {
                System.out.println("Число, цифры в котором идут в строгом порядке возрастания: " + numbers[j]);
            }
        }
    }


}