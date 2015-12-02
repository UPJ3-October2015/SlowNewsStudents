package net.bash.serg.slownews.model;

/**
 * Created by bso05702 on 16.11.2015.
 */
public class User {
    private String user;
    private String password;
    private String email;

    public User(String user, String password, String email) {
        this.setUser(user);
        this.setPassword(password);
        this.setEmail(email);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
