package day20.mysql.userlogin1.mvc.controler;

import day20.mysql.userlogin1.mvc.bean.User;
import day20.mysql.userlogin1.mvc.service.UserService;

import java.util.Scanner;

/**
 * 用户控制器
 * 接收用户的输入
 * 模块
 * 注册
 * 登录
 * 修改密码
 * 注意：在控制层不写密码
 */

/**
 * 1.连接数据库工具类（DBUtil）：
 *          成员变量：DRIVER--加载驱动、URL--url、USERNAME--用户名、PASSWORD--用户密码
 *          成员方法：public static Connection getConnection()--获取jdbc连接
 *                  public static void close()--回收资源
 *                  public void insert(User user)--插入数据
 * 2.用户控制类（UserControler）：
 *          成员变量：私有业务类（UserService）
 *          成员方法：register()--注册、login()--登录
 * 3.持久层（UserDao）：
 *          成员方法：public User queryByUsernameAndPassword(String username, String password)--根据用户名密码查询
 *                  public User queryByName(String username)--根据用户名查询
 *                  public void insert(User user)--插入数据
 * 4.业务层（UserService）：
 *          成员变量：私有持久层（UserDao）
 *          成员方法：public String login(User user)--用户登录方法
 *                  public String register(User user, String newpassword)--用户注册方法
 * 5.用户类（User）：
 *          成员变量：用户名，用户密码
 *          成员方法：无参构造、有参构造、get、set方法、toString方法
 */
public class UserControler {
    /**
     * 多个地方使用，写成成员变量
     */
    private UserService userService = new UserService();

    public static void main(String[] args) {
        UserControler userControler = new UserControler();
        userControler.login();
    }

    /**
     * 注册
     */
    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        System.out.println("请确认密码：");
        String newpassword = scanner.nextLine();

        User user = new User(username, password);

        // 调用业务层注册方法
        String s = userService.register(user, newpassword);
        System.out.println(s);
    }

    /**
     * 登录
     */
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        User user = new User(username, password);

        String login = userService.login(user);
        System.out.println(login);
    }
}
