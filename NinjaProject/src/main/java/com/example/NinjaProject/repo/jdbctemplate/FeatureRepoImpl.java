package com.example.NinjaProject.repo.jdbctemplate;

import com.example.NinjaProject.dto.FeatureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeatureRepoImpl implements FeatureRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<FeatureDto> getAllFeatutes() {

        String sql = "select * from feature";
        List<FeatureDto> list = jdbcTemplate.query(sql, (resultSet, row) ->
        {
            FeatureDto featureDto = new FeatureDto();
            featureDto.setId(resultSet.getInt("id"));
            featureDto.setName(resultSet.getString("name"));
            featureDto.setDescription(resultSet.getString("description"));
            featureDto.setActive(resultSet.getBoolean("active"));
            featureDto.setCreatedby(resultSet.getString("createdBy"));
            featureDto.setCreateddate(resultSet.getDate("createdDate"));
            featureDto.setUpdatedby(resultSet.getString("updatedBy"));
            featureDto.setUpdateddate(resultSet.getDate("updatedDate"));
            return featureDto;
        });

        return list;

    }


    @Override
    public List<String> listConfigBYFeature(int id) {

        String sql = "SELECT c.configname FROM Config c JOIN feature f ON c.featureid = f.id WHERE f.id=?";
        List<String> configList = jdbcTemplate.query(sql, (resultSet, row) ->
        {
            String temp = resultSet.getString("configname");
            return temp;
        }, id);
        return configList;
    }
}
