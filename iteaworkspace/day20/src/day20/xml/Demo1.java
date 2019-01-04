package day20.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        File file = new File("E:\\bigdata\\iteaworkspace\\day20\\src\\day20\\xml\\test.xml");
        SAXReader saxReader = new SAXReader();
        /**
         * 创建xml文件Document对象
         *
         * document对象方式
         * 1.通过文件创建
         * 2.通过字节输入流创建
         * 3.通过字符输入流创建
         */
        Document read = saxReader.read(file);

        // 获取文档根节点  element--元素  root--根
        Element rootElement = read.getRootElement();
        // 获取元素的文本
        String text = rootElement.getText();
        System.out.println(text);
        System.out.println("---------------------");

        // 获取子节点
        Iterator iterator = rootElement.elementIterator();
        while(iterator.hasNext()){
            Element element = (Element) iterator.next();
            // 获取元素的属性，根据属性名获取属性    attribute--属性
            Attribute id = element.attribute("id");
            // 获取属性值
            System.out.print(id.getName() + "：" + id.getValue() + "，");

            Iterator iterator1 = element.elementIterator();
            while (iterator1.hasNext()){
                Element element1 = (Element) iterator1.next();
                // 获取元素名
                String name = element1.getName();
                // 获取元素内容
                String text1 = element1.getText();
                System.out.print(name + "：" + text1 + "，");
            }
            System.out.println();
        }
    }
}
