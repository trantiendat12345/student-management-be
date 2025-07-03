package com.example.student_management_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_management_be.entity.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
    
}
