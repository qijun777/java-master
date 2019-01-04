package day20.iotest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符缓冲输入流
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("F:test\\aa\\a.txt");

        BufferedReader bufferedReader = new BufferedReader(reader);

        String s = bufferedReader.readLine();
        while (s != null) {
            System.out.println(s);
            s = bufferedReader.readLine();
        }

        bufferedReader.close();
        reader.close();
    }
}
