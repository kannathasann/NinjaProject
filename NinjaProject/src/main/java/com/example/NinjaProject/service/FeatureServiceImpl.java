package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.FeatureDto;
import com.example.NinjaProject.entity.FeatureEntity;
import com.example.NinjaProject.repo.hibernatejpadata.FeatureDao;
import com.example.NinjaProject.repo.jdbctemplate.FeatureRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    FeatureDao featureDao;

    @Autowired
    ModelMapper modelMapper;

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

    @Override
    public FeatureDto createFeature(FeatureDto featureDto) {

        FeatureEntity featureEntity=modelMapper.map(featureDto, FeatureEntity.class);
        FeatureEntity savedEntity=featureDao.save(featureEntity);

        FeatureDto responseDto=modelMapper.map(savedEntity, FeatureDto.class);
        return responseDto;

    }

    @Override
    public String updateFeature(String name, boolean active) {
        int i=featureDao.updateFeature(name, active);
        if(i>0 && active==true)
            return ""+name+" enabled sucessfullyy..";
        if(i>0 && active==false)
            return ""+name+" disabled sucessfullyy..";
        else return "updation failure..";

    }

    @Override
    public String deleteFeature(String name) {
        int i=featureDao.deleteFeature(name);
        if(i>0)
            return ""+name+" deleted successfully..";
        else return "deletion failure..";
    }

}
