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
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping("/getAllFeatures")
    public ResponseEntity<List<FeatureDto>> getAllFeatures() {
        List<FeatureDto> list = featureService.getAllFeatures();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("getConfigByFeatureID/{id}")
    public ResponseEntity<List<String>> listConfigBYFeature(@PathVariable("id") int id) {
        List<String> result = featureService.listConfigBYFeature(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/addFeature")
    public ResponseEntity<FeatureDto> createFeature(@RequestBody FeatureDto featureDto) {
        FeatureDto responseDto = featureService.createFeature(featureDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateFeatureByName")
    public ResponseEntity<String> updateFeature(@RequestParam("name") String name, @RequestParam("active") boolean active) {
        String response = featureService.updateFeature(name, active);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/deleteFeatureByName")
    public ResponseEntity<String> deleteFeature(@RequestParam("name") String name) {
        String response = featureService.deleteFeature(name);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
