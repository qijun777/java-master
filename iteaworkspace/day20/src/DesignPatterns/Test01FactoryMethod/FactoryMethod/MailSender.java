package DesignPatterns.Test01FactoryMethod.FactoryMethod;

public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is mailsender");
    }
}
