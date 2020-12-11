package java_IO;

import java.io.*;

import java.util.*;

public class TreeCreator {

    private String offset = "—————";
    private String innerOffset = "";
    static final File RESULT_FILE = new File(System.getProperty("user.dir") + "\\stage_two\\src\\main\\resources\\result.txt");
    BufferedWriter bw;


    TreeCreator() throws IOException {
        FileWriter fileWriter = new FileWriter(RESULT_FILE, true);
        bw = new BufferedWriter(fileWriter);
    }

    void buildTree(File file) throws IOException {
        offset = offset + "—————";
        if (file.getName().equals("result.txt"))
            return;
        else if (!(file.exists())) {
            System.out.println("Wrong path");
            return;
        } else if (file.isFile()) {
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
                buildTree(currentFile);
                offset = offset.substring(0, offset.length() - 5);
                innerOffset = innerOffset.substring(0, innerOffset.length() - 5);
                continue;
            }
            bw.write(innerOffset + "|" + offset + currentFile.getName());
            bw.newLine();
        }
    }


}


