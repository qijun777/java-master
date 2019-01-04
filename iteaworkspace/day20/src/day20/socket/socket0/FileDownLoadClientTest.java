package day20.socket.socket0;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件下载客户端
 */
public class FileDownLoadClientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8888);

        /**
         * 2.根据服务器提供的下载目录路径，获取可以下载的文件列表
         */
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        File[] files = (File[]) objectInputStream.readObject();

        System.out.println("可以下载的文件列表：");
//        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + "：" + files[i].getName());
        }

        /**
         * 3.根据提供的下载列表，选择要下载的文件
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择要下载的文件：");
        int index = 0;
        while (true) {
            index = scanner.nextInt();
            if (index > 0 && index <= files.length) {
                break;
            } else {
                System.out.print("你输入的有误，请重新输入：");
            }
        }
        System.out.println("开始下载文件.......");

        /**
         * 4.根据选择的索引下载相应的文件(客户端向服务端输出文件对象)
         */
        // 根据获取的索引获取需要下载的文件
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(files[index - 1]);
        objectOutputStream.flush();

        /**
         * 7.接收服务端传入的文件，并输出到自定义的文件保存路径中
         */
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        // 创建新目录接收文件
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\" + files[index - 1].getName());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024*1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        fileOutputStream.close();
        socket.shutdownInput();
        socket.shutdownOutput();
    }
}
