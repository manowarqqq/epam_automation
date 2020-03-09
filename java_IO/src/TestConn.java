import java.io.File;
import java.io.IOException;

public class TestConn {

    public static void main(String[] args) {
        File myFile =new File("D:/Java_test");
        try {
            Connect.tree(myFile);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                Connect.bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
