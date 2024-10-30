package com.example.domain.controller;

import com.example.domain.model.DomainResponse;
import com.example.domain.service.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private IDomainService domainService;

    @GetMapping("/process")
    public ResponseEntity<DomainResponse> process(@RequestParam String data) {
        try {
            System.out.println("Inside rest controller Processing request: " + data);
            DomainResponse response = domainService.process(data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Return a 500 Internal Server Error response
            return ResponseEntity.status(500).body(new DomainResponse());
        }
    }
}