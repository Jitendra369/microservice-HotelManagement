package com.userservice.service;

import com.userservice.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    void deleteUser(String userId);

    User updateUser(String userId, User user);
}
