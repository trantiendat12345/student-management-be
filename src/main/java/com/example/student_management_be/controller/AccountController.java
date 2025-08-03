package com.example.student_management_be.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_be.exception.response.ErrorResponse;
import com.example.student_management_be.request.AccountRequest;
import com.example.student_management_be.response.AccountResponse;
import com.example.student_management_be.service.interfaces.AccountServiceInterface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("app")
public class AccountController {

    private final AccountServiceInterface accountServiceInterface;

    public AccountController (AccountServiceInterface accountServiceInterface) {

        this.accountServiceInterface = accountServiceInterface;

    }

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody AccountRequest request) {

        Object result = accountServiceInterface.login(request);

        if (result instanceof AccountResponse accountResponse) {

            return ResponseEntity.ok(accountResponse);
        }

        if (result instanceof ErrorResponse errorResponse) {

            return ResponseEntity.unprocessableEntity().body(errorResponse);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("NetWork Error");
        
    }
    
    
}
