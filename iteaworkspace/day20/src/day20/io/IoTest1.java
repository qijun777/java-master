package day20.io;

import java.io.File;

public class IoTest1 {
    public static void main(String[] args) {
        File file = new File("E:\\iteajava\\java\\src\\com\\shujia");
        point(file);
    }

    public static void point(File file){
        if(file.isFile()){
            System.out.println(file.getAbsolutePath());
        }else{
            File[] files = file.listFiles();
            for(File f : files){
                point(f);
            }
        }
    }
}
