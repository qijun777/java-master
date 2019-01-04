package day20.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        /**
         * 创建一个空的树
         */
        Document document = DocumentHelper.createDocument();

        // 构建根节点
        Element students = document.addElement("students");
        // 增加属性
        students.addAttribute("msg","学生信息");
        // 增加子节点
        Element student = students.addElement("student");
        // 增加属性
        student.addAttribute("id","500001");

        /**
         * 增加子节点
         */
        Element name = student.addElement("name");
        name.addText("noviv");
        Element age = student.addElement("age");
        age.addText("25");
        Element gender = student.addElement("gender");
        gender.addText("男");
        Element clazz = student.addElement("clazz");
        clazz.addText("理科五班");

        // 将Document保存到文件
        /**
         * 格式化器：输出的文档自动对齐
         */
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
//        prettyPrint.setEncoding(); // 可以设置文件的编码格式
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("E:\\bigdata\\iteaworkspace\\day20\\src\\day20\\xml\\newtest.xml"),prettyPrint);
        xmlWriter.write(document);
        xmlWriter.close();

    }
}
