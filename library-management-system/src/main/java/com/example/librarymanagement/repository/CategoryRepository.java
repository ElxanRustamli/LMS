package com.example.librarymanagement.repository;



import com.example.librarymanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query methods can be added if necessary
}
