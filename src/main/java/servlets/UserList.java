package servlets;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by voldem on 17.11.2015.
 */
public class UserList {
    private static Map users = new HashMap();

    public static UserBean findUser(String user) {
        return (UserBean) users.get(user);
    }

    public static boolean addUser(UserBean user) {
        boolean result = false;
        if ((!users.containsKey(user.getUser())) && (user.getPassword() != null) && (!"".equals(user.getPassword()))) {
            users.put(user.getUser(), user);
            result = true;
        }
        return result;
    }

}
