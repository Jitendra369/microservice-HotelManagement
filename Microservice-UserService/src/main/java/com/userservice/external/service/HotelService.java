package com.userservice.external.service;

import com.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

//    @GetMapping("/hotel/{hotelId}")
//    Hotel getHotel(@PathVariable("hotelId") String hotelId);

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/{hotelId}")
    ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId);

//    get All hotel information
    @GetMapping("/hotel/all")
    ResponseEntity<List<Hotel>> getAllHotelList();
}
