package com.microservice.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    private String id;
    @Column(name = "hotel_name")
    private String name;

    @Column(name = "hotel_loc")
    private String location;

    @Column(name = "about")
    private String about;
}
