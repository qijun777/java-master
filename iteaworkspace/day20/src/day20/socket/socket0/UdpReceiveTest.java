package day20.socket.socket0;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 */
public class UdpReceiveTest {
    public static void main(String[] args) throws IOException {
        // 创建接收数据包的对象，绑定一个端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        // 创建空的数据报包对象
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        // 将接收过来的数据放入创建的数据报包对象中
        datagramSocket.receive(datagramPacket);

        // 拆包，将接受过来的数据转换成字符串
        String s = new String(datagramPacket.getData(),0,datagramPacket.getLength());

        System.out.println(s);

        datagramSocket.close();
    }
}
