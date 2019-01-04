package day20.socket.socket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件下载服务端
 */
public class FileDownLoadServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端已启动......");


        File file = new File("F:\\Youku Files\\download");
        File[] files = file.listFiles();
        /**
         * 建立多个联系的时候才有while(true)
         *
         */
//        while (true) {
        /**
         * Socket socket = serverSocket.accept();这行放在死循环外面会报错---java.net.SocketException: Socket output is shutdown
         * 但不影响文件的下载。
         * Socket socket = serverSocket.accept();放在死循环里面不会报错但程序一直在运行必须手动关闭（？）
         */
        Socket socket = serverSocket.accept();
        /**
         * 1.向客户端提供查询文件列表功能
         */
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(files);
        objectOutputStream.flush();

        /**
         * 4.根据客户端提供的索引读写相应的文件
         */
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        File file1 = (File) objectInputStream.readObject();

        System.out.println(socket.getInetAddress() + "正在下载" + file1.getName());
        FileInputStream fileInputStream = new FileInputStream(file1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        fileInputStream.close();
//            objectInputStream.close();
//            objectOutputStream.close();
        socket.shutdownOutput();
        socket.shutdownInput();
        System.out.println("文件下载完成");
//        }
    }
}
