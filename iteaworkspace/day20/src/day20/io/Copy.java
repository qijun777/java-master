package day20.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Copy {
    public static void main(String[] args) throws Exception {
        // 1.打开管道
        FileInputStream in = new FileInputStream("F:\\test\\aa\\a.txt");
        FileOutputStream out = new FileOutputStream("F:\\test\\bb\\b.txt");

        // 2.读取数据，同时写出
        int b = in.read();
        while(b != -1){
            out.write(b);
            // 读取下一个
            b = in.read();
        }

        // 3.关闭管道
        in.close();
        out.close();
        System.out.println("复制成功");
    }
}
