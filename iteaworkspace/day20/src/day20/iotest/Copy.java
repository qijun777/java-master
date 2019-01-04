package day20.iotest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        /*
            a.txt文件中的内容为：就发你让oinirhg@%*&%（）*954387
         */
        FileInputStream in = new FileInputStream("F:test\\aa\\a.txt");
        FileOutputStream out = new FileOutputStream("F:test\\bb\\b.txt");

        int read = in.read();
        while (read != -1) {
            out.write(read);
            out.flush();
            read = in.read();
        }

        out.close();
        in.close();
    }
}
