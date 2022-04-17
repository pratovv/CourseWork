package com.example.smartrep.controller;

import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.service.UserService;
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
    public Optional<UserEntity> getProduct(@PathVariable("id") Long id) throws Exception{
        return service.findById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<UserEntity> createVacancy(@RequestBody CreateUserDto userDto)
    {
        return new ResponseEntity<>(service.createUser(userDto), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public UserEntity putUser(@PathVariable("id") Long id ,
                                     @RequestBody UserEntity model) throws Exception {
        return service.updateUser(id,model);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePeople(@PathVariable("id") Long id){
         service.deleteById(id);
    }

}
