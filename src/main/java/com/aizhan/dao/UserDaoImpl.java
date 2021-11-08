package com.aizhan.dao;

import com.aizhan.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        List<User> users =  entityManager.createQuery("select u from User u").getResultList();
        return users;
    }

    @Override
    public void deleteUser(Integer id) {
        entityManager.remove(getById(id));

    }

    @Override
    public User getById(Integer id) {
        return  entityManager.find(User.class, id);
    }


    @Override
    public User findByUsername(String username) {
        List<User> users = listUsers();
        return users.stream().filter(x -> x.getUsername().equals(username)).findAny().orElse(new User());
    }

    @Override
    public void mergeUser(User user) {
        entityManager.merge(user);
    }
}
