package day20.thread;

public class ThreadDemo1Test extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("第" + i + "次执行run方法");
        }
    }
}
