package com.example.domain;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DomainRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:callMicroservice")
            .to("http://localhost:8081/adapter/data")
            .log("Response: ${body}");
    }
}