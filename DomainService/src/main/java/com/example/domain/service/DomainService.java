package com.example.domain.service;

import com.example.domain.model.DomainRequest;
import com.example.domain.model.DomainResponse;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainService implements IDomainService {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public DomainResponse process(DomainRequest request) {
        // Send request to the Camel route
        String adapterResponse = producerTemplate.requestBody("direct:callAdapterService", request.getData(), String.class);

        // Create and return the domain response
        DomainResponse response = new DomainResponse();
        response.setResult("Processed: " + adapterResponse);
        return response;
    }
}