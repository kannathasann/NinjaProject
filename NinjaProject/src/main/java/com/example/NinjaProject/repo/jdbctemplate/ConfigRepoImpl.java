package com.example.NinjaProject.repo.jdbctemplate;

import com.example.NinjaProject.dto.ConfigDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfigRepoImpl implements ConfigRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ConfigDto> getAllConfigs() {

        String sql = "select * from Config";
        List<ConfigDto> list = jdbcTemplate.query(sql, (resultSet, row) ->
        {
            ConfigDto configDto = new ConfigDto();
            configDto.setId(resultSet.getInt("id"));
            configDto.setAppId(resultSet.getInt("appid"));
            configDto.setFeatureId(resultSet.getInt("featureid"));
            configDto.setConfigName(resultSet.getString("configname"));
            configDto.setDescription(resultSet.getString("description"));
            configDto.setRefIDs(resultSet.getString("refIDs"));
            configDto.setRefType(resultSet.getString("refType"));

            return configDto;

        });
        return list;
    }

    @Override
    public ConfigDto getConfigValues(String name) {

        System.out.println("Fetching from database....");

        String sql = "select * from Config where configname=?";
        ConfigDto configvalues = jdbcTemplate.queryForObject(sql, (resultSet, row) ->
        {
            ConfigDto configDto = new ConfigDto();
            configDto.setId(resultSet.getInt("id"));
            configDto.setAppId(resultSet.getInt("appid"));
            configDto.setFeatureId(resultSet.getInt("featureid"));
            configDto.setConfigName(resultSet.getString("configname"));
            configDto.setDescription(resultSet.getString("description"));
            configDto.setRefIDs(resultSet.getString("refIDs"));
            configDto.setRefType(resultSet.getString("refType"));

            return configDto;

        }, name);

        return configvalues;

    }


    @Override
    public String updateConfig(String name, String refIDs) {

        String sql = "UPDATE Config SET refIDs = ? WHERE configname = ? ";
        int i = jdbcTemplate.update(sql, refIDs, name);
        if (i > 0)
            return "updated successfully...";
        else
            return "update failure..";
    }
}