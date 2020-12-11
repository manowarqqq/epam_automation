package java_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TreeParser {

    BufferedReader br;
    private List<String> listDirectories;
    private List<String> listFiles;

    TreeParser() throws FileNotFoundException {
        listDirectories = new ArrayList<>();
        listFiles = new ArrayList<>();
        FileReader fileReader = new FileReader(TreeCreator.RESULT_FILE);
        br = new BufferedReader(fileReader);
    }

    void makeReport() throws IOException {
        String temp;
        while ((temp = br.readLine()) != null) {
            if (temp.contains("\\")) {
                listDirectories.add(temp.replaceAll("[|—\\\\]", "").trim());
            } else
                listFiles.add(temp.replace("-", "".trim()));
        }
        countFiles();
        countDirectories();
        averageFilesinDirectory();
        averageLengthOfFile();
    }

    private void countDirectories() {
        System.out.println("Number of directories: " + listDirectories.size());

    }

    private void countFiles() {
        System.out.println("Number of files: " + listFiles.size());
    }


    private void averageFilesinDirectory() {
        if (listDirectories.size() == 0) {
            System.out.println("Noone directory");
            return;
        }
        System.out.println("Average number of files in directory: " + listFiles.size() / listDirectories.size());
    }

    private void averageLengthOfFile() {
        int length = 0;
        for (String s : listFiles) {
            length += s.length();
        }
        if (listFiles.size() == 0) {
            System.out.println("Noone file");
            return;
        }
        double result = length / listFiles.size();
        System.out.println("Average length of file: " + result);
    }

}
