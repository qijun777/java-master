package day20.mysql.userlogin.mvc.controler;

import com.shujia.mysql.userlogin.mvc.bean.User;
import com.shujia.mysql.userlogin.mvc.service.UserService;

import java.util.Scanner;

/**
 * 用户控制器
 * 接收用户的输入
 * 模块
 * 登录
 * 注册
 * 修改密码
 * <p>
 * 注意;在控制层不写义务
 */
public class UserControler {

    /**
     * 多个地方使用，所以写成成员变量
     *
     */
    private UserService userService = new UserService();

    public static void main(String[] args) {
        UserControler userControler = new UserControler();
        userControler.login();
    }


    /**
     * 注册
     */

    public void register() {
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        System.out.println("请确认密码密码：");
        String newpassword = scanner.nextLine();

        User user = new User(username, password);

        //调用业务层注册方法
        String msg = userService.register(user, newpassword);

        System.out.println(msg);

    }


    /**
     * 登录
     */
    public void login() {
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        User user = new User(username, password);

        String msg = userService.login(user);

        System.out.println(msg);

    }

}
