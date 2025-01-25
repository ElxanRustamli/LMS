package com.example.librarymanagement.repository;



import com.example.librarymanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods if needed
}
