package day20.iotest;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("E:\\iteajava\\java\\data\\students.txt");

        // 字节输入流与字节输出流就一点区别：数组类型不同
        // char[] chars = new char[10240];也可以
        char[] chars = new char[1024];
        int length = reader.read(chars);
        while (length != -1) {
            String s = new String(chars, 0, length);
            System.out.print(s);
            length = reader.read(chars);
        }

        reader.close();
    }
}
