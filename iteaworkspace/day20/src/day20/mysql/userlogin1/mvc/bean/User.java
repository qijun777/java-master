package day20.mysql.userlogin1.mvc.bean;

/**
 * 用户类
 */
public class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String userpass) {
        this.username = username;
        this.password = userpass;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userpass='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return password;
    }

    public void setUserpass(String userpass) {
        this.password = userpass;
    }
}
