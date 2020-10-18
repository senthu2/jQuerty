package com.example.searchuser;


import com.example.searchuser.Model.User;
import com.example.searchuser.service.Nyheder;

import java.util.List;

public class Result {
    private String message;
    private List<User> userList;
    private List<User> users;
    private List<Nyheder> nyhederList;

    public Result() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Nyheder> getNyhederList() {
        return nyhederList;
    }

    public void setNyhederList(List<Nyheder> nyhederList) {
        this.nyhederList = nyhederList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}