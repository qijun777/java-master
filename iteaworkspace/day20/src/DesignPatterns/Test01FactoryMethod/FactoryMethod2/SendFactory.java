package DesignPatterns.Test01FactoryMethod.FactoryMethod2;

import DesignPatterns.Test01FactoryMethod.FactoryMethod.MailSender;
import DesignPatterns.Test01FactoryMethod.FactoryMethod.Sender;
import DesignPatterns.Test01FactoryMethod.FactoryMethod.SmsSender;

public class SendFactory {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
