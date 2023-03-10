package com.hotelrating.impl;

import com.hotelrating.entity.Rating;
import com.hotelrating.repo.RatingRepo;
import com.hotelrating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;


    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return this.ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(Rating rating) {
//        todo: handle the exception
        Rating updateRating = this.ratingRepo.findById(rating.getRatingId()).get();
        updateRating.setRating(rating.getRating());
        updateRating.setUserId(rating.getUserId());
        updateRating.setFeeback(rating.getFeeback());
        updateRating.setHotelId(rating.getHotelId());
        return updateRating;
    }

    @Override
    public void deleteRating(String ratingId) {
        this.ratingRepo.deleteById(ratingId);
    }
}
