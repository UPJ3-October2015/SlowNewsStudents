package net.bash.serg.slownews.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bso05702 on 16.11.2015.
 */
@Entity
@Table(name = "Users")
public class User  implements Serializable {
    public User(){
    }

    public User(String login, String password, String email) {
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 32, unique = false)
    private String login;

    @Column(length = 32, unique = false)
    private String password;

    @Column(length = 32, unique = false)
    private String email;

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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
