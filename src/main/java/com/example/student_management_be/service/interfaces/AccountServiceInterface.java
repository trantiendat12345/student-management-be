package com.example.student_management_be.service.interfaces;

import com.example.student_management_be.request.AccountRequest;
import com.example.student_management_be.response.AccountResponse;

public interface AccountServiceInterface {
    
    AccountResponse login (AccountRequest request);
    
}
