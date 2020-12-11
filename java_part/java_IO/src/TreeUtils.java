public class TreeUtils {


    static void countDirectories() {
        System.out.println("Number of directories: " + Tree.listDirectories.size());

    }

    static void countFiles() {
        System.out.println("Number of files: " + Tree.listFiles.size());
    }


    static void averageFilesinDirectory() {
        System.out.println("Average number of files in directory: " + Tree.listFiles.size() / Tree.listDirectories.size());
    }

    static void averageLengthOfFile() {
        int length = 0;
        for (String s : Tree.listFiles) {
            length += s.length();
        }
        float result = length / Tree.listFiles.size();
        System.out.println("Average length of file: " + result);
    }

}
