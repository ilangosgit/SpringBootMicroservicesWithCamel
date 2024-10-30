package com.example.adapter.controller;

import com.example.adapter.model.AdapterResponse;
import com.example.adapter.service.IAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adapter")
public class AdapterController {

    @Autowired
    private IAdapterService adapterService;

    @GetMapping("/handle")
    public ResponseEntity<AdapterResponse> handle(@RequestParam String info) {
        try {
            AdapterResponse response = adapterService.handle(info);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Return a 500 Internal Server Error response
            return ResponseEntity.status(500).body(new AdapterResponse());
        }
    }
}