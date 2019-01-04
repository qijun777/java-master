package day20.socket.socket1;

import java.io.IOException;
import java.net.*;

/**
 * 发送端
 */
public class UdpSendTest {
    public static void main(String[] args) throws IOException {
        // 创建发送数据包的对象，相当于发送器
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] bytes = "你好，世界。".getBytes();

        // 构建数据报包，相当于一条短信，包含短信内容和对方的号码
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("localhost"), 9999);

        // 发送数据报包，将数据报包发送到交换机，由交换机转发
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
