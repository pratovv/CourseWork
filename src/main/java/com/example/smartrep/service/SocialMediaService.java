package com.example.smartrep.service;

import com.example.smartrep.dto.CreateSocialMediaDto;
import com.example.smartrep.dto.CreateUserDto;
import com.example.smartrep.entity.SocialMediaEntity;
import com.example.smartrep.entity.UserEntity;
import com.example.smartrep.repository.SocialMediaRepository;
import com.example.smartrep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaService {
    @Autowired
    private SocialMediaRepository repo;
    public List<SocialMediaEntity> getAll() {
        return repo.findAll();
    }

    public Optional<SocialMediaEntity> findById(Long id) throws Exception {
        try {
            Optional<SocialMediaEntity> user = repo.findById(id);
            return user;
        }catch (Exception e){
            return null;
        }
    }
    public SocialMediaEntity createSocialMedia(CreateSocialMediaDto dto){
        SocialMediaEntity social = new SocialMediaEntity();
        social.setSocial(dto.getSocialMedia());
        social.setImage(dto.getImage());
        social.setPeople(dto.getPeople());
        social.setMoney(dto.getMoney());
        return repo.save(social);
    }
    public SocialMediaEntity updateSocial(Long id, SocialMediaEntity socialMedia) throws Exception {
        try {
            return repo.findById(id)
                    .map(updateProduct-> {
                        updateProduct.setSocial(socialMedia.getSocial());
                        updateProduct.setPeople(socialMedia.getPeople());
                        updateProduct.setMoney(socialMedia.getMoney());
                        return repo.save(updateProduct);
                    }).orElseThrow( Exception::new);
        }catch (Exception e){
            return null;
        }

    }

    public void deleteById(Long id) {
        try {
            repo.deleteById(id);
        }catch (Exception e){
            return ;
        }
    }
}
