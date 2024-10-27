package com.example.domain;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DomainRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // Assuming we have a method to get the OAuth2 token
        String token = null;
        if (token == null) {
            token = getOAuth2Token();
        }
        
        from("direct:callMicroservice")
            //.setHeader("Authorization", simple("Bearer " + token))
            .to("http://localhost:8081/adapter/data")
            .log("Response: ${body}");
    }

    private String getOAuth2Token() {
        // Implement the logic to get the OAuth2 token
        return "your_oauth2_token";
    }
}