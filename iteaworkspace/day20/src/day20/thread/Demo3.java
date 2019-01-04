package day20.thread;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要取得钱数：");
        int price = scanner.nextInt();

        AccountDemo3 accountDemo3 = new AccountDemo3(price);

        Thread thread = new Thread(accountDemo3);
        Thread thread1 = new Thread(accountDemo3);
        thread.start();
        thread1.start();
    }
}
