package DesignPatterns.Test01FactoryMethod.FactoryMethod1;

import DesignPatterns.Test01FactoryMethod.FactoryMethod.MailSender;
import DesignPatterns.Test01FactoryMethod.FactoryMethod.Sender;
import DesignPatterns.Test01FactoryMethod.FactoryMethod.SmsSender;

public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
