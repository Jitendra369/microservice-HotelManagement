package com.userservice.impl;

import com.userservice.entity.User;

import com.userservice.exception.ResourceNotFounds;
import com.userservice.repo.UserRepo;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
//        generate unique id
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFounds("user id not found "+ userId));
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }
}
