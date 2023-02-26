package com.hotelrating.service;

import com.hotelrating.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotel(String hotelId);

    Rating updateRating(Rating rating);

    void deleteRating(String ratingId);
}
