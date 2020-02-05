package itheima.IOStream;

import java.io.*;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("F:\\Github\\HuffManZig\\Demo\\1.txt");
        String str = "你好小怪兽";
        byte arr[] = str.getBytes();
        out.write(arr,0,3);
        out.close();
    }
}
