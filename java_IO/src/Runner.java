import javafx.beans.binding.When;

import java.io.*;

import java.util.*;

public class Runner {
    public static String offset = "";


    public static File resultFile= new File(System.getProperty("user.dir") + "\\java_IO\\src\\result2.txt");
    public static BufferedWriter bw;


    static {
        try {
            bw = new BufferedWriter(new FileWriter(resultFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tree(File file) throws IOException {
        offset += "     ";
        if(!(file.exists())) {
            System.out.println("Wrong path");
            return;
        }
        if (file.isFile()) {
            if (file.getName().equals("result.txt")) {
                getAreport(file);
                return;
            }
            bw.write(file.getName());
            bw.newLine();
            return;
        }
        File[] files = file.listFiles();
        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory())
                return o2.isDirectory() ? o1.compareTo(o2) : 1;
            else if (o2.isDirectory())
                return -1;

            return o1.compareTo(o2);
        });
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                bw.write(offset.replace(" ", "-") + currentFile.getName());
                bw.newLine();
                Runner.tree(currentFile);
                continue;
            }
            bw.write(offset + currentFile.getName());
            bw.newLine();
        }
    }

    private static void getAreport(File file) {
        BufferedReader   br = null;
        List<String> directories = new ArrayList<>();
        List<String> files = new ArrayList<>();
        String temp=null;
        try {
            br=new BufferedReader(new FileReader(file.getAbsolutePath()));
            while((temp=br.readLine()) !=null) {
                if(temp.startsWith(" ")) {
                    files.add(temp.trim());
                } else if (temp.startsWith("-")) {
                    directories.add(temp.replace("-"," ".trim()));
                }
            }
            System.out.println(directories);
            System.out.println(files);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br !=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter path to file");
//        String inputPath = scanner.nextLine();
//        File inputFile = new File(inputPath);
//        Runner.rec(inputFile);
//        bw.close();
      String inputPath="D:\\V\\Epam_automation\\java_IO\\src\\result.txt";
     File file=new File(inputPath);
        Runner.tree(file);
       bw.close();

    }
}
