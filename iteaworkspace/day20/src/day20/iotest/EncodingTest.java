package day20.iotest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EncodingTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("F:\\test\\aa\\d.txt");

        char[] chars = new char[1024];
        int i = fileReader.read(chars);
        String s = new String(chars);
        System.out.println(s);

        fileReader.close();
    }
}
