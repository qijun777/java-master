package day20.socket.socket2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件下载，客户端
 */
public class FileDownLoadClientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 9999);

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        File[] files = (File[]) objectInputStream.readObject();
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + "：" + files[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (true) {
            System.out.print("请选择要下载的文件：");
            index = scanner.nextInt();
            if (index <= files.length && index > 0) {
                break;
            } else {
                System.out.print("你输入的索引有误，请重新输入：");
            }
        }

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(files[index - 1]);
        objectOutputStream.flush();

        /**
         * 接收文件
         */
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\" + files[index - 1].getName()));
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        socket.shutdownOutput();
        socket.shutdownInput();
    }
}
