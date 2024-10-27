package com.example.domain;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainController {

    @Autowired
    private ProducerTemplate producerTemplate;

    public String callExternalMicroservice() {
        return producerTemplate.requestBody("direct:callMicroservice", null, String.class);
    }
}