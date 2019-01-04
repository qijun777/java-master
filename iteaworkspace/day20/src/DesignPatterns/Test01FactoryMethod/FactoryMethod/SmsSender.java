package DesignPatterns.Test01FactoryMethod.FactoryMethod;

public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is smasender");
    }
}
