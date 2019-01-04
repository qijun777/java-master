package day20.iotest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 字节输出流
 * 作用：将a.txt中的内容复制给b.txt
 */
public class OutPutStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("F:test\\aa\\a.txt");
        FileOutputStream out = new FileOutputStream("F:test\\aa\\b.txt");

        // 创建一个字节数组
        byte[] bytes = new byte[1024];
        // 将in里的文字放入数组中
        in.read(bytes);
        // 用out读取数组中的文字
        out.write(bytes);
        // 输出这个字节数组
        System.out.println(new String(bytes));

        out.close();
        in.close();
    }
}
