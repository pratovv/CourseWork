package com.example.smartrep.service;
import com.example.smartrep.dto.*;
import com.example.smartrep.entity.SocialMediaEntity;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.repository.SocialMediaRepository;
import com.example.smartrep.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private SocialMediaRepository socialRepo;

    private Long getSumSalaries(List<UserEntity> users){
        List<Long> salaries = new ArrayList<>();
        Long total = 0L;
        users.forEach(user -> {
            salaries.add((long) user.getSalary());
        });
        for(Long i:salaries){
            total += i;
        }
        return total;
    };
    private Long getSumUsersMark(List<SocialMediaEntity> socialMediaEntities){
        List<Long> socialList = new ArrayList<>();
        Long total = 0L;
        socialMediaEntities.forEach(social -> {
            socialList.add(social.getMoney());
        });
        for(Long i:socialList){
            total += i;
        }
        return total;
    };
    public SocialMoney getSocialMoney(){
        SocialMoney socialMoney = new SocialMoney();
        List<UserEntity> users = repo.findAll();
        SalariesDto salariesDto = new SalariesDto();
        salariesDto.setSum(getSumSalaries(users));
        salariesDto.setName("Зарплата");
        socialMoney.setSalariesDto(salariesDto);
        List<SocialMediaEntity> marketing = getAllSocial();
        MarketingDto marketingDto = new MarketingDto();
        marketingDto.setSum(getSumUsersMark(marketing));
        marketingDto.setName("Маркетинг");
        socialMoney.setMarketingDto(marketingDto);
      return socialMoney;
    };

   
    public List <SocialMediaEntity> getAllSocial(){return socialRepo.findAll();}

    public List<UserEntity> getAllUser() {
        return repo.findAll();
    }

    public Optional<UserEntity> findById(Long id) throws Exception {
        try {
            Optional<UserEntity> user = repo.findById(id);
            return user;
        }catch (Exception e){
            return null;
        }
    }
    public UserEntity createUser(CreateUserDto userDto){
        UserEntity user = new UserEntity();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setSalary(userDto.getSalary());
        user.setUserRole(userDto.getUserRole());
        return repo.save(user);
    }
        public UserEntity updateUser(Long id, UserEntity user) throws Exception {
        try {
            return repo.findById(id)
                    .map(updateProduct-> {
                        updateProduct.setName(user.getName());
                        updateProduct.setSurname(user.getSurname());
                        updateProduct.setPassword(user.getPassword());
                        updateProduct.setSalary(user.getSalary());
                        return repo.save(updateProduct);
                    }).orElseThrow( Exception::new);
        }catch (Exception e){
            return null;
        }
    }

    public Optional<Object> login(UserLogin userLogin)throws Exception{
        try{
            Optional<UserEntity> theUser = repo.findByLogin(userLogin.getLogin());
            Optional<Object> loggedInDto=theUser.map(logged->{
                logged.setId(theUser.get().getId());
                logged.setUserRole(theUser.get().getUserRole());
                logged.setName(theUser.get().getName());
                logged.setSalary(theUser.get().getSalary());
               return logged;
            });
            //возвращает все данные пользователя,хоче чтобы возвращал LoggedinDto
            return loggedInDto;
        }catch (Exception e){
            throw new Exception("Логин неверный",e);
        }
    };
    public void deleteById(Long id) {
            repo.deleteById(id);
    }

}
