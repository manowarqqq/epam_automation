import java.io.*;

import java.util.*;

public class Connect {
    private static String offset = "";

    static File resultFile = new File(System.getProperty("user.dir") + "\\java_IO\\src\\result.txt");
    static FileWriter fileWriter;
    static BufferedWriter bw;
    static FileReader fileReader;
    static BufferedReader br;


    static {
        try {
            fileWriter = new FileWriter(resultFile, true);
            bw = new BufferedWriter(fileWriter);
                      fileReader = new FileReader(resultFile);
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
                   Connect.getReport(file);
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
                Connect.tree(currentFile);
                offset = offset.substring(0, offset.length() - 5);
                continue;
            }
            bw.write(offset + currentFile.getName());
            bw.newLine();
        }
    }


    private static void getReport(File file) throws IOException {

        List<String> directories = new ArrayList<>();
        List<String> files = new ArrayList<>();
        String temp = null;
                   while ((temp = br.readLine()) != null) {
                if (temp.startsWith(" ")) {
                    files.add(temp.trim());
                } else if (temp.startsWith("-")) {
                    directories.add(temp.replace("-", " ".trim()));
                }
            }
    }

        public static  String countDirectories(List list) {


                       return "";
        }



    }

