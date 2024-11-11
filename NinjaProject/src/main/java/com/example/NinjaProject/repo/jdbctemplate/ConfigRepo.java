package com.example.NinjaProject.repo.jdbctemplate;

import com.example.NinjaProject.dto.ConfigDto;

import java.util.List;

public interface ConfigRepo {

    public List<ConfigDto> getAllConfigs();

    public ConfigDto getConfigValues(String name);

    public String updateConfig(String name, String refIDs);
}
