package com.example.adapter.service;


import com.example.adapter.model.AdapterResponse;

public interface IAdapterService {
    AdapterResponse handle(String request);
}