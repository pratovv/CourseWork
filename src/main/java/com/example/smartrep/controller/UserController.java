package com.example.smartrep.controller;

import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.dto.SocialMoney;
import com.example.smartrep.dto.UserLogin;
import com.example.smartrep.entity.SocialMediaEntity;
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

    @PostMapping("/login")
    public Optional<Object> authUser(@RequestBody UserLogin userLogin)throws Exception{
        try{
            return service.login(userLogin);
        }catch (Exception e){
            throw new Exception("Incorrect username and password", e);
        }
    }
    @GetMapping("/get-social-money")
    public SocialMoney getSocialMoney(){return service.getSocialMoney();}
    @GetMapping("/allMedia")
    public List<SocialMediaEntity> getAllMedia(){return service.getAllSocial();}
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
