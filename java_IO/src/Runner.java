import java.io.*;
import java.util.Arrays;

public class Runner {




    public static void rec(BufferedWriter bw, File file) throws IOException {

        File[] files = file.listFiles();
        for (File currentFile : files) {
            if(currentFile.isDirectory()) {
                Runner.rec(bw,currentFile);
            }
            bw.write(currentFile.getName());
            bw.newLine();
            }
           }





    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Java_test");
        File resultFile = new File("D:\\V\\Epam_automation\\java_IO\\src\\result.txt");

        try(BufferedWriter bw =new BufferedWriter(new FileWriter(resultFile))) {
            Runner.rec(bw,file);
        }

    }
}
