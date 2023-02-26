package com.userservice;

import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.external.service.HotelRating;
import com.userservice.external.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MicroserviceUserServiceApplicationTests {

    @Autowired
    private HotelRating hotelRating;

    @Autowired
    private HotelService hotelService;

    @Test
    void getAllHotelInfor(){
        ResponseEntity<List<Hotel>> allHotelList =
                this.hotelService.getAllHotelList();

        List<Hotel> body = allHotelList.getBody();
        body.forEach(hotel -> System.out.println(hotel.getName()));
    }

    @Test
    void getSingleHotelInfor(){
        ResponseEntity<Hotel> hotel = this.hotelService
                .getHotel("72db342b-678c-486b-8d37-25b97851cec6");
        System.out.println(hotel.getBody().getName());
    }

    @Test
    void contextLoads() {
    }

    @Test
    void creatingRating(){
        Rating rating = Rating.builder()
                .rating(5)
                .userId("b206eb51-a9e7-4c4b-8aa1-bd3c083bce3b")
                .feeback("THis is Bad ")
                .hotelId("")
                .build();

        ResponseEntity<Rating> respEntity = this.hotelRating.creatingRating(rating);
        System.out.println("Body " +respEntity.getBody());
        System.out.println("Status Code "+respEntity.getStatusCode());

    }

}
