package day20.mysql.test;

import java.sql.*;

public class Demo1_2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student01", "root", "root");

            // 3.连接sql
            String sql = "select * from score";
            preparedStatement = connection.prepareStatement(sql);

            // 4.获得结果
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String sno = resultSet.getString(1);
                String cno = resultSet.getString(2);
                int degree = resultSet.getInt(3);

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

            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
