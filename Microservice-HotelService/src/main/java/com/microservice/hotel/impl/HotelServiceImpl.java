package com.microservice.hotel.impl;

import com.microservice.hotel.entity.Hotel;
import com.microservice.hotel.payload.NoResourceFoundExce;
import com.microservice.hotel.repo.HotelRepo;
import com.microservice.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel saveHotel(Hotel hotel) {
//        we have to create unique id for hotel
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return this.hotelRepo.save(hotel);

    }

    @Override
    public Hotel getHotel(String hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(() -> new NoResourceFoundExce("No dada found of giver id"));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return this.hotelRepo.findAll();
    }

    @Override
    public void deleteHotel(String hotelId) {
        this.hotelRepo.deleteById(hotelId);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, String hotelId) {
//        check weather the hotel present or not
        Hotel savedHotel = this.hotelRepo.findById(hotelId).orElseThrow(() -> new NoResourceFoundExce("no data found"));
        hotel.setName(savedHotel.getName());
        hotel.setAbout(savedHotel.getAbout());
        hotel.setLocation(savedHotel.getLocation());

        return this.hotelRepo.save(savedHotel);
    }
}
