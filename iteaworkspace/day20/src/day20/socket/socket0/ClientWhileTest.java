package day20.socket.socket0;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientWhileTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.0.122", 6666);
        System.out.println("连接成功");

        while (true) {
            /**
             * 写信息
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入：");
            String s = scan.nextLine();
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            /**
             * 读信息
             */
            InputStream in = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s1 = bufferedReader.readLine();
            System.out.println(socket.getInetAddress() + "：" + s1);

        }
    }
}
