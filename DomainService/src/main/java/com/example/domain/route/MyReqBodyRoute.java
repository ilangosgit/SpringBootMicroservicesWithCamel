package com.example.domain.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.domain.model.*;
import com.example.domain.service.MyReqBodyService;


@Component
public class MyReqBodyRoute extends RouteBuilder {

    @Autowired
    private MyReqBodyService myService;

    @Override
    public void configure() throws Exception {
        from("rest:post:myEndpoint")
            .unmarshal().json(JsonLibrary.Jackson,MyReqBody.class) // Convert JSON request body to MyRequest body object
            .bean(myService, "processRequest"); // Call the service method with the MyRequest object
    }
}