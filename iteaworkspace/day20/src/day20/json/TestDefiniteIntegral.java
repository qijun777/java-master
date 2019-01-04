package day20.json;

import java.util.Scanner;

public class TestDefiniteIntegral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // 提示用户输入积分上下限
        System.out.println("请输入积分上限：");
        double upperLimit = scanner.nextDouble();

        System.out.println("请输入积分下限：");
        double lowerLimit = scanner.nextDouble();

        double sum = 0;
        double n = 10000.0;
        // 求每个区间的长度，分成10000个区间，区间越小，误差越小
        double e = split(upperLimit, lowerLimit, n);

        // 求和，循环从第一个区间叠加到第10000个
        for (int j = 1; j <= (int)n; j++) {
            double x = intermediatePoint(upperLimit, lowerLimit, n, j);
            sum += e * function(x);

        }
        System.out.print("f(x)=2*x*x+x的定积分：" + sum);
        // 返回结果：f(x)=2*x*x+x的定积分：716.6666650000016

    }

    // 定义被积函数(f(x) = 2x^2 + x)，函数可以修改
    public static double function(double x) {
        return 2*x*x + x;
    }

    // 定义第i个区间的中点值，即定义积分变量
    public static double intermediatePoint(double upperLimit, double lowerLimit, double n, int i) {
        return (2 * i - 1) * (upperLimit - lowerLimit) / (2 * n);
    }

    // 定义每个小区间的间隔差，即将范围分成n个等区间
    public static double split(double upperLimit, double lowerLimit, double n) {
        return (upperLimit - lowerLimit) / n;
    }
}
