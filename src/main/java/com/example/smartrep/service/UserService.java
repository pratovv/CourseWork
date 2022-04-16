package com.example.smartrep.service;
import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.entity.UserEntity;
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

    public Optional<UserEntity> findById(Long id) throws Exception {
        Optional<UserEntity> user = repo.findById(id);
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
        public UserEntity updateUser(Long id, UserEntity user) throws Exception {
        return repo.findById(id)
                .map(updateProduct-> {
                    updateProduct.setName(user.getName());
                    updateProduct.setSurname(user.getSurname());
                    updateProduct.setPassword(user.getPassword());
                    updateProduct.setSalary(user.getSalary());
                    return repo.save(updateProduct);
                }).orElseThrow( Exception::new);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
