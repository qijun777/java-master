package day20.socket.socket0;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件下载，服务器端
 */
public class FileDownLoadServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端已启动......");

        while (true) {
            Socket socket = serverSocket.accept();

            MyThread myThread = new MyThread(socket);
            myThread.start();

        }

    }

    static class MyThread extends Thread {
        private Socket socket;

        public MyThread() {
        }

        public MyThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            /**
             * 在重写方法run中不能将问题抛出
             */
            try {
                // 获取文件列表
                File file = new File("F:\\Youku Files\\download");
                File[] files = file.listFiles();

                /**
                 * 1.提供查询文件列表的服务，将可以下载的文件列表返回给客户端
                 */
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(files);
                objectOutputStream.flush();

                /**
                 * 5.获取客户端发送的文件对象(接收客户端发出的文件对象)
                 */
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                File file1 = (File) objectInputStream.readObject();

                System.out.println(socket.getInetAddress() + "正在下载" + file1.getName());

                /**
                 * 6.根据客户端给的文件对象从此磁盘下载相应的源文件，并传给客户端
                 */
                // 根据客户端发送的对象写数据的输入流
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file1));

                // 获取服务器端向客户端写数据的输出流
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
                byte[] bytes = new byte[1024 * 1024];
                int length = 0;
                while ((length = bufferedInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, length);
                    bufferedOutputStream.flush();
                }

                bufferedInputStream.close();
//                objectInputStream.close(); // 不能写，会报错
                socket.shutdownInput();
                socket.shutdownOutput();
                System.out.println("文件下载完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
