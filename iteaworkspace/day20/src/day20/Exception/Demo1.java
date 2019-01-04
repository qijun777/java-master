package day20.Exception;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(show());

        System.out.println("Demo1");
    }

    public static String show() {
        try {
            int i = 10;
            int j = 0;
            System.out.println("编译前");
//            int k = i / j;
            System.out.println("编译后");
            String s = "try";
            return s;
        } catch (Exception e) {
            System.out.println("catch....");
            String s = "catch";
            return s;
        } finally {
            String s = "finally";
            System.out.println("finally....");
            return s;
        }

    }
}
