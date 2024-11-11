package com.example.NinjaProject.repo.jdbctemplate;

import com.example.NinjaProject.dto.FeatureDto;

import java.util.List;

public interface FeatureRepo {

    public List<FeatureDto> getAllFeatutes();

    public List<String> listConfigBYFeature(int id);
}
