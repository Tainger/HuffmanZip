package HuffmanCode;

public class Demo2 {
    public static void main(String[] args) {
        byte a =100;//1100100
        byte c = 99;//1100011
        byte b = (byte) ( a^c);
        int d =  ( a^c);
        System.out.println(b);
        System.out.println(d);
        a = (byte)(b^c);
        System.out.println(a);
    }
}
