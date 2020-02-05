package itheima.recursion;

public class Demo2 {

    public static void main(String[] args) {
        int a =add(5);
        System.out.println(a);
    }

    public  static  int add(int n){
        if(n==1)
            return 1;
       return n*add(n-1);
    }
}

