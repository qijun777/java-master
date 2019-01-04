package day20.iotest2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统计每个班级的人数
 * 1、读取班级信息表（学号，姓名，年龄，写别，班级）
 * 2、统计每个班级学生人数
 * 3、将结果写入到文件（班级名，人数）
 */
public class ClassStudentNumber {
    public static void main(String[] args) throws IOException {
        // 读取文件路径
        FileInputStream in = new FileInputStream("E:\\iteajava\\java\\data\\students.txt");
        // 将字节流转为字符流，指定文件编码方式
        InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
        // 将字符流转为缓冲流，为了按行读取
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ArrayList<Student> arrayList = new ArrayList<Student>();
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            String[] strings = s.split(",");

            Student student = new Student(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3], strings[4]);
            arrayList.add(student);
        }

        for (Student student : arrayList) {
            System.out.println(student);
        }
        bufferedReader.close();
        inputStreamReader.close();
        in.close();


        /**
         * 统计班级人数
         */
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (Student student : arrayList) {
            // 统计各班级男女人数
            String s1 = student.getClassroom() + "," + student.getGender();
            Integer integer = hashMap.get(s1);
            if (integer == null) {
                hashMap.put(s1, 1);
            } else {
                Integer integer1 = hashMap.get(s1) + 1;
                hashMap.put(s1, integer1);
            }
        }

        FileWriter fileWriter = new FileWriter("E:\\bigdata\\iteaworkspace\\day20\\src\\day20\\iotest2\\class.txt");
        // 缓冲流
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            bufferedWriter.write(entry.getKey() + "," + entry.getValue());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
        fileWriter.close();
    }
}
