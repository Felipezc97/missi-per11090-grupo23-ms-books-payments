package com.unir.books.payments.service;

import com.unir.books.payments.controller.model.PaymentRequest;
import com.unir.books.payments.data.PaymentJpaRepository;
import com.unir.books.payments.data.model.Payment;
import com.unir.books.payments.facade.BooksFacade;
import com.unir.books.payments.facade.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaymentsServiceImpl implements PaymentsService {

    private final BooksFacade booksFacade;

    private final PaymentJpaRepository repository;

    @Override
    public Payment createPayment(PaymentRequest request) {

        List<Book> books = request.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).toList();

        if (books.size() != request.getBooks().size() || books.stream().anyMatch(book -> !book.getVisible() || book.getStock() <= 0)) {
            return null;
        } else {
            Payment payment = Payment.builder().date(request.getDate()).status(request.getStatus()).method(request.getMethod()).totalAmount(request.getTotalAmount()).books(books.stream().map(Book::getId).collect(Collectors.toList())).build();
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
