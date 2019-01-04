package day20.mysql.userlogin;

import java.sql.*;
import java.util.Scanner;

/**
 * 登录
 *
 */
public class Login {

    public static void main(String[] args) {
        System.out.println("请输入用户名：");

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();


        //拼接sql
        String sql ="select * from user where username='"+username+"' and password='"+password+"'";


        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123456");
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("用户名密码不正确");
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
