package day20.mysql.userlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 注册
 */
public class Register {

    public static void main(String[] args) {

        /**
         * 控制层(controler)
         *
         */
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        System.out.println("请确认密码密码：");
        String newpassword = scanner.nextLine();


        /**
         * 业务层(service)
         *
         */
        if (!password.equals(newpassword)) {
            System.out.println("密码不一致");
            return;
        }


        /**
         *
         * 持久层 （dao）
         *
         * 插入数据到数据库
         *
         */
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123456");
            statement = con.createStatement();

            //拼接sql
            String sql = "insert into user values('" + username + "','" + password + "')";
            int i = statement.executeUpdate(sql);

            if (i > 0) {
                System.out.println("注册成功");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、回收资源
            if (statement != null) {
                try {
                    statement.close();
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


    }
}
