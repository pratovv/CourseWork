package com.example.smartrep.service;

import com.example.smartrep.dto.CreateDistrictDto;
import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;
    public List<DistrictEntity> getAllDistrict() {
        return repo.findAll();
    }

    public Optional<DistrictEntity> getById(Long id) throws Exception {
        try {
            Optional<DistrictEntity> district = repo.findById(id);
            return district;
        }catch (Exception e){
            return null;
        }
    }

    public DistrictEntity createDistrict(CreateDistrictDto districtDto){
        DistrictEntity district = new DistrictEntity();
        district.setDistrict(districtDto.getDistrict());
        district.setPeople(districtDto.getPeople());
        district.setContribution(districtDto.getContribution());
        district.setImage(districtDto.getImage());
        return repo.save(district);
    }
    public DistrictEntity updateDistrict(Long id,DistrictEntity dist) throws Exception {
        try {
            return repo.findById(id)
                    .map(updateProduct-> {
                        updateProduct.setDistrict(dist.getDistrict());
                        updateProduct.setContribution(dist.getContribution());
                        updateProduct.setPeople(dist.getPeople());
                        return repo.save(updateProduct);
                    }).orElseThrow( Exception::new);
        }catch (Exception e){
            return null;
        }
    }
    public void deleteById(Long id) {
        try {
            repo.deleteById(id);
        }
        catch (Exception e){
            return;
        }
    }

}
