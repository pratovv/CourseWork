package com.example.smartrep.controller;


import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService service;
    @GetMapping("/all")
    public List<DistrictEntity> getAll(){return service.getAllDistrict();}
}
