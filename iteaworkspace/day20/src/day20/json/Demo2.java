package day20.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 将json字符串转成java对象
 */
public class Demo2 {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();

        FileReader fileReader = new FileReader("E:\\iteajava\\java\\src\\com\\shujia\\json\\students.json");
        // 将json字符串转成java对象
        List<Student> lists = gson.fromJson(fileReader, new TypeToken<ArrayList<Student>>(){}.getType());

        for (Student list : lists) {
            System.out.println(list);
        }

    }
}
