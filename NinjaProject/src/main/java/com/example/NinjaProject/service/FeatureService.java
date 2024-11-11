package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.AppDto;
import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.dto.FeatureDto;

import java.util.List;

public interface FeatureService {

    public List<FeatureDto> getAllFeatures();

    public List<String> listConfigBYFeature(int id);
}
