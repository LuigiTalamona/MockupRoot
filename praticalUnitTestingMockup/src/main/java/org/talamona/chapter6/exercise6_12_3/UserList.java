package org.talamona.chapter6.exercise6_12_3;

import java.util.ArrayList;
import java.util.List;
import org.talamona.chapter6.example6_9.User;

/**
 *
 * @author luigi
 */
public class UserList {
    private List users;
    
    public UserList(){
        this.users = new ArrayList();
    }
    
    
    public List getUsers() {
        return users;
    }

    void addUser(User user) {
        this.users.add(user);
    }
    
}
