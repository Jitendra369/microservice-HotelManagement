package com.userservice.controller;

import com.userservice.entity.Hotel;
import com.userservice.entity.User;
import com.userservice.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //    save user
    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //    get All User
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUsers =
                this.userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }


    int retryCount= 1;
    //  get User
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "hotelRatingBreaker", fallbackMethod = "ratingHotelFallBack")
    @Retry(name = "hotelRatingBreaker", fallbackMethod = "ratingHotelFallBack")
//    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
        logger.info("retry count "+ retryCount);
        retryCount++;
        User user = this.userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    calling fallback method if service is down
//     return type of controller and fallback method must be same
    public ResponseEntity<?> ratingHotelFallBack(String userId, Exception ex){
        logger.info("calling to fallbackMethod for userservice, beacause service is down");
        User user = User.builder().name("jittu").about("ruturn dummy user , because some service is down ").build();
        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/allHotel")
    public ResponseEntity<?> getAllHotel(){
        List<Hotel> allHotel = this.userService.getAllHotel();
        return  new ResponseEntity<>(allHotel, HttpStatus.OK);
    }
}


