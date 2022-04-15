package com.example.smartrep.repository;

import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.entity.Tutorial;
import com.example.smartrep.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findById(Integer id);
}