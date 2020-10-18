package com.example.searchuser.service;

import com.example.searchuser.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        createUsers();

    }

    public List<User> findUsers(String name){
        List<User> result = new ArrayList<>();
        for (User user: users){
            if(user.username.startsWith(name)){
                result.add(user);
            }
        }
        return result;
    }
    private void createUsers(){
        User user1 = new User("Anna");
        User user2 = new User("Anna Madsen");
        User user3 = new User("Anna Olsen");
        User user4 = new User("Bent Olsen");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }
    public void addUser(String user){
        users.add(new User(user));
    }
}