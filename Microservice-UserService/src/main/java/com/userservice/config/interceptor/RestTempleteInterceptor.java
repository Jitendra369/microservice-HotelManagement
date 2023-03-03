package com.userservice.config.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

public class RestTempleteInterceptor
        implements org.springframework.http.client.ClientHttpRequestInterceptor {

    private OAuth2AuthorizedClientManager manager;

//    constructor
    public RestTempleteInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String token = manager
                .authorize(OAuth2AuthorizeRequest
                        .withClientRegistrationId("my-internal-client")
                        .principal("internal")
                        .build())
                .getAccessToken().getTokenValue();

        request.getHeaders().add("Authorization","Bearer "+ token);
        return execution.execute(request,body);
    }
}
