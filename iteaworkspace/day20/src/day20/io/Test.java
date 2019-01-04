package day20.io;

public class Test {
    public static void main(String[] args) {
        System.out.println(m(4));
    }

    public static long m(int i) {
        if (i == 1) {
            return 1;
        }
        return m(i - 1) * i;
    }

}