package day20.mysql.userlogin.mvc.dao;

import com.shujia.mysql.userlogin.mvc.bean.User;
import com.shujia.mysql.userlogin.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 持久层
 */
public class UserDao {

    /**
     *
     * 根据用户名密码查询
     * @return
     */
    public User queryByUsernameAndPassword(String username,String password){
        //获取数据库连接
        Connection connection = DBUtil.getConnection();
        //拼接sql
        //select * from user username='张三' and password='123'
        String sql = "select * from user where username='" + username + "' and password='"+password+"'";
        System.out.println(sql);
        Statement statement = null;

        User user = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                user = new User();
                String name = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                user.setUsername(name);
                user.setPassword(pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //回收资源，关闭连接
            DBUtil.close(connection, statement);
        }

        return user;
    }


    /**
     * 根据用户名查询
     */

    public User queryByName(String username) {
        //获取数据库连接
        Connection connection = DBUtil.getConnection();
        //拼接sql
        String sql = "select * from user where username='" + username + "'";
        Statement statement = null;

        User user = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                user = new User();
                String name = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                user.setUsername(name);
                user.setPassword(pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //回收资源，关闭连接
            DBUtil.close(connection, statement);
        }

        return user;
    }


    /**
     * 插入数据
     *
     * @param user
     */
    public void insert(User user) {
        //通过工具获取数据库连接
        Connection connection = DBUtil.getConnection();
        //拼接sql
        String sql = "insert into user values('" + user.getUsername() + "','" + user.getPassword() + "')";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //回收资源，关闭连接
            DBUtil.close(connection, statement);
        }


    }
}
