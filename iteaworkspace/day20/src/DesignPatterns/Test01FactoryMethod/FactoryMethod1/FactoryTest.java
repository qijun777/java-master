package DesignPatterns.Test01FactoryMethod.FactoryMethod1;

import DesignPatterns.Test01FactoryMethod.FactoryMethod.Sender;

/**
 * 多个工厂方法模式
 * 将上面的代码做下修改，改动下SendFactory类就行
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produceMail();
        sender.sender();
    }
}
