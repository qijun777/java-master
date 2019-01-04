package DesignPatterns.Test03Singleton;

/**
 * 单例模式（Singleton）
 */
public class Singleton {
    /**
     * 持有私有静态实例，防止被引用，
     * 此处赋值为null，目的是实现延迟加载
     */
    private static Singleton instance = null;

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton() {
    }

//    /**
//     * 静态工程方法，创建实例
//     */
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//

    /**
     * 此处使用一个内部类来维护单例
     */
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    /**
     * 获取实例
     */
    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证在序列化前后一致
     */
    public Object readResolve() {
        return instance;
    }
}
