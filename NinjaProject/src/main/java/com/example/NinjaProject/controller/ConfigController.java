package com.example.NinjaProject.controller;

import com.example.NinjaProject.common.CommonMethods;
import com.example.NinjaProject.dto.ConfigDto;
import com.example.NinjaProject.dto.ErrorDto;
import com.example.NinjaProject.exception.ConfigNotFoundException;
import com.example.NinjaProject.service.ConfigService;
import jakarta.validation.Valid;
import org.modelmapper.internal.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConfigController {

    @Autowired
    ConfigService configService;

    @Autowired
    CommonMethods commonMethods;

    @GetMapping("/getAllConfigs")
    public ResponseEntity<List<ConfigDto>> getAllConfigs() {
        List<ConfigDto> list = configService.getAllConfigs();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/config/{configName}")
    public ResponseEntity<?> getConfigvalues(@PathVariable("configName") String name) {
        ConfigDto configDto = configService.getConfigvalues(name);
       if(configDto==null)
       {
//           ErrorDto errorDto = new ErrorDto();
//           errorDto.setErrorCode("404");
//           errorDto.setErrorMessage("not_found");
//           errorDto.setErrorDescription("Config not found in the db");
//           return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
           throw new ConfigNotFoundException("not-found");
       }
//        ConfigDto configDto = commonMethods.getConfigvalues(name);


        return new ResponseEntity<>(configDto, HttpStatus.OK);

    }


    @PutMapping("updateConfig/{configName}")
    public ResponseEntity<String> updateConfig(@PathVariable("configName") String name, @RequestParam("refIDs") String refIDs) {
        String result = configService.updateConfig(name, refIDs);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("deleteConfig")
    public ResponseEntity<String> deleteConfig(@RequestParam("configname") String name) {
        String result = configService.deleteConfig(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("createConfig")
    public ResponseEntity<?> createConfig(@Valid  @RequestBody ConfigDto configDto, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            StringBuilder stringBuilder= new StringBuilder();
           for( FieldError fieldError:bindingResult.getFieldErrors())
           {
               stringBuilder.append(fieldError.getField()+ "-->"+fieldError.getDefaultMessage());

           }
            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorCode("101");
            errorDto.setErrorMessage("validation failed");
            errorDto.setErrorDescription(stringBuilder.toString());
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);

        }

        ConfigDto savedconfigDto = configService.createConfig(configDto);


        return new ResponseEntity<>(savedconfigDto, HttpStatus.OK);
    }


}
