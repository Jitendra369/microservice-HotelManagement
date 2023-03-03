package com.userservice.impl;

import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.entity.User;

import com.userservice.exception.ResourceNotFounds;
import com.userservice.external.service.HotelRating;
import com.userservice.external.service.HotelService;
import com.userservice.repo.UserRepo;
import com.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;   // it is using feign client

    @Autowired
    private HotelRating hotelRating;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<Hotel> getAllHotel() {
        ResponseEntity<List<Hotel>> allHotelList = this.hotelService.getAllHotelList();
        List<Hotel> body = allHotelList.getBody();
        return  body;
    }

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

//    this method call hotelService and then call HotelRating , we have to use circuit breaker in this scenerio
    @Override
    public User getUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFounds("user id not found " + userId));

//        fetch the rating of user from Rating service
//        url
//        http://localhost:8082/rating/user/b206eb51-a9e7-4c4b-8aa1-bd3c083bce3b
//        this lin ge an error
//        ArrayList<Rating> allRatingOfUser = restTemplate.getForObject("http://localhost:8082/rating/user/"+ user.getId(), ArrayList.class);
//        calling to rating service
//        Rating[] allRatingOfUser = restTemplate.getForObject("http://HOTEL-RATING/rating/user/"+ user.getId(), Rating[].class);
//        convert to list
//        List<Rating> ratings = Arrays.stream(allRatingOfUser).toList();

//        logger.info("{}", ratings);

        ResponseEntity<List<Rating>> ratingByUser = this.hotelRating.getRatingByUser(user.getId());// using feighClient
        List<Rating> ratings = ratingByUser.getBody();
        System.out.println("ratings from reating-service");
//        get all rating information
        ratings.forEach(rating -> System.out.println(rating.getRatingId()));
        user.setRatings(ratings);

        /* here we have to set hotel to rating object , */
        List<Rating> userHotelsRating = ratings.stream().map(raitng  -> {
//             api call to hotel service to get hotel
//            calling to hotel service
//            http://localhost:8081/hotel/72db342b-678c-486b-8d37-25b97851cec6
//            ResponseEntity<Hotel> forEntity = this.restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+ userH.getHotelId(), Hotel.class);
//            get hotel from response
//            Hotel hotel = forEntity.getBody();
            logger.info("Hotel Id "+ raitng.getHotelId());
            ResponseEntity<Hotel> hotelResponse = hotelService.getHotel(raitng.getHotelId());
            logger.info("status code ", hotelResponse.getStatusCode());

            Hotel hotel = hotelResponse.getBody();
//            logger.info("response status code  "+forEntity.getStatusCode());

//            set Hotel object to user object
            raitng.setHotel(hotel);
//          return user with the hotel
            return raitng;
        }).collect(Collectors.toList());

        user.setRatings(userHotelsRating);

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
