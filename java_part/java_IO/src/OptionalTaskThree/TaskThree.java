package OptionalTaskThree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskThree {
    // Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

    public static void main(String[] args) {
        List<String> lines=new ArrayList();
        File inputFile = new File(System.getProperty("user.dir") + "\\java_IO\\src\\OptionalTaskThree\\TestClassThree.java");
        File outputFile = new File(System.getProperty("user.dir") + "\\java_IO\\src\\OptionalTaskThree\\outputThree");
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while((line=br.readLine()) != null) {
                System.out.println(line);
            char[] string=line.toCharArray();
            line="";
                for(int i=string.length-1;i>=0;i--){
                    line+=string[i];
                }
                System.out.println(line);
                lines.add(line);
            }
            for(int i=0;i<lines.size()-1;i++) {
                bw.write(lines.get(i));
                bw.newLine();
            }
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
