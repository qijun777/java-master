package day20.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过new方式
        Student student = new Student();

        // 通过获取类对象的方式
        // 1.通过类名获取  其实我们创建的类实际上是Class的一个对象
        Class<Student> studentClass = Student.class;

        // 2.通过类的对象获取
        Class aClass = student.getClass();

        /**
         *
         */
        // 3.通过动态加载的方式获取类对象
        // 类名：包名 + 类名
        Class<?> aClass1 = Class.forName("day20.reflect.Student");

        // 获取类对象的公有属性
        Field[] fields = aClass1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("1------------------------------------");

        // 根据属性名获取属性 只能获取公有属性
//        Field field = aClass1.getField("name");
//        System.out.println(field);
//        System.out.println("2------------------------------------");

        // 获取类对象的所有属性
        Field[] declaredFields = aClass1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("3------------------------------------");

        // 获取类对象的类名
        System.out.println(aClass1.getName());
        System.out.println("4------------------------------------");

        // 获取所有的构造函数
        Constructor<?>[] constructors = aClass1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("5------------------------------------");

        // 通过参数列表类型获取类对象的构造函数
        Constructor<?> constructor = aClass1.getConstructor(String.class,String.class,Integer.class,String.class,String.class);

        // 通过new方式创建一个对象，实际上是调用了类的构造函数

        // 直接使用构造函数的对象创建类的对象
        // 动态创建对象
        // 通过反射创建对象
        Object o = constructor.newInstance("01","张三",15,"大一","二班");
        System.out.println(o);

        /**
         * 反射：通过类对象获取类的属性和方法，还有构造函数，同时做各种各样的操作
         */
        point(5,"fda","vrwa","frwag","rag");
    }

    /**
     * 可变参数的方法
     * 一般适用于方法参数个数不确定的场景
     * 参数是一个数组(name)
     * int a 要放在前面，否则会报错
     */
    public static void point(int a, String... name){
        System.out.println(a);
        for (String s : name) {
            System.out.println(s);
        }
    }
}
