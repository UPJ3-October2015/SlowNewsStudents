package com.infopuls.tash.user;

import java.util.HashMap;
import java.util.Map;

public class UsersMap {
    private Map<String , User> users;
    public  static UsersMap instanse;

    public  synchronized  static UsersMap getInstance (){
        if (instanse == null) {
            instanse = new UsersMap();
            User admin = new User("admin", "admin");
            admin.setFirstName("Admin");
            instanse.addUser(admin);
        }
        return  instanse;
    }
    private UsersMap() {
        users = new HashMap<String , User>();
    }

    public void addUser (User u) {
        users.put(u.getLogin(), u);
    }

    public boolean isExistLogin (String login) {
        return (users.containsKey( login)) ? true : false;
    }

    public  User findUserbyLogin (String login){
        return users.get(login);
    }

    public boolean checkPassword (String login, String password){
        return (users.containsKey( login)&& users.get(login).getPassword().equals(password)) ? true : false;
    }

}
