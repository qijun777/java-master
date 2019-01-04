package day20.socket.socket1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientWhileTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("连接成功");

        while(true){
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入：");
            String s = scanner.nextLine();
            bufferedWriter.write(socket.getInetAddress() + "：" + s);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            InputStream in = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s1 = bufferedReader.readLine();
            System.out.println(socket.getInetAddress() + "：" + s1);
        }
    }
}
