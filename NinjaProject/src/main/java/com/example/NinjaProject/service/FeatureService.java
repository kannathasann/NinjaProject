package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.AppDto;
import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.dto.FeatureDto;
import com.example.NinjaProject.entity.FeatureEntity;

import java.util.List;

public interface FeatureService {

    public List<FeatureDto> getAllFeatures();

    public List<String> listConfigBYFeature(int id);

    public FeatureDto createFeature(FeatureDto featureDto);

    public String updateFeature(String name, boolean active);

    public String deleteFeature(String name);
}
