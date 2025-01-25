package com.example.librarymanagement.service;



import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Order;
import com.example.librarymanagement.model.Student;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.OrderRepository;
import com.example.librarymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Long studentId, Long bookId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getStock() <= 0) {
            throw new RuntimeException("Book is out of stock");
        }

        Order order = new Order();
        order.setStudent(student);
        order.setBook(book);
        order.setOrderTimestamp(LocalDateTime.now());
        order.setReturned(false);

        // Stokdan 1 çıx
        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        return orderRepository.save(order);
    }

    public Order returnOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.isReturned()) {
            throw new RuntimeException("Order is already returned");
        }

        order.setReturnTimestamp(LocalDateTime.now());
        order.setReturned(true);

        // Stoku artır
        Book book = order.getBook();
        book.setStock(book.getStock() + 1);
        bookRepository.save(book);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

