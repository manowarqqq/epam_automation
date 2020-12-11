import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to file");
        System.out.println("To get result  about output file enter path to result.txt file");
        String inputPath = scanner.nextLine();
        File inputFile = new File(inputPath);
        try {
            Tree.buildTree(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Tree.bw != null)
                    Tree.bw.close();
                if (Tree.br != null)
                    Tree.br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
