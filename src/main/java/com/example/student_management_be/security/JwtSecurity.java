package com.example.student_management_be.security;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.student_management_be.config.JwtConfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtSecurity {
    
    private final JwtConfig jwtConfig;
    private final Key key;

    public JwtSecurity (JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(jwtConfig.getSecretKey().getBytes()));
    }
    
    // tạo chuỗi token
    public String generateToken (Long accountId, String username, int roleId, Long studentId, Long teacherId) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtConfig.getExpriration());

        return Jwts.builder()
            .setSubject(String.valueOf(accountId))
            .claim("username", username)
            .claim("roleId", roleId)
            .claim("studentId", studentId)
            .claim("teacherId", teacherId)
            .setIssuedAt(now)
            .setExpiration(expirationDate)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }
    
}
