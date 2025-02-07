package com.relatospapel.ms_books_payments.controller;

import com.relatospapel.ms_books_payments.controller.model.PaymentRequest;
import com.relatospapel.ms_books_payments.data.model.Payment;
import com.relatospapel.ms_books_payments.service.PaymentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentsController {

    private final PaymentsService service;

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody @Valid PaymentRequest request) {

        log.info("Creating payment...");
        Payment created = service.createPayment(request);

        if (created != null) {
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getPayments() {

        List<Payment> payments = service.getPayments();
        if (payments != null) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable String id) {

        Payment payment = service.getPayment(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
