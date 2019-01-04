package day20.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 */
public class OutPutStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:a.txt");

        // 1.创建管道
        FileOutputStream out = new FileOutputStream(file,true);

        // 2.创建数据
        byte[] c = {'s','h','u','j','i','a'};
        out.write(c);


        // 3.关闭管道
        out.close();
    }
}
