package com.example.NinjaProject.common;

import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.entity.ConfigEntity;
import com.example.NinjaProject.repo.hibernatejpadata.ConfigDao;
import com.example.NinjaProject.repo.jdbctemplate.ConfigRepo;
import com.example.NinjaProject.service.ConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CommonMethods {

    @Autowired
    ConfigDao configDao;

    @Cacheable(value = "configCache", key = "#name")
    public ConfigDto getConfigvalues(String name) {
        ConfigDto configDto = new ConfigDto();
//        ConfigEntity configEntity = configDao.getConfigValues(name);
        ConfigEntity configEntity=configDao.findByConfigName(name);
        BeanUtils.copyProperties(configEntity, configDto);
        return configDto;
    }
}
