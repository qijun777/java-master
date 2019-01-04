package day20.json;

import com.google.gson.Gson;

/**
 * 将java对象转成json字符串
 */
public class Demo1 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Student student = new Student("1500100002", "吕金鹏", 23, "女", "文科六班");
        // 将对象转成json字符串
        String s = gson.toJson(student);
        System.out.println(s);

        // 将json字符串转成对象
        String newJson = "{\"id\":\"1500100002\",\"name\":\"吕金鹏\",\"age\":23,\"gender\":\"女\",\"clazz\":\"文科六班\"}";
        Student student1 = gson.fromJson(newJson, Student.class);
        System.out.println(student1);

    }
}
