package com.userservice.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
//    out of 5
    private int rating;
    private String feeback;

    private Hotel hotel;
}
