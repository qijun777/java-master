package DesignPatterns.Test02AbstractFactory;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is smssender");
    }
}
