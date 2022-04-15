package com.example.smartrep.service;
import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.dto.UpdateUserDto;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.enums.Status;
import com.example.smartrep.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<UserEntity> getAllUser() {
        return repo.findAll();
    }


    public UserEntity findById(Integer id) throws Exception {
        UserEntity user = repo.findByIdAndStatus(id, Status.ACTIVE);
        if(user==null){
            throw new Exception("user id is null");
        }
        return user;
    }
    public UserEntity createUser(CreateUserDto userDto){
        UserEntity user = new UserEntity();

        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setSalary(userDto.getSalary());
        user.setUserRole(userDto.getUserRole());
        return repo.save(user);
    }
    public UserEntity updateUserById(Integer id, UpdateUserDto updateUserDto) throws Exception {
        UserEntity user = repo.findById(id).orElseThrow(
                ()-> new Exception("нет здания с таким id = ")
        );
        return user;
    }
}
