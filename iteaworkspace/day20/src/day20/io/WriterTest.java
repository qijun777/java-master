package day20.io;

import java.io.FileWriter;
import java.io.IOException;

public class WriterTest {
    public static void main(String[] args) throws IOException {
        // 1.创建管道
        FileWriter writer = new FileWriter("F:\\test\\aa\\a.txt");

        // 2.写数据
        writer.write("Joi积极");

        // 关闭管道
        writer.close();
    }
}
