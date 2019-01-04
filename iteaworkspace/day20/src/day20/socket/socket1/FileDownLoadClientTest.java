package day20.socket.socket1;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件下载客户端
 */
public class FileDownLoadClientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 9999);

        /**
         * 2.查看可下载的文件列表
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        File[] files = (File[]) objectInputStream.readObject();

        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + "：" + files[i].getName());
        }

        /**
         * 3.选择要下载的文件
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("选择要下载的文件：");
        int index = 0;
        while (true) {
            index = scanner.nextInt();
            if (index <= files.length && index > 0) {
                break;
            } else {
                System.out.print("你输入的有误，请重新输入：");
            }
        }
        // 将选择好的索引返回给服务器
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(files[index - 1]);
        objectOutputStream.flush();

        /**
         * 接收服务端发送的文件并存在磁盘中
         */
        System.out.println("正在下载文件......");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\" + files[index - 1].getName());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        fileOutputStream.close();
//        objectOutputStream.close();
        socket.shutdownInput();
        socket.shutdownOutput();
        System.out.println("文件下载完成");
    }
}
