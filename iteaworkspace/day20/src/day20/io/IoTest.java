package day20.io;

import java.io.File;

public class IoTest {
    public static void main(String[] args) {
        File file = new File("E:\\iteajava\\java\\src\\com\\shujia");
        digui(file);
    }

    public static void digui(File file){
        if(file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File f : files) {
                    digui(f);
                }
            }else{
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
