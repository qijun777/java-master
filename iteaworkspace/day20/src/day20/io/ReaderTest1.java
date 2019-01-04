package day20.io;

import java.io.FileReader;
import java.io.IOException;

public class ReaderTest1 {
    public static void main(String[] args) throws IOException {
        // 1.创建管道
        FileReader r = new FileReader("F:\\test\\aa\\a.txt");
        // 2.读数据
        char[] chars = new char[1024];
        int length = r.read(chars);
        String s = new String(chars,0,length);
        System.out.println(s);
        // 3.关闭管道
        r.close();
    }
}
