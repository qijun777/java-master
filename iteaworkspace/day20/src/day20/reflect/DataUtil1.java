package day20.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DataUtil1 {
    public static <T> ArrayList<T> load(String path, Class<T> tClass){
        ArrayList<T> arrayList = new ArrayList<T>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                // 将一行数据以","切割成字符串数组
                String[] split = line.split(",");
                // 创建对象
                T t = tClass.newInstance();
                // 获取对象属性数组
                Field[] fields = tClass.getDeclaredFields();

                for (int i = 0; i < fields.length; i++) {
                    String value = split[i];
                    // 获取属性名字
                    String name = fields[i].getName();
                    // 获取属性类型
                    Class type = fields[i].getType();
                    // 获取方法名字
                    String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                    // 根据方法名和属性类型获取方法
                    Method method = tClass.getMethod(methodName, type);

                    if(type.getName().equals("java.lang.Integer")){
                        method.invoke(t,Integer.parseInt(value));
                    }else{
                        method.invoke(t,value);
                    }
                }
                arrayList.add(t);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return arrayList;
    }
}
