package com.example.NinjaProject.repo.jdbctemplate;

import com.example.NinjaProject.dto.AppDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppRepoImpl implements AppRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<AppDto> getAllApps() {
        String sql = "select * from App";
        List<AppDto> list = jdbcTemplate.query(sql, (resultSet, row) ->
        {
            AppDto appDto = new AppDto();
            appDto.setDescription(resultSet.getString("description"));
            appDto.setId(resultSet.getInt("id"));
            appDto.setName(resultSet.getString("name"));
            return appDto;

        });
        return list;
    }
}
