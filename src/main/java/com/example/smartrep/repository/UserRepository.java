package com.example.smartrep.repository;

import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserEntity> findByLogin(String login);
}