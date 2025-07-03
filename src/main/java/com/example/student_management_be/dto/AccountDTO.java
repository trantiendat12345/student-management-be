package com.example.student_management_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

    private final String username;
    private final Long studentId;
    private final Long teacherId;
    
}
