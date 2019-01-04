package day20.socket.socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件下载，服务端
 */
public class FileDownLoadServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端启动");
        Socket socket = serverSocket.accept();

        File file = new File("F:\\Youku Files\\download");
        File[] files = file.listFiles();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(files);
        objectOutputStream.flush();

        /**
         * 接收索引
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        File file1 = (File) objectInputStream.readObject();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024 * 1024];
        int lengrh = 0;
        while ((lengrh = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, lengrh);
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        socket.shutdownInput();
        socket.shutdownOutput();

    }
}
