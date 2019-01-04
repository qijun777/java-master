package day20.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 音乐
 */
public class MusicTest {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("F:\\music\\YUI - Rolling star.mp3");
        FileOutputStream out = new FileOutputStream("F:\\YUI - Rolling star.mp3");

        byte[] chars = new byte[102400000];
        int length = in.read(chars);

//        while(length != -1){
//            System.out.println(s);
//            length = in.read(chars);
//        }

        int a = 0;
        while ((a = in.read(chars)) != -1){
            out.write(a);
            out.flush();
        }

        out.close();
        in.close();
    }
}
