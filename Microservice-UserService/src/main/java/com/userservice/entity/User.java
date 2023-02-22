package com.userservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "micro_user")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "username", length = 15)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "about")
    private String about;

//    not save in dataBase
//    for rating we have different micro-server
    @Transient
    private List<Rating> ratings = new ArrayList<>();


}
