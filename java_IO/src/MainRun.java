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
            TreeUtil.tree(inputFile);
            if (inputPath.contains("result.txt")) {
                TreeUtil.countDirectories();
                TreeUtil.countFiles();
                TreeUtil.averageFilesinDirectory();
                TreeUtil.averageLengthOfFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (TreeUtil.bw != null)
                    TreeUtil.bw.close();
                if (TreeUtil.br != null)
                    TreeUtil.br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
