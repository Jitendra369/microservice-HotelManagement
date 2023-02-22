package com.microservice.hotel.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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
