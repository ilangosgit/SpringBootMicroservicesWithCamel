package com.example.adapter.service;

import com.example.adapter.model.AdapterResponse;
import org.springframework.stereotype.Service;

@Service
public class AdapterService implements IAdapterService {
    @Override
    public AdapterResponse handle(String info) {
        AdapterResponse response = new AdapterResponse();
        response.setOutcome("Handled: " + info);
        return response;
    }
}