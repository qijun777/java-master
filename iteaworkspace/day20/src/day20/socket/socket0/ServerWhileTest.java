package day20.socket.socket0;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerWhileTest {
    public static void main(String[] args) throws IOException {
        // 创建服务器端对象
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端已启动：");
        Socket socket = serverSocket.accept();

        while (true) {
            /**
             * 接收消息
             */
            InputStream in = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            System.out.println(socket.getInetAddress() + "：" + s);

            /**
             * 回复消息
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入：");
            String s1 = scan.nextLine();
            bufferedWriter.write(s1);
            bufferedWriter.newLine();
            // 使用缓冲流，每次都要刷新一下
            bufferedWriter.flush();
        }
    }
}
