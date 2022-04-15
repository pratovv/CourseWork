package com.example.smartrep.controller;

import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.dto.UpdateUserDto;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/all")
    public List<UserEntity> getAll(){return service.getAllUser();}
    @GetMapping("/{id}")
    public UserEntity getProduct(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<UserEntity> createVacancy(@RequestBody CreateUserDto userDto)
    {
        return new ResponseEntity<>(service.createUser(userDto), HttpStatus.OK);
    }
    @PutMapping("/image/{id}")
    public UserEntity updateUser(@PathVariable Integer id, UpdateUserDto updateUserDto) throws Exception {
        return service.updateUserById(id,updateUserDto);
    }

}
