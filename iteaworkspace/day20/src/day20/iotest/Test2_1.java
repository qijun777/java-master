package day20.iotest;

import java.io.*;

/**
 * 2.实现字节数组和任何基本类型和引用类型执行的相互转换
 * 提示：使用ByteArrayInutStream和ByteArrayOutputStream。
 */
public class Test2_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean b = true;

        test01(b);
        System.out.println("---------(-^_^-)---------");
        test02(new Person());
    }

    // 字节数组和boolean类型的相互转换
    public static void test01(boolean b) throws IOException {
        // 输出流，输出一个boolean类型的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeBoolean(b);
        System.out.println("输出boolean型：" + b);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        // 输入流，输入一个boolean类型的数据
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        System.out.println(dataInputStream.readBoolean());

        dataOutputStream.close();
        byteArrayOutputStream.close();
        dataInputStream.close();
        byteArrayInputStream.close();
    }

    // 字节数组和引用类型的相互转换
    public static void test02(Person person) throws IOException, ClassNotFoundException {
        // 输出流，输出一个引用类型的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(person);
        System.out.println(person);
        System.out.println("-------------------");
        byte[] bytes = byteArrayOutputStream.toByteArray();

        // 输入流，输入一个应用类型的数据
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Person person1 = (Person)(objectInputStream.readObject());
        System.out.println(person1);

        objectOutputStream.close();
        byteArrayOutputStream.close();
        objectInputStream.close();
        byteArrayInputStream.close();
    }
}
