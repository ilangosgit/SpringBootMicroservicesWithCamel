package com.example.domain.controller;  

import com.example.domain.model.*;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/domain")
public class DomainController {


    @Autowired
    private ProducerTemplate producerTemplate;



    @PostMapping("/requestbody")
    public String prcessbody(@RequestBody MyReqBody request) {
        // Send the request body to the Camel route
        producerTemplate.sendBody("direct:start", request);
        return "Request processed";
    }


}