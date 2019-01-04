package day20.thread;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("主线程......");

        ThreadDemo1Test threadDemo1Test = new ThreadDemo1Test();

        threadDemo1Test.start();

        for (int i = 0; i <= 100; i++) {
            System.out.println("第" + i + "次运行main线程");
        }
    }
}
