package day20.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo1_1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过类名获取  其实我们创建的类是Class的一个对象
        Class<Student> aClass = Student.class;

        // 通过类名的对象获取
        Student student = new Student();
        Class aClass1 = student.getClass();

        /**
         * 如何获取完整类名：
         *      在2017版的idea中选中一个类名,然后右键 copy reference,在需要包名+类名的地方,右键 paste simple
         */
        Class<?> aClass2 = Class.forName("day20.reflect.Student");

        // 获取类对象的公有属性
        Field[] fields = aClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        System.out.println("1--------------------------------------");

        // 获取类对象的全部属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("2-------------------------------------");

        // 获取类对象的类名
        System.out.println(aClass.getName());
        System.out.println("3-------------------------------------");

        // 获取所有的构造函数
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            System.out.println(declaredConstructors);
        }
        System.out.println("4-------------------------------------");

        // 通过参数列表类型获取类对象的构造函数
        Constructor<Student> constructor = aClass.getConstructor(String.class, String.class, Integer.class, String.class, String.class);
        Student student1 = constructor.newInstance("001", "张三", 25, "52", "fwrfr");
        System.out.println(student1);
        System.out.println("5-------------------------------------");


    }
}
