package day20.thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * 客户端
 */
public class ThreadClientTest {
    public static void main(String[] args) throws IOException {
        MyThread myThread = new MyThread();

        Socket socket = new Socket("localhost",9999);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(myThread);
        objectOutputStream.flush();

        socket.shutdownOutput();
    }
}


class MyThread extends Thread implements Serializable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "第" + (i + 1) + "次运行程序");
        }
    }
}