package com.example.smartrep.controller;

import com.example.smartrep.dto.ManagerTodoDto;
import com.example.smartrep.entity.ManagerTodoEntity;
import com.example.smartrep.service.ManagerTodoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ManagerTodo")
public class ManagerTodoController {
    @Autowired
    ManagerTodoService service;
    @PostMapping("/create")
    public ManagerTodoEntity create(ManagerTodoDto managerTodoDto) throws Exception {
        return service.addNewTodo(managerTodoDto);
    }

    @GetMapping("/all")
    public List<ManagerTodoEntity>all(){
        return service.all();
    }

    @GetMapping("/get-activetodo-manager/{user}")
    public List<ManagerTodoDto>getAllByIdAndActive(@PathVariable Long user){
        return service.allTodobyUserIdActive(user);
    }
    @GetMapping("/get-donetodo-manager/{user}")
    public List<ManagerTodoDto>getDone(@PathVariable Long user){
        return service.allTodobyUserIdDone(user);
    }
    @PutMapping("/updateStatus/{todoId}")
    public ManagerTodoEntity updateStatus(@PathVariable Long todoId){
        return service.updateStatus(todoId);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
