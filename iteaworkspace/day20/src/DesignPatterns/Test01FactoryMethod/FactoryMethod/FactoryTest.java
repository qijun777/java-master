package DesignPatterns.Test01FactoryMethod.FactoryMethod;

/**
 * 普通工厂类
 */
public class FactoryTest {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produce("mail");
        sender.sender();
    }
}
