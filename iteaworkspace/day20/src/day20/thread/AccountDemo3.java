package day20.thread;

/**
 * 银行
 */
public class AccountDemo3 implements Runnable {
    private int price = 10000;
    private int scount;

    public AccountDemo3() {
    }

    public AccountDemo3(int price) {
        this.scount = price;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (price > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.price -= scount;
                    Thread thread = Thread.currentThread();
                    if (price > 0) {
                        System.out.println(thread.getName() + "取走了" + scount + "，还剩" + price);
                    } else {
                        System.out.println("你的余额不足");
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
