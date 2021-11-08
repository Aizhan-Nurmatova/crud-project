package com.aizhan.service;

import com.aizhan.dao.UserDao;
import com.aizhan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void deleteUser(Integer id) {

        userDao.deleteUser(id);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void mergeUser(User user) {
        userDao.mergeUser(user);
    }


}
