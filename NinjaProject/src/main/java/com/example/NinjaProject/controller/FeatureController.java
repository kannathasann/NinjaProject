package com.example.NinjaProject.controller;

import com.example.NinjaProject.common.CommonMethods;
import com.example.NinjaProject.dto.AppDto;
import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.dto.FeatureDto;
import com.example.NinjaProject.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping("/getAllFeatures")
    public ResponseEntity<List<FeatureDto>> getAllFeatures() {
        List<FeatureDto> list = featureService.getAllFeatures();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("feature/{id}")
    public ResponseEntity<List<String>> listConfigBYFeature(@PathVariable("id") int id) {
        List<String> result = featureService.listConfigBYFeature(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
