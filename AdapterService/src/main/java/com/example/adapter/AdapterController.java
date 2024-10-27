package com.example.adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdapterController {

    @GetMapping("/adapter/data")
    public String getAdapterData() {
        return "Data from Adapter Service";
    }
}