package itheima.IOStream;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
       OutputStream out = new FileOutputStream("F:\\Github\\HuffManZig\\Demo\\1.txt");
       out.write(97);
       out.write(98);
       out.write(99);
       out.write(100);
       out.write(101);
       out.write(102);
       out.close();

        InputStream in =new FileInputStream("F:\\Github\\HuffManZig\\Demo\\1.txt");
        byte []arr = new byte[15];
        int len;
        while((len=in.read(arr))!=-1){
            System.out.print(new String(arr).substring(0,6));
        }
    }
}
