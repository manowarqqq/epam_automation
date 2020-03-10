import java.io.*;

import java.util.*;

public class TreeUtil {
    private static String offset = "";
    private static File resultFile = new File(System.getProperty("user.dir") + "\\java_IO\\src\\result.txt");
    private static List<String> directories;
    private static List<String> files;
    static BufferedWriter bw;
    static BufferedReader br;

    static {
        try {
            FileWriter fileWriter = new FileWriter(resultFile, true);
            bw = new BufferedWriter(fileWriter);
            FileReader fileReader = new FileReader(resultFile);
            br = new BufferedReader(fileReader);
        } catch (final IOException e) {
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }


    public static void tree(File file) throws IOException {
        offset += "     ";
        if (!(file.exists())) {
            System.out.println("Wrong path");
            return;
        }
        if (file.isFile()) {
            if (file.getName().equals("result.txt")) {
                TreeUtil.getReport(file);
                return;
            }
            bw.write(file.getName());
            bw.newLine();
            return;
        }
        File[] files = file.listFiles();
        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory()) return o2.isDirectory() ? o1.compareTo(o2) : 1;
            else if (o2.isDirectory()) return -1;
            return o1.compareTo(o2);
        });
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                bw.write(offset.replace(" ", "-") + currentFile.getName());
                bw.newLine();
                TreeUtil.tree(currentFile);
                offset = offset.substring(0, offset.length() - 5);
                continue;
            }
            bw.write(offset + currentFile.getName());
            bw.newLine();
        }
    }


    private static void getReport(File file) throws IOException {
        directories = new ArrayList<>();
        files = new ArrayList<>();
        String temp = null;
        while ((temp = br.readLine()) != null) {
            if (temp.startsWith(" ")) {
                files.add(temp.trim());
            } else if (temp.startsWith("-")) {
                directories.add(temp.replace("-", " ".trim()));
            }
        }
    }

    public static void countDirectories() {
        System.out.println("Number of directories: " + directories.size());

    }

    public static void countFiles() {
        System.out.println("Number of files: " + files.size());
    }


    public static void averageFilesinDirectory() {
        System.out.println("Average number of files in directory: " + TreeUtil.files.size() / TreeUtil.directories.size());
    }

    public static void averageLengthOfFile() {
        int length = 0;
        for (String s : TreeUtil.files) {
            length += s.length();
        }
        float result = length / TreeUtil.files.size();
        System.out.println("Average length of file: " + result);
    }

}

