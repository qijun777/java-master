package day20.iotest;

import java.io.*;

/**
 * 3.分别使用文件流和缓冲流复制一个长度大于100MB的视频文件，并观察效率的差异。4
 */
public class Test3_1 {
    public static void main(String[] args) throws IOException {
        // 用缓冲流复制视频文件
//        FileInputStream fileInputStream = new FileInputStream("F:\\Youku Files\\download\\FatestaynightHeaven’sFeel_超清.kux");
//        FileOutputStream fileOutputStream = new FileOutputStream("F:\\(-_-).kux");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        byte[] bytes = new byte[1024];
//        int length = 0;
//        while ((length = bufferedInputStream.read(bytes)) != -1) {
//            bufferedOutputStream.write(bytes, 0, length);
//            bufferedOutputStream.flush();
//        }
//        bufferedOutputStream.close();
//        bufferedInputStream.close();
//        fileOutputStream.close();
//        fileInputStream.close();

        // 用缓冲流复制音频文件
        FileInputStream fileInputStream = new FileInputStream("F:\\music\\YUI - Rolling star.mp3");
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\(@^-^@).mp3");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024];
        int length = 0;
        while((length = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,length);
            bufferedOutputStream.flush();
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
}
