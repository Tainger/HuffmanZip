package itheima.File;

import java.io.File;

/**
 *       绝对路径与相对路径
 *
 *       绝对路径：
 *          以c盘和d盘是一个完整路径，
 *              c:\\a.txt
 *              c:\\Users\\itcast\\IdeaProject\\shungyuan\\123.txt
 *        相对路径：是一个简化路径， c:\\Users\\itcast\\IdeaProject\\shungyuan
 *                相对是相对于当前目录的根目录
 *                如果使用当前目录的根目录可以简化书写。
 *                 c:\\Users\\itcast\\IdeaProject\\shungyuan\\123.txt
 *                                                       改写成123.txt
 *
 *         注意：路径是不区分大小写的，
 *              路径的中文名称分隔符windows使用的反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 *
 *
 */
public class Demo2 {
    public static void main(String[] args) {

        File file = new File("F:\\Github\\HuffManZig\\1.txt");
        System.out.println(file);
        File file2 = new File("F:\\Github\\HuffManZig\\","2.txt");
        System.out.println(file2);
        File file3 = new File("F:\\Github\\HuffManZig");
        String s ="3.txt";
        File file5 = new File(file3,s);
        System.out.println(file5);

    }
}
