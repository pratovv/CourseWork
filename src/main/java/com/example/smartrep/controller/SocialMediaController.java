package com.example.smartrep.controller;


import com.example.smartrep.dto.CreateDistrictDto;
import com.example.smartrep.dto.CreateSocialMediaDto;
import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.entity.SocialMediaEntity;
import com.example.smartrep.service.DistrictService;
import com.example.smartrep.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/social")
public class SocialMediaController {
    @Autowired
    private SocialMediaService service;
    @GetMapping("/all")
    public List<SocialMediaEntity> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<SocialMediaEntity> getProduct(@PathVariable("id") Long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<SocialMediaEntity> createVacancy(@RequestBody CreateSocialMediaDto createSocialMediaDto)
    {
        return new ResponseEntity<>(service.createSocialMedia(createSocialMediaDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public SocialMediaEntity putProduct(@PathVariable("id") Long id ,
                              @RequestBody SocialMediaEntity model) throws Exception {
        return service.updateSocial(id,model);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDistrict(@PathVariable("id") Long id){
        service.deleteById(id);
    }
}
