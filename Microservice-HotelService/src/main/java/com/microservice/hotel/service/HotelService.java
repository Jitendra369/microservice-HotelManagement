package com.microservice.hotel.service;


import com.microservice.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotel(String hotelId);

    List<Hotel> getAllHotel();

    void deleteHotel(String hotelId);

    Hotel updateHotel(Hotel hotel, String hotelId);
}
