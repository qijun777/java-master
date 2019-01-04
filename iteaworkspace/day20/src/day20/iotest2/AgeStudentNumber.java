package day20.iotest2;

import java.io.*;
import java.util.*;

/**
 * 统计每个年龄的人数，按照人数倒叙排序
 */
public class AgeStudentNumber {
    public static void main(String[] args) throws IOException {
        // 读取
        FileInputStream in = new FileInputStream("E:\\iteajava\\java\\data\\students.txt");
        // 字节流转为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        // 字符流转为缓冲流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ArrayList<Student> arrayList = new ArrayList<Student>();
        String length;
        while ((length = bufferedReader.readLine()) != null) {
            String[] s2 = length.split(",");
            Student student = new Student(s2[0], s2[1], Integer.parseInt(s2[2]), s2[3], s2[4]);
            arrayList.add(student);
        }

        /**
         * char[] chars = new char[1024];
         * 1.能运行但少东西---文件中文本很多时只能读取一部分文字，读取不了全部
         * 2.这样写可以运行，但换一个数字就不行了---char[] chars = new char[100];这样不行
         *
         * 原因：readLine()与new char[1024]冲突，例如：文本中有100行但只能打出20行
         */
//        char[] chars = new char[1024];
//        int i = 0;
//        while ((i = bufferedReader.read(chars)) != -1){
//            String c = bufferedReader.readLine();
//            String[] s2 = c.split(",");
//            Student student = new Student(s2[0], s2[1], Integer.parseInt(s2[2]), s2[3], s2[4]);
//            arrayList.add(student);
//        }
//        for (Student student : arrayList) {
//            System.out.println(student);
//        }

        bufferedReader.close();
        inputStreamReader.close();
        in.close();

        /**
         * 统计年龄人数
         */
        // 将各个年龄的人数统计好
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (Student student : arrayList) {
            Integer key = student.getAge();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                Integer value = map.get(key) + 1;
                map.put(key, value);
            }
        }

        FileWriter fileWriter = new FileWriter("E:\\bigdata\\iteaworkspace\\day20\\src\\day20\\iotest2\\age.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // 新建一个集合，按照人数进行倒叙排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 遍历 将map集合的键、值添加为treeMap集合中的值、键
        Set<Integer> set1 = map.keySet();
        for (Integer key : set1) {
            treeMap.put(map.get(key), key);
        }

        // 将treeMap集合中的元素添加到文本文件中
        Set<Map.Entry<Integer, Integer>> set = treeMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            bufferedWriter.write(entry.getKey() + "," + entry.getValue());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }


        fileWriter.close();
    }
}
