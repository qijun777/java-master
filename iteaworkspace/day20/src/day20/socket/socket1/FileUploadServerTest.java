package day20.socket.socket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传服务器
 */
public class FileUploadServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端已启动......");

        // 等待客户端上传数据
        Socket socket = serverSocket.accept();

        /**
         * 获取文件名
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        String s = objectInputStream.readUTF();

        /**
         * 将从客户端获取的文件写到自定义的磁盘目录下
         */
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\" + s));

        byte[] bytes = new byte[1024*1024];
        int length = 0;
        while((length = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        socket.shutdownInput();
    }
}
