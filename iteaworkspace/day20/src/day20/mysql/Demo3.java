package day20.mysql;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 加载驱动，将Dirverclass文件加载到内存
            Class.forName("com.mysql.jdbc.Driver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student01","root","root");

            // 获取sql执行器
            statement = connection.createStatement();

            // 插入数据，返回值是受影响的行数
            int i = statement.executeUpdate("insert into sc values(1,1)");
            if(i > 0){
                System.out.println("插入成功");
            }

            // 更新数据，返回值是受影响的行数
            int i1 = statement.executeUpdate("update sc set cno = '6-166' where sno = '1'");
            if (i1 > 0){
                System.out.println("更新成功");
            }

            // 删除数据，返回值是受影响的行数
            int i2 = statement.executeUpdate("delete from sc where cno = '6-166'");
            if (i2 > 0){
                System.out.println("删除成功");
            }

            // 查询数据
            ResultSet resultSet = statement.executeQuery("select * from sc");

            while(resultSet.next()){
                String sno = resultSet.getString(1);
                String cno = resultSet.getString(2);

                System.out.println(sno + "\t" + cno);
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
