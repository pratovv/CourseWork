package com.example.smartrep.controller;


import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService service;
    @GetMapping("/all")
    public List<DistrictEntity> getAll(){return service.getAllDistrict();}
    @PutMapping("/{id}")
    public DistrictEntity putProduct(@PathVariable("id") Short id ,
                              @RequestBody DistrictEntity model) throws Exception {
        return service.updateDistrict(id,model);
    }
}
