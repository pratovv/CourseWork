package com.example.smartrep.repository;

import com.example.smartrep.entity.ManagerTodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManagerTodoRepository extends JpaRepository<ManagerTodoEntity, Long> {

    @Query(value = "SELECT m from ManagerTodoEntity m WHERE m.status=true and m.user.id=:id")
    List<ManagerTodoEntity> findByStatusAndUserIdd(Long id);
    @Query(value = "SELECT m from ManagerTodoEntity m WHERE m.status=false and m.user.id=:id")
    List<ManagerTodoEntity> findByStatusAndUserId(Long id);
    @Query(value = "SELECT m from ManagerTodoEntity m WHERE m.id=:id")
    ManagerTodoEntity findByNujnoId(Long id);
}
