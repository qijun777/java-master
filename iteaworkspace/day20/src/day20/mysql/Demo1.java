package day20.mysql;

import java.sql.*;

/**
 * 连接mysql数据库
 * jdbc--连接协议
 */
public class Demo1 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.建立连接  student01--数据库名
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student01", "root", "root");

            // 3.获取sql执行器      statement--声明、陈述
            statement = connection.createStatement();

            String sql = "select * from score";

            // 4.执行sql，返回结果
            ResultSet resultSet = statement.executeQuery(sql);

            // 5.遍历结果集
            /**
             * 最开始指针在第一行之前
             * next()--判断是否有下一行，如果有下一行，将指针下移一位
             */
            while(resultSet.next()){
                /**
                 * 通过列的索引获取数据，索引从1开始
                 */
                String sno = resultSet.getString(1);
                String cno = resultSet.getString(2);
                String degree = resultSet.getString(3);

                System.out.println(sno + "\t" + cno + "\t" + degree);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    }
}
