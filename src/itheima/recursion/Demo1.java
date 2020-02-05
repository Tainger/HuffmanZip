package itheima.recursion;

import java.io.File;

public class Demo1 {

    public static void main(String[] args) {
        File file = new File("F:\\javaproject\\HuffManZig\\test");
        getAllFiles(file);
    }

    public static void  getAllFiles(File file){
        File listFile[]=file.listFiles();
        for(File f:listFile){
            if(f.isDirectory()){
                getAllFiles(f);
            }else{
                if(f.getName().endsWith(".java"))
                    System.out.println(f);
            }

        }
    }


}
