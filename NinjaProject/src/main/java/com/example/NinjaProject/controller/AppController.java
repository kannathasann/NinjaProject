package com.example.NinjaProject.controller;

import com.example.NinjaProject.dto.AppDto;
import com.example.NinjaProject.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/getAllApps")
    public ResponseEntity<List<AppDto>> getAllApps() {
        List<AppDto> list = appService.getAllApps();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

}