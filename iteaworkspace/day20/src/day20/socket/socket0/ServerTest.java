package day20.socket.socket0;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        // 创建服务器端socket对象，指定绑定的端口号
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端");
        // 等待客户端发起请求，发起请求后才执行这段代码
        Socket socket = serverSocket.accept();

        // 接受数据
        // 获取输入流对象，获取客户端输入的数据
        InputStream in = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);

        socket.shutdownInput();

        // 响应数据
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeUTF("请求已收到");
        outputStream.flush();

        socket.shutdownOutput();

        serverSocket.close();
    }
}
