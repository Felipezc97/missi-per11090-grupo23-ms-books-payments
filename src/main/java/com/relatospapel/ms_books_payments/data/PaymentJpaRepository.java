package com.relatospapel.ms_books_payments.data;

import com.relatospapel.ms_books_payments.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
