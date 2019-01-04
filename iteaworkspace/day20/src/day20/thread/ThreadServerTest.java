package day20.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class ThreadServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("客户端启动......");
        Socket socket = serverSocket.accept();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Thread thread = (Thread) objectInputStream.readObject();

        socket.shutdownInput();

        thread.setName("客户端");
        thread.start();

    }
}
