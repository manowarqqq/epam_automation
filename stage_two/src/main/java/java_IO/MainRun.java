package java_IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) {
        TreeCreator treebuilder = null;
        TreeParser parser = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to file");
        System.out.println("To get result  about output.txt file enter path to result.txt file");
        String inputPath = scanner.nextLine();
        File inputFile = new File(inputPath);

        try {
            treebuilder = new TreeCreator();
            parser = new TreeParser();
            if (inputFile.getName().equals("result.txt"))
                parser.makeReport();
            treebuilder.buildTree(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (treebuilder.bw != null)
                    treebuilder.bw.close();
                if (parser.br != null)
                    parser.br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
