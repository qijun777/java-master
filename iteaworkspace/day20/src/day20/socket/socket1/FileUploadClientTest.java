package day20.socket.socket1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件上传客户端
 */
public class FileUploadClientTest {
    public static void main(String[] args) throws IOException {
        /*
            选择需要上传的文件
         */
        File file = new File("F:\\Youku Files\\download");
        System.out.println("文件目录：");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + "：" + files[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        if (!(index <= files.length && index > 0)) {
            System.out.print("请选择需要上传的文件：");
            index = scanner.nextInt();
        }

        // 获取需要上传的文件
        File file1 = files[index - 1];

        // 和服务器建立连接
        Socket socket = new Socket("localhost", 9999);


        /**
         * 上传文件之前需要告诉客户端上传文件的名字和类型
         */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeUTF(file1.getName());
        objectOutputStream.flush();

        /**
         * 上传文件给服务端
         */
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
        System.out.println("文件开始上传......");
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }
        System.out.println("文件上传成功");

        bufferedInputStream.close();
        socket.shutdownOutput();

    }
}
