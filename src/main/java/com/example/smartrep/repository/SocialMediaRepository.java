package com.example.smartrep.repository;

import com.example.smartrep.entity.SocialMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocialMediaRepository extends JpaRepository<SocialMediaEntity, Long> {
    @Query(value = "select money from socialmedia",nativeQuery = true)
    List<Integer> findByEmailAddress();

}
