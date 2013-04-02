package org.talamona.chapter6.exercise6_12_3;

import java.util.List;
import org.talamona.chapter6.example6_9.User;



import static org.fest.assertions.Assertions.assertThat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class TestingCollectionsTestNG {

    private UserList instance;
    public TestingCollectionsTestNG() {
    }


    @BeforeMethod
    public void setup(){
        this.instance = new UserList();
    }
    
    @Test
    public void shouldBeReturnAnEmptyList(){
        List retValue = this.instance.getUsers();
        assertThat(retValue).isNotNull().isEmpty();
    }
    @Test
    public void shouldBeReturnOneAndOnlyOne(){
        User user = new User();
        this.instance.addUser(user);
        assertThat(this.instance.getUsers()).isNotEmpty().hasSize(1).containsExactly(user);
    }
    @Test
    public void shouldBeReturnTwoForTwo(){
        User user1 = new User();
        user1.setName("Mario");
        user1.setSecondName("Cutuli");
              
        User user2 = new User();
        user2.setName("Grazia");
        user2.setSecondName("Sciuto");

        this.instance.addUser(user1);
        this.instance.addUser(user2);
        
        List expectedValues = this.instance.getUsers();
        
        assertThat(this.instance.getUsers()).isNotEmpty().hasSize(2);
        assertThat(expectedValues).onProperty("name").contains("Mario");
        assertThat(expectedValues).onProperty("secondName").contains("Sciuto");
    }
}