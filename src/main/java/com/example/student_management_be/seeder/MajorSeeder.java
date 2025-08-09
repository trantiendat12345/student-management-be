// package com.example.student_management_be.seeder;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.example.student_management_be.entity.Major;
// import com.example.student_management_be.repository.MajorRepository;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;

// @Component
// public class MajorSeeder implements CommandLineRunner {

//     @PersistenceContext
//     private EntityManager entityManager;

//     @Autowired
//     private MajorRepository majorRepository;

//     @Override
//     public void run(String... args) throws Exception {
//         if (isTableEmpty()) {

//             System.out.println("Major!");

//             Major informationSystem = new Major();
//             informationSystem.setDepartmentId(1L);
//             informationSystem.setMajorName("INFORMATION SYSTEM");
//             majorRepository.save(informationSystem);
            
//         }
//     }

//     private boolean isTableEmpty () {
//         Long count = (Long) entityManager.createQuery("SELECT COUNT(id) FROM Major").getSingleResult();
//         return count == 0; // bằng 0 thì true còn lại thì false.
//     }
    
// }
