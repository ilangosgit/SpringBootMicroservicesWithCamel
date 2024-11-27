package com.example.domain.service;

import org.springframework.stereotype.Service;
import com.example.domain.model.MyReqBody;

@Service
public class MyReqBodyService {
    public void processRequest(MyReqBody request) {
        // Process the request
        System.out.println("Processing request: " + request.getName() + ", " + request.getAge());
    }
}