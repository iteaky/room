package com.fit.room.service;

import com.fit.room.dao.UserDAO;
import com.fit.room.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    public User findById(long id) {
        return userDAO.getOne(id);
    }

    public boolean isUserExist(User user) {
        return userDAO.findByName(user.getName()) != null;
    }

    public void saveUser(User user) {
        userDAO.save(user);
    }

    public void deleteUserById(long id) {
        userDAO.deleteById(id);
    }

    public void deleteAllUsers() {
        userDAO.deleteAll();
    }
}
