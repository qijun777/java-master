package day20.thread;

public class RunnableTestDemo2 implements Runnable {
    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第" + i + "次运行run线程：" + i);
        }
    }
}
