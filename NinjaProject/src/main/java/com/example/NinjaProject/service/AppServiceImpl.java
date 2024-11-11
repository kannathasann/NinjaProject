package com.example.NinjaProject.service;

import com.example.NinjaProject.dto.AppDto;
import com.example.NinjaProject.entity.AppEntity;
import com.example.NinjaProject.repo.hibernatejpadata.AppDao;
import com.example.NinjaProject.repo.jdbctemplate.AppRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    AppDao appDao;

    @Override
    public List<AppDto> getAllApps() {
        List<AppDto> appDtoList = new ArrayList<>();
        List<AppEntity> applist = appDao.findAll();
        for (AppEntity appEntity : applist) {
            AppDto appDto = new AppDto();
            BeanUtils.copyProperties(appEntity, appDto);
            appDtoList.add(appDto);
        }
        return appDtoList;
    }
}
