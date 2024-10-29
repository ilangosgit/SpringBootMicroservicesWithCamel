package com.example.adapter.service;

import com.example.adapter.model.AdapterRequest;
import com.example.adapter.model.AdapterResponse;
import org.springframework.stereotype.Service;

@Service
public class AdapterService implements IAdapterService {
    @Override
    public AdapterResponse handle(AdapterRequest request) {
        AdapterResponse response = new AdapterResponse();
        response.setOutcome("Handled: " + request.getInfo());
        return response;
    }
}