package com.userservice.impl;

import com.userservice.entity.Rating;
import com.userservice.entity.User;

import com.userservice.exception.ResourceNotFounds;
import com.userservice.repo.UserRepo;
import com.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFounds("user id not found " + userId));
//        fetch the rating of user from Rating service
//        url
//        http://localhost:8082/rating/user/b206eb51-a9e7-4c4b-8aa1-bd3c083bce3b
        ArrayList<Rating> allRatingOfUser = restTemplate.getForObject("http://localhost:8082/rating/user/"+ user.getId(), ArrayList.class);
        logger.info("{}",allRatingOfUser);
        user.setRatings(allRatingOfUser);
        return user;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }
}
