package itheima.File;

import java.io.File;

/**
 *
 *
 *
 */
public class Demo5 {
    public static void main(String[] args) {
        File file = new File("F:\\Github\\HuffManZig");
        String str[] = file.list();
        for (String s : str) {
            System.out.println(s);
        }
        File []file1 =file.listFiles();
        for(File file2:file1){
            System.out.println(file2);
        }
    }
}

