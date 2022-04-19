package com.example.smartrep.service;

import com.example.smartrep.dto.ManagerTodoDto;
import com.example.smartrep.entity.ManagerTodoEntity;
import com.example.smartrep.repository.ManagerTodoRepository;
import com.example.smartrep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerTodoService {
    @Autowired
    ManagerTodoRepository repo;

    @Autowired
    UserRepository userRepo;

    public ManagerTodoEntity addNewTodo(ManagerTodoDto managerTodoDto) throws Exception {
        ManagerTodoEntity managerTodoEntity = new ManagerTodoEntity();
        managerTodoEntity.setTitle(managerTodoDto.getTitle());
        managerTodoEntity.setDescription(managerTodoDto.getDescription());
        Date date = new Date();
        managerTodoEntity.setDate(String.valueOf(date));
        managerTodoEntity.setStatus(false);
        managerTodoEntity.setUser(userRepo.findById(managerTodoDto.getUser()).orElse(null));
        return repo.save(managerTodoEntity);
    }
    public List<ManagerTodoEntity> all(){
        return repo.findAll();
    }
    public List<ManagerTodoDto>allTodobyUserIdActive(long userId){
        List<ManagerTodoEntity> list = repo.findByStatusAndUserId(userId);
        List<ManagerTodoDto> result = new ArrayList<>();
        for(ManagerTodoEntity manager:list){
            ManagerTodoDto model = new ManagerTodoDto();
            model.setUser(manager.getUser().getId());
            model.setDescription(manager.getDescription());
            model.setTitle(manager.getTitle());
            result.add(model);
        }
        return result;
    }
    public List<ManagerTodoDto>allTodobyUserIdDone(long userId){
        List<ManagerTodoEntity> list = repo.findByStatusAndUserIdd(userId);
        List<ManagerTodoDto> result = new ArrayList<>();
        for(ManagerTodoEntity manager:list){
            ManagerTodoDto model = new ManagerTodoDto();
            model.setUser(manager.getUser().getId());
            model.setDescription(manager.getDescription());
            model.setTitle(manager.getTitle());
            result.add(model);
        }
        return result;
    }
    public ManagerTodoEntity updateStatus(long todoId){
        ManagerTodoEntity found = repo.findByNujnoId(todoId);
        found.setStatus(true);
        repo.save(found);
        return found;
    }
    public void delete(long id){
        repo.deleteById(id);
    }
}
