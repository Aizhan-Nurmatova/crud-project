package com.aizhan.service;

import com.aizhan.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User> listUsers();
    void deleteUser(Integer id);
    User getById(Integer id);
    User findByUsername(String username);
    void mergeUser(User user);
}
