package com.example.student_management_be.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class AccountRequest {

    @Email(message = "Email không đúng định dạng")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Size(min = 6, message = "Mật khẩu phải có từ 6 kí tự")
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;
    
}
