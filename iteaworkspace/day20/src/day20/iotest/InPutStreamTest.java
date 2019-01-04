package day20.iotest;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流
 */
public class InPutStreamTest {
    public static void main(String[] args) throws IOException {
        // 创建通道
        FileInputStream in = new FileInputStream("F:test\\aa\\a.txt");

        // 输入数据
        byte[] bytes = new byte[1024];
        int length = in.read(bytes);
        while (length != -1) {
            // 先将字节数组变成字符串，然后输出
            /*
                String(byte[] bytes, int offset, int length)
                通过使用平台的默认字符集解码指定的字节子阵列来构造新的String。
             */
            String s = new String(bytes, 0, length);
            System.out.print(s);
            length = in.read(bytes);
        }

        // 关闭通道
        in.close();
    }
}
