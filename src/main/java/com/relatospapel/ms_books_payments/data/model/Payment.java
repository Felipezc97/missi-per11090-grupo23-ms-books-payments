package com.relatospapel.ms_books_payments.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "method")
    private String method;

    @Column(name = "total_amount")
    private double totalAmount;

    @ElementCollection
    @Column(name = "books")
    private List<Long> books;
}
