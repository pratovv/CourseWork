package com.example.smartrep.service;

import com.example.smartrep.entity.DistrictEntity;
import com.example.smartrep.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;
    public List<DistrictEntity> getAllDistrict() {
        return repo.findAll();
    }
    public DistrictEntity updateDistrict(Short id,DistrictEntity dist) throws Exception {
        return repo.findById(id)
                .map(updateProduct-> {
                    updateProduct.setLenin(dist.getLenin());
                    updateProduct.setOktyab(dist.getOktyab());
                    updateProduct.setPerv(dist.getPerv());
                    updateProduct.setSverd(dist.getSverd());
                    return repo.save(updateProduct);
                }).orElseThrow( Exception::new);
    }
}
