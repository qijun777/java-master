package hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
//        String s = "j,vr,vr";
//        String[] split = s.split(",");
//
//        if (split.length == 4) {
//            if (split[3].equals("") || split[3].equals(" ") || split.equals(null)) {
//                split[3] = "0";
//            }
//            System.out.println(split[3]);
//
//        System.out.println("---------------------");
//
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }
//        System.out.println(split.length);

        FileInputStream fileInputStream = new FileInputStream(new File("F:\\test\\aa\\d.txt"));
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = fileInputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, length);
            System.out.println(s);
            String[] split = s.split(",");
//            if (split.length == 4) {
//                if (split[3].equals("") || split[3].equals(" ") || split.equals(null)) {
                if (split[3] != null) {
                    System.out.println("null");
                    split[3] = "0";
                }
                if (split[3].equals("")) {
                    System.out.println("一致性");
                    split[3] = "0";
                }
                if (split[3].equals(" ")) {
                    System.out.println("空格");
                    split[3] = "0";
                }
                System.out.println("----------------1");
                for (int i = 0; i < split.length; i++) {
                    System.out.println(split[i]);
                }
                System.out.println("----------------2");
//            }
            System.out.println("3 = " + split[3]);
            System.out.println(split.length);
        }

        fileInputStream.close();
    }
}