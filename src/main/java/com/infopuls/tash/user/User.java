package com.infopuls.tash.user;

import com.infopuls.tash.entity.EntityManagerProcess;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    // private final Map <String, Map<String , Object> > userMap = new HashMap<>();

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User findUserByLogin (String login) {
        String query = "SELECT c FROM User c WHERE c.login = '"+ login+"'";

        List<Object>  userList =   EntityManagerProcess.findEntity(query, User.class);
        if (userList.isEmpty()){
            return null;
        }else {
           return  (User)userList.get(0);
        }
    }

    public static User findUserByLoginPassword (String login, String password) {
        String query = "SELECT c FROM User c WHERE c.login = '"+ login+"' and c.password = '" +password+ "'";

        List<Object>  userList =   EntityManagerProcess.findEntity(query, User.class);
        if (userList.isEmpty()){
            return null;
        }else {
            return  (User)userList.get(0);
        }
    }

    public static void addUser (User u) {
        EntityManagerProcess.addEntity(u);
    }
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONENUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
