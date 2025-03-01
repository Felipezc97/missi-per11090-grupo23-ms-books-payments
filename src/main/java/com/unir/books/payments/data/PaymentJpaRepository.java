package com.unir.books.payments.data;

import com.unir.books.payments.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
