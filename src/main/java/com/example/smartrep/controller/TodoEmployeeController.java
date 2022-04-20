package com.example.smartrep.controller;

import com.example.smartrep.dto.TodoEmployeeDto;
import com.example.smartrep.entity.ManagerTodoEntity;
import com.example.smartrep.entity.SocialMediaEntity;
import com.example.smartrep.entity.TodoEmployeeEntity;
import com.example.smartrep.service.TodoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo-employee")
public class TodoEmployeeController {
    @Autowired
    TodoEmployeeService service;
    @GetMapping("/all")
    public List<TodoEmployeeEntity> getAll(){
        return service.getAll();
    }
    @PostMapping("/manager-create")
    public TodoEmployeeEntity create(TodoEmployeeDto todoEmployeeDto){
        return service.create(todoEmployeeDto);
    }
    @GetMapping("/find-directionsOfManager/{id}")
    public List<TodoEmployeeEntity> findByManager(@PathVariable("id") Long id){
        return service.findByManagerId(id);
    }
    @GetMapping("/find-worker-active/{id}")
    public List<TodoEmployeeEntity> employeeactive(@PathVariable("id") Long id){
        return service.findByEmployeeIdActive(id);
    }
    @GetMapping("/find-worker-done/{id}")
    public List<TodoEmployeeEntity> employeedone(@PathVariable("id") Long id){
        return service.findByEmployeeIdDone(id);
    }
    @PutMapping("/updateFromActive/{id}")
    public TodoEmployeeEntity changeToDone(@PathVariable("id") Long id){
     return service.updateStatus(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
