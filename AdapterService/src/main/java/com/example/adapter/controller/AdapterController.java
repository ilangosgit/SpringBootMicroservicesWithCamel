package com.example.adapter.controller;

import com.example.adapter.model.AdapterRequest;
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

    @PostMapping("/handle")
    public ResponseEntity<AdapterResponse> handle(@RequestBody AdapterRequest request) {
        AdapterResponse response = adapterService.handle(request);
        return ResponseEntity.ok(response);
    }
}