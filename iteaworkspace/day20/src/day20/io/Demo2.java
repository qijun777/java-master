package day20.io;

import java.io.*;

/**
 * 2.实现字节数组和任何基本类型和引用类型执行的相互转换
 * 提示：使用ByteArrayInutStream和ByteArrayOutputStream。
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("F:\\test\\aa\\a.txt");
        FileOutputStream out = new FileOutputStream("F:\\test\\bb\\b.txt");

        byte[] bytes = new byte[1024];
        ByteArrayInputStream in1 = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();

        int length = in.read(bytes);
        String s = new String(bytes,0,length);
//        out1.write(length);
        System.out.println(s);

        in1.close();
        out1.close();
        in.close();
        out.close();
    }
}
