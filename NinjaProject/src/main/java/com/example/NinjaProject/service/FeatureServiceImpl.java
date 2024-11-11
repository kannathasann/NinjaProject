package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.FeatureDto;
import com.example.NinjaProject.entity.FeatureEntity;
import com.example.NinjaProject.repo.hibernatejpadata.FeatureDao;
import com.example.NinjaProject.repo.jdbctemplate.FeatureRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    FeatureDao featureDao;

    @Override
    public List<FeatureDto> getAllFeatures() {
        List<FeatureDto> featureDtoList = new ArrayList<>();
        List<FeatureEntity> featureEntityList = featureDao.findAll();
        for (FeatureEntity featureEntity : featureEntityList) {
            FeatureDto featureDto = new FeatureDto();
            BeanUtils.copyProperties(featureEntity, featureDto);
            featureDtoList.add(featureDto);
        }
        return featureDtoList;
    }


    @Override
    public List<String> listConfigBYFeature(int id) {
        return featureDao.listConfigBYFeature(id);

    }

}
