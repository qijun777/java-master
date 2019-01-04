package day20.iotest;

import java.io.*;

/**
 * 3.分别使用文件流和缓冲流复制一个长度大于100MB的视频文件，并观察效率的差异。
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        // 文件流  这样写有问题，有字符数组写可以运行，但得到的视频文件不能播放，且复制的视频文件比源文件大了近一倍
//        FileReader fileReader = new FileReader("F:\\Youku Files\\download\\FatestaynightHeaven’sFeel_超清.kux");
//        FileWriter fileWriter = new FileWriter("F:\\a.kux");
//
//        char[] bytes = new char[600];
//        int length = 0;
//        while((length = fileReader.read(bytes)) != -1){
//            fileWriter.write(bytes,0,length);
//
//        }
//        fileWriter.close();
//        fileReader.close();

        // 文件流
//        FileInputStream fileInputStream = new FileInputStream("F:\\Youku Files\\download\\FatestaynightHeaven’sFeel_超清.kux");
//        FileOutputStream fileOutputStream = new FileOutputStream("F:\\a.kux");
//        byte[] bytes = new byte[1024];
//        int length = 0;
//        while ((length = fileInputStream.read(bytes)) != -1) {
//            fileOutputStream.write(bytes, 0, length);
//            fileOutputStream.flush();
//        }
//        fileOutputStream.close();
//        fileInputStream.close();

        // 缓冲流
//        FileInputStream fileInputStream = new FileInputStream("F:\\Youku Files\\download\\FatestaynightHeaven’sFeel_超清.kux");
//        FileOutputStream fileOutputStream = new FileOutputStream("F:\\a.kux");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        byte[] bytes = new byte[1024];
//        int length = 0;
//        while ((length = bufferedInputStream.read(bytes)) != -1) {
//            bufferedOutputStream.write(bytes, 0, length);
//            bufferedOutputStream.flush();
//        }
//        fileOutputStream.close();
//        fileInputStream.close();
    }
}
