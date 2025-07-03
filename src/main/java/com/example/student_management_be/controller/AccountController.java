package com.example.student_management_be.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management_be.request.AccountRequest;
import com.example.student_management_be.response.AccountResponse;
import com.example.student_management_be.service.interfaces.AccountServiceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("app")
public class AccountController {

    private final AccountServiceInterface accountServiceInterface;

    public AccountController (AccountServiceInterface accountServiceInterface) {

        this.accountServiceInterface = accountServiceInterface;

    }

    @PostMapping("login")
    public ResponseEntity<AccountResponse> login(@RequestBody AccountRequest request) {

        AccountResponse login = accountServiceInterface.login(request);
        
        return ResponseEntity.ok(login);
    }
    
    
}
