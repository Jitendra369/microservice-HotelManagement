package com.userservice.service;

import com.userservice.entity.Hotel;
import com.userservice.entity.User;
import com.userservice.external.service.HotelService;

import java.util.List;

public interface UserService {

    List<Hotel> getAllHotel();
    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    void deleteUser(String userId);

    User updateUser(String userId, User user);
}
