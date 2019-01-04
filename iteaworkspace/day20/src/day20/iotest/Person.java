package day20.iotest;

import java.io.Serializable;

public class Person implements Serializable {
    int age = 9;

    public  Person(){
        System.out.println("世界你好。");
    }

    public void show() {
        System.out.println("师姐你好。");
    }

}
