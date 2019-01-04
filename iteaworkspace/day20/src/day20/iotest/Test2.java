package day20.iotest;

import java.io.*;
import java.util.Arrays;

/**
 * 2.实现字节数组和任何基本类型和引用类型执行的相互转换
 * 提示：使用ByteArrayInutStream和ByteArrayOutputStream。
 */
public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean b = true;
        test01(b);
        System.out.println("--------------");
        test02(new Person());
    }

    // 字节数组和boolean类型执行的相互转换
    public static void test01(boolean b) throws IOException {
        // 输出流，输出一个boolean类型的数据
        // ByteArrayOutputStream()---创建一个新的字节数组输出流。
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // DataOutputStream(OutputStream out)---创建一个新的数据输出流，以将数据写入指定的底层输出流。
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        // 将 boolean写入底层输出流作为1字节值。
        dataOutputStream.writeBoolean(b);
        // toByteArray()---创建一个新分配的字节数组。
        /*
            为何创建这个字节数组：(猜测)为了下面new ByteArrayInputStream(bytes);所创建的
          */
        byte[] bytes = byteArrayOutputStream.toByteArray();
        for (byte b1 : bytes) {
            System.out.println(b1 + " ");
        }


        // 输入流，输入一个boolean类型的数据
        // ByteArrayInputStream(byte[] buf)---创建一个 ByteArrayInputStream ，使其使用 buf作为其缓冲区数组。
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        // DataInputStream(InputStream in)---创建使用指定的底层InputStream的DataInputStream。
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        // readBoolean()---返回值类型：boolean---见的总承包 readBoolean的方法DataInput。
        boolean b1 = dataInputStream.readBoolean();
        System.out.println(b1);

        dataOutputStream.close();
        byteArrayOutputStream.close();
        dataInputStream.close();
        byteArrayInputStream.close();
    }

    // 字节数组和引用数据类型之间的转换
    public static void test02(Person person) throws IOException, ClassNotFoundException {
        // 输出流，输出一个引用类型的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // ObjectOutputStream(OutputStream out)---创建一个写入指定的OutputStream的ObjectOutputStream。
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(person);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();

        // 输入流，输入一个引用类型的数据
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        // ObjectInputStream(InputStream in)
        //创建从指定的InputStream读取的ObjectInputStream。
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Person person1 = (Person)objectInputStream.readObject();
        /*
            System.out.println(person1);
            这句话输出的是地址值
         */
        System.out.println(person1);
        person1.show();

        objectOutputStream.close();
        byteArrayOutputStream.close();
        objectInputStream.close();
        byteArrayInputStream.close();
    }
}

