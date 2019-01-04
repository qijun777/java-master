package day20.iotest;

import javax.annotation.processing.Filer;
import java.io.*;

/**
 * 【1】使用File类的方法去创建一个文本文件，先进行判断
 *         如果没有则创建，如有有则先删除再创建
 * 【2】使用BufferedWriter将如下文字
 *             《虞美人》
 *           春花秋月何时了?
 *           往事知多少。
 *           小楼昨夜又东风，
 *           故国不堪回首月明中。
 *           雕栏玉砌应犹在，
 *           只是朱颜改。
 *           问君能有几多愁？
 *           恰似一江春水向东流。
 *          写入【1】中所创建的文件
 * 【3】再将【2】中写入的文件读取到控制台输出
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        // 第一步
        File file = new File("F:test\\aa\\诗.txt");


        if(file.exists()){
            file.delete();
        }

        file.createNewFile();

        // 第二步
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("《虞美人》");
        bufferedWriter.newLine();
        bufferedWriter.write("春花秋月何时了?");
        bufferedWriter.newLine();
        bufferedWriter.write("往事知多少。");
        bufferedWriter.newLine();
        bufferedWriter.write("小楼昨夜又东风，");
        bufferedWriter.newLine();
        bufferedWriter.write("故国不堪回首月明中。");
        bufferedWriter.newLine();
        bufferedWriter.write("雕栏玉砌应犹在，");
        bufferedWriter.newLine();
        bufferedWriter.write("只是朱颜改。");
        bufferedWriter.newLine();
        bufferedWriter.write("问君能有几多愁？");
        bufferedWriter.newLine();
        bufferedWriter.write("恰似一江春水向东流。");

        // 必须写，不写笔记本里什么都没有
        bufferedWriter.close();
        writer.close();

        // 第三步
        FileReader reader = new FileReader("F:test\\aa\\诗.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        int length = 0;
        while ((length = bufferedReader.read()) != -1){
            System.out.println(bufferedReader.readLine());
        }

        bufferedReader.close();
    }
}
