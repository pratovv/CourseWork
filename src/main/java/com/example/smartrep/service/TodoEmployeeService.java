package com.example.smartrep.service;

import com.example.smartrep.dto.TodoEmployeeDto;
import com.example.smartrep.entity.ManagerTodoEntity;
import com.example.smartrep.entity.TodoEmployeeEntity;
import com.example.smartrep.repository.TodoEmployeeRepo;
import com.example.smartrep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service()
public class TodoEmployeeService {
    @Autowired
    private TodoEmployeeRepo repo;

    @Autowired
    private UserRepository userRepo;
    public List<TodoEmployeeEntity> getAll(){
        return repo.findAll();
    }
    public TodoEmployeeEntity create(TodoEmployeeDto todoEmployeeDto){
        TodoEmployeeEntity todoEmployeeEntity = new TodoEmployeeEntity();
        todoEmployeeEntity.setTitle(todoEmployeeDto.getTitle());
        todoEmployeeEntity.setDescription(todoEmployeeDto.getDescription());
        todoEmployeeEntity.setStatus(false);
        Date date = new Date();
        todoEmployeeEntity.setDate(String.valueOf(date));
        todoEmployeeEntity.setManager(userRepo.findById(todoEmployeeDto.getManagerId()).orElse(null));
        todoEmployeeEntity.setEmployee(userRepo.findById(todoEmployeeDto.getEmployeeId()).orElse(null));
        return repo.save(todoEmployeeEntity);
    }
    public List<TodoEmployeeEntity> findByManagerId(Long id){
        return repo.findByManagerId(id);
    }
    public List<TodoEmployeeEntity>findByEmployeeIdActive(Long id){
        return repo.findByEmplActive(id);
    }
    public List<TodoEmployeeEntity>findByEmployeeIdDone(Long id){
        return repo.findByEmplDone(id);
    }
    public TodoEmployeeEntity updateStatus(long todoId){
        TodoEmployeeEntity found = repo.findByNujnoId(todoId);
        found.setStatus(true);
        repo.save(found);
        return found;
    }
    public void delete(long id){
        repo.deleteById(id);
    }
}
