package DesignPatterns.Test04Builder;

/**
 * 建造者模式（Builder）
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
