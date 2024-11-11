package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.AppDto;
import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.entity.AppEntity;
import com.example.NinjaProject.entity.ConfigEntity;
import com.example.NinjaProject.exception.ConfigNotFoundException;
import com.example.NinjaProject.repo.hibernatejpadata.ConfigDao;
import com.example.NinjaProject.repo.jdbctemplate.ConfigRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigDao configDao;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Override
    public List<ConfigDto> getAllConfigs() {

        List<ConfigDto> configDtoList = new ArrayList<>();
        List<ConfigEntity> configEntityList = configDao.findAll();
        for (ConfigEntity configEntity : configEntityList) {
            ConfigDto configDto = new ConfigDto();
            BeanUtils.copyProperties(configEntity, configDto);
            configDtoList.add(configDto);
        }
        return configDtoList;
    }

    @Override
    @Cacheable(value = "configCache", key = "#name")
    public ConfigDto getConfigvalues(String name) {
        ConfigDto configDto = new ConfigDto();
        if (redisTemplate.hasKey(name)) {
            logger.info("get data from redis, Cache hit for config name: {}", name);
        } else {
            logger.info("get data from external db,Cache miss for config name: {}", name);
        }
        ConfigEntity configEntity = configDao.getConfigValues(name);
     if(configEntity==null)
         throw new ConfigNotFoundException("not_found...");


        BeanUtils.copyProperties(configEntity, configDto);
        logger.info("Fetching Config data from external DB........");
        return configDto;
    }

    @Override
    @CacheEvict(value = "configCache", key = "#name")
    public String updateConfig(String name, String refIDs) {

        int i = configDao.updateConfig(name, refIDs);
        if (i > 0)
            return "updated successfully...";
        else
            return "update failure..";
    }

    @Override
    @CacheEvict(value = "configCache", key = "#name")
    public String deleteConfig(String name) {
        int i = configDao.deleteConfig(name);
        if (i > 0)
            return "no. of rows deleted successfully.." + i;
        else
            return "no record is present..";
    }

    public ConfigDto createConfig(ConfigDto configDto) {
        ConfigEntity configEntity = modelMapper.map(configDto, ConfigEntity.class);

        ConfigEntity savedEntity = configDao.save(configEntity);

        ConfigDto responseDto= modelMapper.map(savedEntity, ConfigDto.class);
        redisTemplate.opsForValue().set(responseDto.getConfigName(), responseDto);
        return responseDto;

    }


}