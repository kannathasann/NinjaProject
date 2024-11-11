package com.example.NinjaProject.exception;

import com.example.NinjaProject.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class NinjaProjectExceptionHandler {

    @ExceptionHandler(ConfigNotFoundException.class)
    public ResponseEntity<ErrorDto> getErrorResponse(ConfigNotFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode("404");
        errorDto.setErrorMessage("not_found");
        errorDto.setErrorDescription("Config not found in the db");
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);

    }
}
