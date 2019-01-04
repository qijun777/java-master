package day20.reflect;

import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = DataUtil2.load("E:\\iteajava\\java\\data\\students.txt",Student.class);

        for (Student s : arrayList) {
            System.out.println(s);
        }

//        ArrayList<Score> scores = DataUtil.load("E:\\iteajava\\java\\data\\score.txt", Score.class);
//        for (Score score : scores) {
//            System.out.println(score);
//        }
    }
}
