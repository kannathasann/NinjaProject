package com.example.NinjaProject.repo.jdbctemplate;

import com.example.NinjaProject.dto.AppDto;

import java.util.List;

public interface AppRepo {
    public List<AppDto> getAllApps();
}
