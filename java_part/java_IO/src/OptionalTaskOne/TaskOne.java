package optionalTaskOne;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TaskOne {
    //1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbersList = new ArrayList<>();
        File inputFile = new File(System.getProperty("user.dir") + "\\java_part\\java_IO\\src\\OptionalTaskOne\\numbers.txt");
        File outputFile = new File(System.getProperty("user.dir") + "\\java_part\\java_IO\\src\\OptionalTaskOne\\sorted_numbers.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
             BufferedWriter bow = new BufferedWriter(new FileWriter(outputFile));
             BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            for (int i = 0; i < 10000; i++) {
                bw.write(String.valueOf(random.nextInt(1000)));
                bw.write(" ");
            }
            bw.flush();
            String line;

            while ((line = br.readLine()) != null) {

                String[] nums = line.split(" ");
                for (String s : nums) {
                    numbersList.add(Integer.valueOf(s));
                }
            }
            Collections.sort(numbersList);

            for (int i = 0; i < numbersList.size() - 1; i++) {
                bow.write(String.valueOf(numbersList.get(i)));
                bow.write(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
