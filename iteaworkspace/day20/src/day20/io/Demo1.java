package day20.io;

import java.util.Arrays;

/**
 * 1.实现字符串和字节数组之间的相互转换。必如将字符串“北京尚学堂bjsxt”转换为字节数组，
 * 并将字节数组再转换回字符串。
 */
public class Demo1 {
    public static void main(String[] args) {
        String s = "北京尚学堂bjsxt";

        // 将字符串转换为字节数组
        byte[] bytes = s.getBytes();
        for(int i = 0; i < bytes.length; i++){
            System.out.print(bytes[i]);
        }
        System.out.println();

        // 将字节数组转换回字符串
        /*
            String(byte[] bytes)
            通过使用平台的默认字符集解码指定的字节数组来构造新的String。
         */
        String s1 = new String(bytes);
        System.out.println("s1 = " + s1);
    }
}
