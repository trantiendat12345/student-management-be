package com.example.student_management_be.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig { // lấy ra thông tin từ application.properties
    
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expriration;

    public Long getExpriration() {
        return expriration;
    }

    public String getSecretKey() {
        return secretKey;
    }
    
}
