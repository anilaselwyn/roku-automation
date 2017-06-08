package com.javafortesters.domainentities;

/**
 * Created by anilaselwyn on 6/7/17.
 */
public class User {

    private String username = "username";
    private String password = "password";

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}

