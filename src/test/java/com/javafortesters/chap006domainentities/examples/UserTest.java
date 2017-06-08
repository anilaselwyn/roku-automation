package com.javafortesters.chap006domainentities.examples;

import com.javafortesters.domainentities.User;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anilaselwyn on 6/7/17.
 */
public class UserTest {

    /*@Test
    public void canConstructANewUser(){
        User user = new User();
    }*/

    /*@Test
    public void userHasDefualtUsernameAndPassword(){
        User user = new User();
        assertEquals("default username expected","username",user.getUsername());
        assertEquals("default password expected", "password", user.getPassword());
    }*/

    @Test
    public void canConstructWithUsernameAndPassword(){

        User user = new User("admin","pa55w0rD");
        assertEquals("given username expected", "admin", user.getUsername());
        assertEquals("given password expected", "pa55w0rD", user.getPassword());
        System.out.println("Username is : " + user.getUsername() + " Password is :" + user.getPassword());

    }


}
