package day20.socket.socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上传文件，服务端
 */
public class FileUploadServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端已启动、、、、、");
        // 等待客户端上传数据
        Socket socket = serverSocket.accept();

        /**
         * 接收文件名和类型
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        String s = objectInputStream.readUTF();

        /**
         * 读取文件,并将读取过来的文件写到指定的目录下
         */
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        OutputStream outputStream = new FileOutputStream("F:\\" + s);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bytes = new byte[1024 * 1024];
        int length = 0;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        outputStream.close();
        socket.shutdownInput();
    }
}
