package day20.socket.socket2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 上传文件，客户端
 */
public class FileUploadClientTest {
    public static void main(String[] args) throws IOException {
        /**
         * 选择需要上传的文件
         */
        // 选择想要上传的文件的上一级目录
        File file = new File("F:\\Youku Files\\download");
        // 获取文件夹中的所有文件
        File[] files = file.listFiles();
        System.out.println("文件目录如下：");
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + "：" + files[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要上传的文件索引：");
        int index = 0;
        while (true) {
            index = scanner.nextInt();
            if (index > 0 && index <= files.length) {
                break;
            } else {
                System.out.println("你输入的索引有误，请重新输入");
            }
        }
        // 获得选择的索引对应的文件
        File file1 = files[index - 1];

        /**
         * 上传选中文件的名字和类型
         * 为什么要上传这个：让服务器接收到文件的名字和类型来做这个文件的读取操作
         */
        Socket socket = new Socket("localhost", 9999);

//        FileOutputStream fileOutputStream = new FileOutputStream(socket.getOutputStream()); // 报错
//        FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(socket.getOutputStream())); // 这样才不报错
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeUTF(file1.getName());
        objectOutputStream.flush();

        /**
         * 上传选中的文件
         */
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        FileInputStream fileInputStream = new FileInputStream("F:\\Youku Files\\download\\" + file1.getName());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        System.out.println("文件正在下载......");
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }
        System.out.println("文件下载完毕");

        bufferedInputStream.close();
        fileInputStream.close();
        socket.shutdownOutput();
    }
}
