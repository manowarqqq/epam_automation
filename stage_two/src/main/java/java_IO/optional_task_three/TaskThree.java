package java_IO.optional_task_three;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskThree {
    // Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        File inputFile = new File(System.getProperty("user.dir") + "\\stage_two\\src\\main\\java\\java_IO\\optional_task_three\\TestClassThree.java");
        File outputFile = new File(System.getProperty("user.dir") + "\\stage_two\\src\\main\\resources\\outputThree.txt.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] string = line.toCharArray();
                line = "";
                for (int i = string.length - 1; i >= 0; i--) {
                    line += string[i];
                }
                lines.add(line);
            }
            for (int i = 0; i < lines.size() - 1; i++) {
                bw.write(lines.get(i));
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
