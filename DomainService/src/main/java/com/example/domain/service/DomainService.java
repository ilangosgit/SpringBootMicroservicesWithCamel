package com.example.domain.service;

import com.example.domain.model.DomainResponse;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainService implements IDomainService {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    @Override
    public DomainResponse process(String data) {
        try {
            // Log the state of the Camel context
            if (camelContext.isStopped()) {
                throw new IllegalStateException("CamelContext is stopped");
            }

            // Send request to the Camel route
            String adapterResponse = producerTemplate.requestBody("direct:callAdapterService", data, String.class);

            // Create and return the domain response
            DomainResponse response = new DomainResponse();
            response.setResult("Processed: " + adapterResponse);
            return response;
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Rethrow the exception to be handled by the controller
            throw new RuntimeException("Error processing request", e);
        }
    }
}