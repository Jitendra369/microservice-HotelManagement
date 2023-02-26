package com.hotelrating.controller;

import com.hotelrating.entity.Rating;
import com.hotelrating.impl.RatingServiceImpl;
import com.hotelrating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating saveRating = this.ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRating);
    }

//    get all
    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> allRating = this.ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.OK).body(allRating);
    }

//    get rating according to user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingOfUser(@PathVariable("userId") String userId){
        List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotel(@PathVariable("hotelId") String hotelId){
        List<Rating> ratingByHotel = this.ratingService.getRatingByHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByHotel);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<?>  deleteRating( @PathVariable("ratingId") String ratingId){
        this.ratingService.deleteRating(ratingId);
        return new ResponseEntity<>("delete rating id :"+ ratingId,HttpStatus.OK);
    }
}
