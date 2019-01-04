package day20.thread;

public class Demo2 {
    public static void main(String[] args) {
        // 初生状态--无资格，无资源
        RunnableTestDemo2 runnableTestDemo2 = new RunnableTestDemo2();
        Thread thread = new Thread(runnableTestDemo2);

        // 就绪状态--有资格，无资源
        // 运行状态--有资格，有资源
        thread.start();

        for (int i = 10; i >= 1; i--) {
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第" + (11 - i) + "次运行main线程：" + i);
        }

    }
}
