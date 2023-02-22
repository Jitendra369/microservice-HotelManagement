package com.hotelrating.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_rating")
public class Rating {

//    in mongo db id is auto generated, by default
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    //    out of 5
    private int rating;
    private String feeback;
}
