package HuffmanCode;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        String salt="123ac";
        InputStream is =null;
        OutputStream os =null;
        try {
        is = new FileInputStream("F:\\Github\\HuffManZig\\Demo\\d\\xiaoji.png");
        byte []buffer = new byte[is.available()];
        is.read(buffer);
        os = new FileOutputStream("F:\\Github\\HuffManZig\\Demo\\d\\test.png");
        byte mimip[] =salt.getBytes();
        for(int i=0 ;i<buffer.length;i++){
            buffer[i] =(byte) (buffer[i]^mimip[i%mimip.length]);
        }
        os.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


}
class User implements Serializable{
    private String name;
    private String password;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}