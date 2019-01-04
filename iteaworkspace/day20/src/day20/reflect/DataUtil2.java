package day20.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DataUtil2 {

    public static <T> ArrayList<T> load(String path, Class<T> tClass){
        ArrayList<T> arrayList = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split(",");
                // 创建对象
                T t = tClass.newInstance();
                // 获取对象属性
                Field[] declaredFields = tClass.getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    String value = split[i];
                    String name = declaredFields[i].getName();
                    Class<?> type = declaredFields[i].getType();
                    String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                    // 根据方法名和类型获取方法对象
                    Method method = tClass.getMethod(methodName, type);

                    if(type.getName().equals("java.lang.Integer")){
                        method.invoke(t,Integer.parseInt(value));
                    }else {
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
        } finally{
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
