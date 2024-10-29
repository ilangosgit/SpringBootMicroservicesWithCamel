package com.example.domain.Controller;

import com.example.domain.model.DomainRequest;
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

    @PostMapping("/process")
    public ResponseEntity<DomainResponse> process(@RequestBody DomainRequest request) {
        DomainResponse response = domainService.process(request);
        return ResponseEntity.ok(response);
    }
}