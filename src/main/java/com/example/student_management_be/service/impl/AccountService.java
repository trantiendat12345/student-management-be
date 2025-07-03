package com.example.student_management_be.service.impl;

import org.springframework.stereotype.Service;

import com.example.student_management_be.dto.AccountDTO;
import com.example.student_management_be.request.AccountRequest;
import com.example.student_management_be.response.AccountResponse;
import com.example.student_management_be.service.interfaces.AccountServiceInterface;

@Service
public class AccountService implements AccountServiceInterface {

    @Override
    public AccountResponse login (AccountRequest request) {

        try {
            
            String token = "random token";
            AccountDTO accountDTO = new AccountDTO(token, null, 12L);

            return new AccountResponse(token, accountDTO);
            
        } catch (Exception e) {
            
            throw new RuntimeException("Error: " + e.getMessage());

        }
        
    }
    
}
