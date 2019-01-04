package day20.io;

import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        // 1.搭建管道
        FileReader reader = new FileReader("F:\\test\\aa\\a.txt");

        // 2.读数据
        char[] b = new char[1024];
        int length = reader.read(b);
        String s = new String(b, 0, length);
        System.out.println(s);

        // 关闭管道
        reader.close();

    }
}
