package day20.socket.socket0;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象，相当于和服务端建立连接
        Socket socket = new Socket("192.168.0.129",8888);
        // 获取客户端想发给服务端的数据的流对象
        OutputStream out = socket.getOutputStream();

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("你好");
        bufferedWriter.flush();
        // 关闭流对象
        socket.shutdownOutput();

        // 接受服务器的响应
        InputStream in = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        String s = objectInputStream.readUTF();
        System.out.println("服务器响应结果：" + s);

        socket.shutdownInput();
        System.out.println("请求已完成");
    }
}
