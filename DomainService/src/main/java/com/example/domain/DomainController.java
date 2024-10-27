package com.example.domain;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/call-external")
    public String callExternal() {
        return producerTemplate.requestBody("direct:callMicroservice", null, String.class);
    }
}