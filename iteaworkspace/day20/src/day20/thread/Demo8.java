package day20.thread;

/**
 * 生产者消费者模式
 */
public class Demo8 {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Producer producer = new Producer(factory);
        Consumer consumer = new Consumer(factory);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Factory factory;

    public Producer() {
    }

    public Producer(Factory factory) {

        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (factory) {
                if (!factory.isFlag()) {
                    if (i % 2 == 0) {
                        factory.setBrand("哇哈哈");
                        factory.setName("矿泉水");
                    } else {
                        factory.setBrand("旺仔");
                        factory.setName("小馒头");
                    }
                    System.out.println(Thread.currentThread().getName() + "生产了：" + factory.getBrand() + factory.getName());
                    factory.setFlag(true);
                }

                factory.notifyAll();
                if (i != 99) {
                    try {
                        factory.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private Factory factory;

    public Consumer() {
    }

    public Consumer(Factory factory) {

        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (factory) {
                if (factory.isFlag()) {
                    System.out.println(Thread.currentThread().getName() + "消费了：" + factory.getBrand() + factory.getName());
                    factory.setFlag(false);
                }

                if (i != 99) {
                    factory.notifyAll();
                    try {
                        factory.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

/**
 * 工厂
 */
class Factory {
    private String brand;
    private String name;
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Factory() {
    }

    public Factory(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}