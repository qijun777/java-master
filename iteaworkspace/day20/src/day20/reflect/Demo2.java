package day20.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("day20.reflect.Student");
        // 获取不包含private修饰符的方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("1-------------------------------");

        // 获取所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("2-------------------------------");

        // 指定方法名和方法参数获取方法
        Method method = aClass.getMethod("setAge", Integer.class);
        Student student = new Student();
        // 执行方法需要依赖对象才能执行
        method.invoke(student,15);
        System.out.println(student);

        // 通过类对象直接创建类的对象，实际调用了无参构造函数
        Object o = aClass.newInstance();
        method.invoke(o,155);
        System.out.println(o);

        /**
         * java中创建对象的三种方式
         * 1、通过new关键字创建对象
         * 2、通过类对象获取构造函数创建对象
         * 3、直接通过类对象创建类的对象(只能使用无参构造)
         */
    }
}
