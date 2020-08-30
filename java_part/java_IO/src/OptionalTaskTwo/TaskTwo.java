package OptionalTaskTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
 //   2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.


    public static void main(String[] args) {
        List<String> lines=new ArrayList();
        File inputFile = new File(System.getProperty("user.dir") + "\\java_IO\\src\\OptionalTaskTwo\\TestClass.java");
        File outputFile = new File(System.getProperty("user.dir") + "\\java_IO\\src\\OptionalTaskTwo\\output");
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
    String line;
    while((line=br.readLine()) != null) {
        line=line.replace("public","private");
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
