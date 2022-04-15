package com.example.smartrep.service;
import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.repository.UserRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<UserEntity> getAllUser() {
        return repo.findAll();
    }


    public Optional<UserEntity> findById(Integer id) {
        try {
            Optional<UserEntity> user= repo.findById(id);
            return user;
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}
