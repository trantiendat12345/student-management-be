package com.example.student_management_be.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.student_management_be.dto.AccountDTO;
import com.example.student_management_be.entity.Account;
import com.example.student_management_be.exception.response.ErrorResponse;
import com.example.student_management_be.repository.AccountRepository;
import com.example.student_management_be.request.AccountRequest;
import com.example.student_management_be.response.AccountResponse;
import com.example.student_management_be.security.JwtSecurity;
import com.example.student_management_be.service.base.BaseService;
import com.example.student_management_be.service.interfaces.AccountServiceInterface;

@Service
public class AccountService extends BaseService implements AccountServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private JwtSecurity jwtSecurity;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Object login (AccountRequest request) {

        try {

            Account account = accountRepository.findByUsername(request.getUsername()).orElseThrow(() -> new BadCredentialsException("Username hoặc mật khẩu không chính xác"));

            if(!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
                throw new BadCredentialsException("Username hoặc mật khẩu không chính xác");
            }
            
            AccountDTO accountDTO = new AccountDTO(account.getUsername(), account.getStudentId(), account.getTeacherId());
            String token = jwtSecurity.generateToken(account.getId(), account.getUsername(), account.getRoleId(), account.getStudentId(), account.getTeacherId());

            return new AccountResponse(token, accountDTO);
            
        } catch (BadCredentialsException badCredentialsException) {
            
            Map<String, String> errors = new HashMap<>();
            errors.put(("message"), badCredentialsException.getMessage());
            ErrorResponse errorResponse = new ErrorResponse("Có vấn đề xảy ra", errors);
            return errorResponse;

        }
        
    }
    
}
