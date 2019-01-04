package day20.socket.socket0;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传，服务端
 */
public class FileUploadServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        File file = (File) objectInputStream.readObject();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\" + file.getName()));
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        socket.shutdownInput();
    }
}
