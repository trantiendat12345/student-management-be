// package com.example.student_management_be.seeder;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.example.student_management_be.entity.Teaching;
// import com.example.student_management_be.repository.TeachingRepository;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;

// @Component
// public class TeachingSeeder implements CommandLineRunner {

//     @PersistenceContext
//     private EntityManager entityManager;

//     @Autowired
//     private TeachingRepository teachingRepository;

//     @Override
//     public void run(String... args) throws Exception {
        
//         if (isTableEmpty()) {

//             System.out.println("Teaching!");

//             Teaching teacherMath = new Teaching();
//             teacherMath.setTeacherId(1L);
//             teacherMath.setSubjectId(1L);
//             teacherMath.setSemester("I");
//             teacherMath.setAcademicYear("2025-2026");
//             teachingRepository.save(teacherMath);
            
//         }
        
//     }

//     private boolean isTableEmpty () {
//         Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Teaching").getSingleResult();
//         return count == 0; // bằng 0 thì true còn lại thì false.
//     }
    
// }
