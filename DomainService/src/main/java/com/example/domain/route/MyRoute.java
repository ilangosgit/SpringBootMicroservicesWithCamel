package com.example.domain.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Value("${adapter.service.url}")
    private String adapterServiceUrl;

    @Override
    public void configure() throws Exception {
        from("direct:callAdapterService")
            .routeId("callAdapterServiceRoute")
            .log("Sending request to Adapter Service: ${body}")
            .toD("http4://" + adapterServiceUrl + "?bridgeEndpoint=true")
            .log("Received response from Adapter Service: ${body}");
    }
}