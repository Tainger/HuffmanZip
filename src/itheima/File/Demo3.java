package itheima.File;

import java.io.File;
import java.io.IOException;

/**
 *
 *
 *
 */
public class Demo3 {
    public static void main(String[] args) {
        File file = new File("F:\\Github\\HuffManZig\\1.txt");

        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //返回绝对路径
        String str1 =file.getAbsolutePath();
        System.out.println(str1);
        //返回构造方法中传递的路径
        String str2 = file.getPath();
        System.out.println(str2);
        //文件的名称
        String str3 = file.getName();
        System.out.println(str3);
        //长度
        long a = file.length();
        System.out.println(a);

        Boolean res = file.exists();
        System.out.println(res);
        Boolean res1 = file.isDirectory();
        System.out.println(res1);
        Boolean res2 = file.isFile();
        System.out.println(res2);

    }
}
