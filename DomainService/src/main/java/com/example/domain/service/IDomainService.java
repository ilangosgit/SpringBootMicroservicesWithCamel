package com.example.domain.service;


import com.example.domain.model.DomainResponse;

public interface IDomainService {
    DomainResponse process(String data);
}