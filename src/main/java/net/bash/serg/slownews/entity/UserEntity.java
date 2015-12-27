package net.bash.serg.slownews.entity;

import javax.persistence.*;

/**
 * Created by Serg Bash on 12/20/2015.
 */
@Entity(name = "Users")
@Table(name = "Users")
public class UserEntity implements SlowNewsEntity {
    public UserEntity(){
    }

    public UserEntity(String login, String password, String email) {
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

