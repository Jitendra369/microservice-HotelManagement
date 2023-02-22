package com.hotelrating.repo;

import com.hotelrating.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating, String> {

//    get All rating by User
    List<Rating> findByUserId(String userId);

//    get all rating by hotel
    List<Rating> findByHotelId(String hotelId);
}
