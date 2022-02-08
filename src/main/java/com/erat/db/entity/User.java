package com.erat.db.entity;

import java.io.Serializable;


public class User implements Serializable {
    private String login;
    private String password;
    private Long roleId;
    private Long id;

    public User() {
    }


    public User(String login, String password, Long roleId) {
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", roleId=" + roleId +
                ", id=" + id +
                '}';
    }
}
