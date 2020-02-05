package HuffmanCode;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) {


        String salt="123ac";
        InputStream is =null;
        OutputStream os = null;
        try {
            byte mimip[] =salt.getBytes();
            is = new FileInputStream("f:\\Github\\HuffManZig\\Demo\\d\\test.png");
            os = new FileOutputStream("f:\\Github\\HuffManZig\\Demo\\d\\new.png");
            byte buffer[] = new byte[is.available()];
            is.read(buffer);
            for(int i = 0;i<buffer.length;i++){
                buffer[i] =(byte) (buffer[i]^mimip[i%mimip.length]);
            }
            os.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
