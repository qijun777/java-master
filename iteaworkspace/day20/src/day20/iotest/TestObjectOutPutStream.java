package day20.iotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestObjectOutPutStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("F:test\\aa\\e.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(new People("张三",25));
        objectOutputStream.writeBoolean(false);
        objectOutputStream.writeUTF("我爱暑假");

        User user = new User("张三",23,"男");
        User user1 = new User("李四",23,"男");
        User user2 = new User("王五",23,"男");
        ArrayList<User> arrayList = new ArrayList<User>();
        arrayList.add(user);
        arrayList.add(user1);
        arrayList.add(user2);
        objectOutputStream.writeObject(arrayList);

        objectOutputStream.close();
        out.close();
    }
}
