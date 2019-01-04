package day20.iotest;

import javax.jws.soap.SOAPBinding;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestObjectInPutStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("F:\\test\\aa\\e.txt");

        ObjectInputStream objectInputStream = new ObjectInputStream(in);

        People p = (People)objectInputStream.readObject();
        System.out.println(p);

        boolean b = objectInputStream.readBoolean();
        System.out.println(b);

        String s = objectInputStream.readUTF();
        ArrayList<User> arrayList = (ArrayList<User>) objectInputStream.readObject();
        for (User user : arrayList) {
            System.out.println(user);
        }

        objectInputStream.close();
        in.close();
    }
}
