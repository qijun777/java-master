package DesignPatterns.Test04Builder;

import DesignPatterns.Test02AbstractFactory.MailSender;
import DesignPatterns.Test02AbstractFactory.Sender;
import DesignPatterns.Test02AbstractFactory.SmsSender;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
        for (Sender sender : list) {
            System.out.println(sender);
        }
    }

    public void produceSmsSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
        for (Sender sender : list) {
            System.out.println(sender);
        }
    }

}
