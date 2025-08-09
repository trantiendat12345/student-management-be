package com.example.student_management_be.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLRestriction;

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

@Entity
@Setter
@Getter
@Table(name = "grade")
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("is_delete = false")
public class Grade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "midterm_score")
    private float midtermScore;

    @Column(name = "final_score")
    private float finalScore;

    @Column(name = "average_score")
    private float averageScore;

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
