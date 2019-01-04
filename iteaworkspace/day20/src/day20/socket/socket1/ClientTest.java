package day20.socket.socket1;

import java.io.*;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);

        OutputStream out = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("你好，师姐");
        bufferedWriter.flush();
        socket.shutdownOutput();

        InputStream in = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        String s = objectInputStream.readUTF();
        System.out.println("服务器响应结果：" + s);
        socket.shutdownInput();

        System.out.println("请求已完成");
    }
}
