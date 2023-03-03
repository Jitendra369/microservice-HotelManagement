package com.apigateway.payload;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String userId;

    private String acessToken;

    private String refreshTOken;
    private long expireAt;
    private Collection<String> authorities;
}
