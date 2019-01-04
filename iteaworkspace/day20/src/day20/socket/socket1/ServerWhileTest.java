package day20.socket.socket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerWhileTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端");
        Socket socket = serverSocket.accept();

        while(true){
            InputStream in = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            System.out.println(socket.getInetAddress() + "：" + s);

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入：");
            String s1 = scan.nextLine();
            bufferedWriter.write(socket.getInputStream() + "：" + s1);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }
}
