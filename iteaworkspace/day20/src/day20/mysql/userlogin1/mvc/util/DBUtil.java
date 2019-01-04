package day20.mysql.userlogin1.mvc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 连接数据库工具
 */
public class DBUtil {
    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    /**
     * 类加载的时候就会执行
     * 只执行一次
     * 加载数据库配置
     */
    static {
        // 通过类加载器获取输入流
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("DB.properties");

        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            // 根据key获取value
            DRIVER = properties.getProperty("driver");
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取jdbc连接
    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement){
        // 回收资源
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
    }
}
