package day20.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流
 */
public class InPutStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\a.txt");

        // 1.搭建管道
        FileInputStream in = new FileInputStream(file);
        // 2.读取数据
        // in.read() 一个一个读取，如果到末尾返回-1
//        int read = in.read();
//        while(read != -1){
//            System.out.print((char)read);
//            read = in.read();
//        }
        byte[] a = new byte[1024];
        int size = in.read(a);
        while(size != -1){
            String s = new String(a, 0, size, "GBK");
            System.out.println(s);
            size = in.read(a);
        }
        // 3.关闭管道
        in.close();
    }
}
