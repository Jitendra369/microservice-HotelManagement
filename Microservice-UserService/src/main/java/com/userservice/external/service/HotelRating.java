package com.userservice.external.service;

import com.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name = "HOTEL-RATING")
public interface HotelRating {

//    get all rating of perticular user
    @GetMapping("/rating/user/{userId}")
    ResponseEntity<List<Rating>> getRatingByUser(@PathVariable("userId") String userId);

//    post
//    creating rating, Ratincg Class we have to provide hotel and user information.
    @PostMapping("/rating/")
    ResponseEntity<Rating> creatingRating(Rating rating);

//    update
    @PutMapping("/rating/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId ,Rating rating);

//    delete
    @DeleteMapping("/rating/{ratingId}")
    void deleteRating(@PathVariable("ratingId") String ratingId);

}
