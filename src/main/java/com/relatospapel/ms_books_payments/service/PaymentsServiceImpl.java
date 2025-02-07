package com.relatospapel.ms_books_payments.service;

import com.relatospapel.ms_books_payments.controller.model.PaymentRequest;
import com.relatospapel.ms_books_payments.data.PaymentJpaRepository;
import com.relatospapel.ms_books_payments.data.model.Payment;
import com.relatospapel.ms_books_payments.facade.BooksFacade;
import com.relatospapel.ms_books_payments.facade.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaymentsServiceImpl implements PaymentsService {

    private BooksFacade booksFacade;

    private PaymentJpaRepository repository;

    @Override
    public Payment createPayment(PaymentRequest request) {

        List<Book> books = request.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).toList();

        if (books.size() != request.getBooks().size() || books.stream().anyMatch(book -> !book.getVisible() || book.getStock() <= 0)) {
            return null;
        } else {
            Payment payment = Payment.builder().books(books.stream().map(Book::getId).collect(Collectors.toList())).build();
            repository.save(payment);
            return payment;
        }
    }

    @Override
    public Payment getPayment(String id) {
        return repository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<Payment> getPayments() {
        List<Payment> payments = repository.findAll();
        return payments.isEmpty() ? null : payments;
    }
}
