package com.example.librarymanagement.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student; // Tələbə ilə əlaqə

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; // Kitab ilə əlaqə

    private LocalDateTime orderTimestamp; // Sifariş vaxtı

    private LocalDateTime returnTimestamp; // Qaytarılma vaxtı

    private boolean returned; // Qaytarılıb-qaytarılmayıb statusu
}

