package com.neng.pojo;

/**
 * Created by nengneng on 2017/7/13.
 */
public class UserBuilder extends User {

    private String username;

    private String password;

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String usepasswordrname) {
        this.password = password;
        return this;
    }

    public UserBuilder build() {
        return this;
    }
}
