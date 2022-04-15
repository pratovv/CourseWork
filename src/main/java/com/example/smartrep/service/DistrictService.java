package com.example.smartrep.service;

import com.example.smartrep.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;
}
