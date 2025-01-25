package com.example.librarymanagement.repository;



import com.example.librarymanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStudent_Id(Long studentId); // Tələbəyə görə sifarişləri tapmaq
    List<Order> findByBook_Id(Long bookId); // Kitaba görə sifarişləri tapmaq
}

