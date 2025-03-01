package com.unir.books.payments.service;

import com.unir.books.payments.controller.model.PaymentRequest;
import com.unir.books.payments.data.model.Payment;

import java.util.List;


public interface PaymentsService {

    Payment createPayment(PaymentRequest request);

    Payment getPayment(String id);

    List<Payment> getPayments();
}
