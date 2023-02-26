package com.microservice.hotel.controller;

import com.microservice.hotel.entity.Hotel;
import com.microservice.hotel.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

//    save hotel handler
    @PostMapping("/")
    public ResponseEntity<Hotel> saveHotel( @RequestBody Hotel hotel){
        this.hotelService.saveHotel(hotel);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.CREATED);
    }

//    get hotel handler
    @GetMapping("/{hotelId}")
    public  ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId){
        Hotel hotel = this.hotelService.getHotel(hotelId);
        return new ResponseEntity<>(hotel , HttpStatus.OK);
    }

//    get all hotel handler
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotelInfor(){
        List<Hotel> allHotel = this.hotelService.getAllHotel();
        return new ResponseEntity<>(allHotel, HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable("hotelId") String hotelId){
        this.hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>("hotel deleted id : "+ hotelId, HttpStatus.OK);
    }


}
