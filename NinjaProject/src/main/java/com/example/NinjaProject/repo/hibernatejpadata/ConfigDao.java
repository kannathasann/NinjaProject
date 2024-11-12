package com.example.NinjaProject.repo.hibernatejpadata;

import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ConfigDao extends JpaRepository<ConfigEntity, Integer> {

//   @Query(value="select * from config where configname=?1", nativeQuery=true)
//    public ConfigEntity getConfigValues(String name);

    public ConfigEntity findByConfigName(String configName);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Config SET refIDs = ?2 WHERE configname = ?1", nativeQuery = true)
    public int updateConfig(String name, String refIDs);

    @Modifying
    @Transactional
    @Query(value="delete from Config where configname=?1", nativeQuery = true)
    public int deleteConfig(String name);




}
