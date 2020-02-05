package itheima.File;

import java.io.File;
import java.io.IOException;

/**
 *
 *
 *
 */
public class Demo4 {
    public static void main(String[] args) {
        File file = new File("F:\\Github\\HuffManZig\\2.txt");
        try {
            boolean res = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.delete();
        File file2 = new File("F:\\Github\\HuffManZig\\2");
        file2.mkdir();
        File file3 = new File("F:\\test\\HuffManZig\\2");
        file3.mkdirs();
    }
}
