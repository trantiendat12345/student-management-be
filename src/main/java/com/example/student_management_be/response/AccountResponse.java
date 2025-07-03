package com.example.student_management_be.response;

import com.example.student_management_be.dto.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponse {
    
    private final String token;
    private final AccountDTO accountDTO;
    
}
