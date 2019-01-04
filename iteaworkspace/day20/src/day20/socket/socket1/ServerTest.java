package day20.socket.socket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        // 创建服务器socket对象
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端：");
        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);
        socket.shutdownInput();

        OutputStream out = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeUTF("请求已收到");
        objectOutputStream.flush();
        socket.getOutputStream();

        serverSocket.close();
    }
}
