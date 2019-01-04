package com.shujia.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 连接数据库工具
 *
 */
public class DBUtil {

    private  static String DRIVER ;
    private  static String URL ;
    private  static String USERNAME ;
    private  static String PASSWORD ;


    /**
     * 类加载的时候就会执行
     * 指挥被执行一次
     * 加载数据库配置
     *
     */
    static {
        //通过类加载器获取输入流，默认从Resource找文件
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("DB.properties");
        try {

            //FileInputStream inputStream = new FileInputStream("E:\\bigdata\\java\\src\\com\\shujia\\mysql\\userlogin\\mvc\\util\\DB.properties");

            //Properties文件，就是一个kv格式的文件
            //java提供的读取Properties文件的工具
            //相当于一个hashmap
            Properties properties = new Properties();
            properties.load(inputStream);
            //根据key获取value
            DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取jdbc连接
     * @return
     */
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con,Statement stat){
        //6、回收资源
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();


    }
}
