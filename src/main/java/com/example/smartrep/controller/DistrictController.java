package com.example.smartrep.controller;


import com.example.smartrep.dto.CreateDistrictDto;
import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService service;

    @GetMapping("/all")
    public List<DistrictEntity> getAll(){return service.getAllDistrict();}

    @GetMapping("/{id}")
    public Optional<DistrictEntity> getProduct(@PathVariable("id") Long id) throws Exception{
        return service.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<DistrictEntity> createVacancy(@RequestBody CreateDistrictDto districtDto)
    {
        return new ResponseEntity<>(service.createDistrict(districtDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public DistrictEntity putProduct(@PathVariable("id") Long id ,
                              @RequestBody DistrictEntity model) throws Exception {
        return service.updateDistrict(id,model);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDistrict(@PathVariable("id") Long id){
        service.deleteById(id);
    }
}
