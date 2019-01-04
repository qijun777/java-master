package day20.iotest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 */
public class WriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("F:test\\aa\\b.txt");

        char[] chars = {'j','a','v','a'};

        writer.write(chars);

        writer.close();
    }
}
