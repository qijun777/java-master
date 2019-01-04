package day20.mysql;

import day20.mysql.userlogin.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 预编译sql执行器
 * 防止sql注入
 * 在sql执行之前会先发一个sql模板，后将数据发送过去
 */
public class Demo4 {
    public static void main(String[] args) {

        Connection connection = DBUtil.getConnection();

        String sql = "select * from student where sname=? and sno=?";
        PreparedStatement preparedStatement = null;
        try {
            //创建预编译sql执行器
            preparedStatement = connection.prepareStatement(sql);
            //给里面的问号设置值
            preparedStatement.setString(1, "lij");
            preparedStatement.setString(2, "101");
            //执行sql返回结果
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString(2);
                String password = resultSet.getString(1);
                System.out.println(username + "\t" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement);
        }

    }
}
