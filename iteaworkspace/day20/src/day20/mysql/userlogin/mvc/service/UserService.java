package day20.mysql.userlogin.mvc.service;

import com.shujia.mysql.userlogin.mvc.bean.User;
import com.shujia.mysql.userlogin.mvc.dao.UserDao;

/**
 *
 * 业务层
 */
public class UserService {

    private UserDao userDao = new UserDao();

    /**
     * 用户登录方法
     *
     * @param user
     * @return
     */
    public String login(User user){
        //判断用户名是否存在
        User user1 = userDao.queryByName(user.getUsername());
        if (user1==null){
            return "用户名不存在";
        }

        /**
         * 判断密码是否正确
         */
        User user2 = userDao.queryByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (user2==null){
            return "密码错误";
        }

        return "登录成功";

    }

    /**
     *
     * 用户注册方法
     * 注册成功返回true
     * 注册失败返回false
     */
    public String register(User user,String newpassword){

        //判断用户名是否存在
        //查询数据库

        User newUser = userDao.queryByName(user.getUsername());
        if (newUser!=null){
            return "用户名已存在";
        }


        //判断两次密码是否一致
        if (!user.getPassword().equals(newpassword)){
            return "密码不一致";
        }

        //插入数据
        userDao.insert(user);

        return "注册成功";
    }
}
