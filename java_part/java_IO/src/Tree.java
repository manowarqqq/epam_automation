import java.io.*;

import java.util.*;

public class Tree {

    private static String offset = "—————";
    private static String innerOffset = "";
    private static File resultFile = new File(System.getProperty("user.dir") + "\\java_part\\java_IO\\src\\result.txt");
    static List<String> listDirectories;
    static List<String> listFiles;
    static BufferedWriter bw;
    static BufferedReader br;

    static {
        listDirectories = new ArrayList<>();
        listFiles = new ArrayList<>();
        try {
            FileWriter fileWriter = new FileWriter(resultFile, true);
            bw = new BufferedWriter(fileWriter);
            FileReader fileReader = new FileReader(resultFile);
            br = new BufferedReader(fileReader);
        } catch (final IOException e) {
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }

    static void buildTree(File file) throws IOException {
        offset = offset + "—————";
        if (!(file.exists())) {
            System.out.println("Wrong path");
            return;
        }
        if (file.isFile()) {
            if (file.getName().equals("result.txt")) {
                makeReport();
                TreeUtils.countFiles();
                TreeUtils.countDirectories();
                TreeUtils.averageFilesinDirectory();
                TreeUtils.averageLengthOfFile();
                return;
            }
            bw.write(file.getName());
            bw.newLine();
            return;
        }
        File[] files = file.listFiles();
        assert files != null;
        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory()) return o2.isDirectory() ? o1.compareTo(o2) : 1;
            else if (o2.isDirectory()) return -1;
            return o1.compareTo(o2);
        });
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                bw.write(innerOffset + "|" + offset + "\\" + currentFile.getName());
                bw.newLine();
                innerOffset = innerOffset + "     ";
                Tree.buildTree(currentFile);
                offset = offset.substring(0, offset.length() - 5);
                innerOffset = innerOffset.substring(0, innerOffset.length() - 5);
                continue;
            }
            bw.write(innerOffset + "|" + offset + currentFile.getName());
            bw.newLine();
        }
    }

    private static void makeReport() throws IOException {
        String temp;
        while ((temp = br.readLine()) != null) {
            if (temp.contains("\\")) {
                listDirectories.add(temp.replaceAll("[|—\\\\]", "").trim());
            } else
                listFiles.add(temp.replace("-", "".trim()));
        }
    }
}


