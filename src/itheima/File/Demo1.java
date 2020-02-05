package itheima.File;

import java.io.File;

/**
 * java.io.File类
 * 文件和目录路径名的抽象表示形式。
 * java把电脑中的文件和文件夹（目录）封装为了一个File类，我们可以使用File类对文件和文件夹进行操作
 * 我们可以使用File类的方法
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        String a = File.separator;
        char b = File.separatorChar;
        System.out.println(a);
        System.out.println(b);

        String c = File.pathSeparator;
        char d= File.pathSeparatorChar;
        System.out.println(c);
        System.out.println(d);

    }
}
