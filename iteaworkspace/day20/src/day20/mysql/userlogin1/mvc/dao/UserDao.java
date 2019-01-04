package day20.mysql.userlogin1.mvc.dao;

import day20.mysql.userlogin1.mvc.util.DBUtil;
import day20.mysql.userlogin1.mvc.bean.User;

import java.sql.*;

/**
 * 持久层
 */
public class UserDao {
    /**
     * 根据用户名密码查询
     * 判断用户名密码是否存在，不存在则返回null
     */
    public User queryByUsernameAndPassword(String username, String password) {
        // 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 拼接sql
        String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";

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
                user.setUserpass(pwd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement);
        }
        return user;
    }

    /**
     * 根据用户名查询
     * 判断用户是否存在，不存在返回null
     */
    public User queryByName(String username) {
        // 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 拼接sql
        String sql = "select * from user where username = '" + username + "'";

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
                user.setUserpass(pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement);
        }
        return user;
    }

    /**
     * 插入数据
     */
    public void insert(User user) {
        // 通过工具获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 拼接sql
        String sql = "insert into user values('" + user.getUsername() + "','" + user.getUserpass() + "')";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement);
        }

    }

}
