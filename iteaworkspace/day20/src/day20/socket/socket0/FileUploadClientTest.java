package day20.socket.socket0;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件上传，客户端
 */
public class FileUploadClientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("F:\\Youku Files\\download");
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + "：" + files[i].getName());
        }
        // 选择上传的文件
        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择要上传的文件：");
        int index = 0;
        while (true) {
            index = scanner.nextInt();
            if (index > 0 && index <= files.length) {
                break;
            } else {
                System.out.print("你输入的索引有误，请重新输入：");
            }
        }

        Socket socket = new Socket("192.168.0.122", 9999);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(files[index - 1]);
        objectOutputStream.flush();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(files[index - 1]));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        socket.shutdownOutput();

    }
}
