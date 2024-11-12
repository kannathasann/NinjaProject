package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.ConfigDto;

import java.util.List;

public interface ConfigService {


    public List<ConfigDto> getAllConfigs();

    public ConfigDto getConfigvalues(String name);

    public ConfigDto updateConfig(String name, String refIDs);

    public String deleteConfig(String name);

    public ConfigDto createConfig(ConfigDto configDto);
}
