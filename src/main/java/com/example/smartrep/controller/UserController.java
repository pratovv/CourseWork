package com.example.smartrep.controller;

import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.entity.Tutorial;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.repository.UserRepository;
import com.example.smartrep.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/all")
    public List<UserEntity> getAll(){return service.getAllUser();}
    @GetMapping("/{id}")
    public Optional<UserEntity> getProduct(@PathVariable("id") Integer id){
        return service.findById(id);
    }


}
