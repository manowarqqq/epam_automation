import java.util.Arrays;
import java.util.Scanner;

public class OptionalTaskThree {
//6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    public static void main(String[] args) {

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
            if (isDifferent == true && temp.length() > 1) {
                System.out.println("Число, цифры в котором идут в строгом порядке возрастания: " + numbers[j]);
            }
        }
    }
}