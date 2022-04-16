package com.example.smartrep.repository;

import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.entity.SocialMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaRepository extends JpaRepository<SocialMediaEntity, Long> {
}
