package com.userservice.controller;

import com.userservice.entity.Hotel;
import com.userservice.entity.User;
import com.userservice.impl.UserServiceImpl;
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


    //  get User
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
        User user = this.userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/allHotel")
    public ResponseEntity<?> getAllHotel(){
        List<Hotel> allHotel = this.userService.getAllHotel();
        return  new ResponseEntity<>(allHotel, HttpStatus.OK);
    }
}


