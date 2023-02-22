package com.microservice.hotel.repo;

import com.microservice.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String> {
}
