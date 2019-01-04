package day20.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        Dog dog = new Dog("布丁", 25);
        Person person = new Person("张三", 15, dog);

        Dog dog1 = new Dog("小", 5);
        Person person1 = new Person("李四", 35, dog1);

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(person);
        arrayList.add(person1);

        Gson gson = new Gson();
//        gson.toJson(person);

        String s = gson.toJson(arrayList);
        System.out.println(s);
        System.out.println("---------------------");

        List<Person> lists = gson.fromJson(s,new TypeToken<ArrayList<Person>>(){}.getType());
        for (Person list : lists) {
            System.out.println(list);
        }

    }
}
