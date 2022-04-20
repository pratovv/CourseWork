package com.example.smartrep.repository;

import com.example.smartrep.entity.ManagerTodoEntity;
import com.example.smartrep.entity.TodoEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoEmployeeRepo extends JpaRepository<TodoEmployeeEntity,Long> {
    @Query(value = "SELECT m from TodoEmployeeEntity m WHERE m.manager.id=:id")
    List<TodoEmployeeEntity> findByManagerId(Long id);
    @Query(value = "SELECT m from TodoEmployeeEntity m WHERE m.employee.id=:id and m.status=false ")
    List<TodoEmployeeEntity> findByEmplActive(Long id);
    @Query(value = "SELECT m from TodoEmployeeEntity m WHERE m.employee.id=:id and m.status=true ")
    List<TodoEmployeeEntity> findByEmplDone(Long id);

    @Query(value = "SELECT m from TodoEmployeeEntity m WHERE m.id=:id")
    TodoEmployeeEntity findByNujnoId(Long id);
}
