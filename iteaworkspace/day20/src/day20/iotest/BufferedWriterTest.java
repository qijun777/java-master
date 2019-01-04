package day20.iotest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲输出流
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("F:test\\aa\\a.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        char[] chars = {'h','e','l','l','0',' ','w','o','r','l','d','&'};

        bufferedWriter.write("jiowe哦及服务*9*^%757!");
        bufferedWriter.newLine();
        bufferedWriter.write(chars);

        bufferedWriter.close();
        writer.close();
    }
}
