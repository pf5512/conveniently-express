package com.neng.pojo;

/**
 * Created by nengneng on 2017/7/13.
 */
public class UserBuilder extends User {

    private final User user=new User();


    public UserBuilder username(final String username){
        user.setUsername(username);
        return this;
    }

    public UserBuilder password(final String password){
        user.setPassword(password);
        return this;
    }


    public User build(){
        return this.user;
    }
}
