package org.talamona.chapter6.example6_9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class User {
    private List<String> phones;
    private String name, secondName;

    public User() {
        this.phones = new <String>ArrayList();
    }


    List<String> getPhones() {
        return this.phones;
    }

    void addPhone(String s) {
        this.phones.add(s);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }
    
}
