package com.relatospapel.ms_books_payments.service;

import com.relatospapel.ms_books_payments.controller.model.PaymentRequest;
import com.relatospapel.ms_books_payments.data.model.Payment;

import java.util.List;


public interface PaymentsService {

    Payment createPayment(PaymentRequest request);

    Payment getPayment(String id);

    List<Payment> getPayments();
}
