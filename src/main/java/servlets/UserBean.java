package servlets;

/**
 * Created by voldem on 17.11.2015.
 */
public class UserBean {
    private String user;
    private String email;
    private String password;

    public UserBean() {
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
