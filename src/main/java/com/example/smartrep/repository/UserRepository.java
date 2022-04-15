package com.example.smartrep.repository;

import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByIdAndStatus(Integer id, Status status);
}