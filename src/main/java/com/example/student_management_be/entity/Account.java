package com.example.student_management_be.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
@SQLRestriction("is_delete = false")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "status")
    private String status;

    @Column(name = "is_delete")
    private boolean isDelete;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist //goi den ham nay truoc khi insert du lieu vao database
    protected void onCreated() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate //goi den ham nay truoc khi update du lieu vao database
    protected void onUpdated() {
        updatedAt = LocalDateTime.now();
    }
    
}
